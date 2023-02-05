package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.place.PlaceCreateDTO;
import uz.qodirov.transactionmanagement.dto.place.PlaceDTO;
import uz.qodirov.transactionmanagement.entity.Place;
import uz.qodirov.transactionmanagement.entity.Region;
import uz.qodirov.transactionmanagement.mapper.PlaceMapper;
import uz.qodirov.transactionmanagement.repository.PlaceRepository;
import uz.qodirov.transactionmanagement.repository.RegionRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:39 AM
 */
@Service
public class PlaceService extends AbstractService<PlaceRepository, PlaceMapper> implements BaseService {

    private final RegionRepository regionRepository;

    protected PlaceService(PlaceRepository repository, PlaceMapper mapper, RegionRepository regionRepository) {
        super(repository, mapper);
        this.regionRepository = regionRepository;
    }

    public ResponseEntity<?> create(PlaceCreateDTO dto) {

        if (repository.existsByName(dto.getName())) return ResponseEntity.badRequest().body("this place already exist");


        Optional<Region> optionalRegion = regionRepository.findById(dto.getRegionId());
        if (optionalRegion.isEmpty()) return ResponseEntity.badRequest().body("region not found");

        Place place = mapper.fromCreateDto(dto);
        place.setRegion(optionalRegion.get());

        return ResponseEntity.ok(mapper.toDto(repository.save(place)));
    }

    public ResponseEntity<?> getPlacesInRegion(Long regionId) {
        List<Place> places = repository.findAllByRegionIdAndDeletedFalseOrderByNameAsc(regionId);
        return ResponseEntity.ok(mapper.toDto(places));
    }

    public ResponseEntity<?> getAllPlaces() {
        List<Place> placeList = repository.findAllByDeletedFalseOrderByName();
        return ResponseEntity.ok(mapper.toDto(placeList));
    }

    public ResponseEntity<?> deleteById(Long id) {
        Optional<Place> optionalPlace = repository.findById(id);
        if (optionalPlace.isEmpty()) return ResponseEntity.badRequest().body("place not found");
        Place place = optionalPlace.get();
        place.setDeleted(true);
        repository.save(place);
        return ResponseEntity.ok("successfully deleted");
    }

    public List<PlaceDTO> getPlacesDTOSInRegion(Long regionId) {
        List<Place> places = repository.findAllByRegionIdAndDeletedFalseOrderByNameAsc(regionId);
        return mapper.toDto(places);
    }

    public void deleteByRegionId(Long id) {
        List<Place> placeList = repository.findAllByRegionIdAndDeletedFalseOrderByNameAsc(id);
        placeList.forEach(o -> o.setDeleted(true));
        repository.saveAll(placeList);
    }
}
