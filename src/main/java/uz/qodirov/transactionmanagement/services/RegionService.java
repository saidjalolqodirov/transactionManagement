package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.region.RegionCreateDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Region;
import uz.qodirov.transactionmanagement.mapper.RegionMapper;
import uz.qodirov.transactionmanagement.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:00 AM
 */
@Service
public class RegionService extends AbstractService<RegionRepository, RegionMapper> {

    private final PlaceService placeService;

    protected RegionService(RegionRepository repository, RegionMapper mapper, PlaceService placeService) {
        super(repository, mapper);
        this.placeService = placeService;
    }

    public ResponseEntity<?> create(RegionCreateDTO dto) {
        if (repository.existsByName(dto.getName()))
            return ResponseEntity.badRequest().body("this region already exist");
        Region region = mapper.fromCreateDto(dto);
        return ResponseEntity.ok(mapper.toDto(repository.save(region)));
    }

    public ResponseEntity<?> getAll() {
        List<Region> regionList = repository.getAll();
        List<RegionDTO> regionDTOS = mapper.toDto(regionList);
        regionDTOS.forEach(o -> o.setPlaces(placeService.getPlacesDTOSInRegion(o.getId())));
        return ResponseEntity.ok(regionDTOS);
    }

    public ResponseEntity<?> update(RegionUpdateDTO dto) {
        Optional<Region> optionalRegion = repository.findById(dto.getId());
        if (optionalRegion.isEmpty()) return ResponseEntity.accepted().body("region not found");
        if (repository.existsByName(dto.getName())) return ResponseEntity.accepted().body("this region already exist");
        Region region = optionalRegion.get();
        region.setName(dto.getName());
        repository.save(region);
        return ResponseEntity.ok(mapper.toDto(region));
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Region> optionalRegion = repository.findById(id);
        if (optionalRegion.isEmpty()) return ResponseEntity.accepted().body("region not found");
        Region region = optionalRegion.get();
        region.setDeleted(true);
        placeService.deleteByRegionId(region.getId());
        return ResponseEntity.ok("successfully deleted");
    }
}
