package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierCreateDTO;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierDTO;
import uz.qodirov.transactionmanagement.entity.Carrier;
import uz.qodirov.transactionmanagement.entity.Region;
import uz.qodirov.transactionmanagement.mapper.CarrierMapper;
import uz.qodirov.transactionmanagement.mapper.RegionMapper;
import uz.qodirov.transactionmanagement.repository.CarrierRepository;
import uz.qodirov.transactionmanagement.repository.RegionRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:01 PM
 */
@Service
public class CarrierService extends AbstractService<CarrierRepository, CarrierMapper> {

    private final RegionRepository regionRepository;

    private final RegionMapper regionMapper;

    protected CarrierService(CarrierRepository repository, CarrierMapper mapper, RegionRepository regionRepository, RegionMapper regionMapper) {
        super(repository, mapper);
        this.regionRepository = regionRepository;
        this.regionMapper = regionMapper;
    }

    public ResponseEntity<?> addCarrier(CarrierCreateDTO createDTO) {
        List<Region> regionList = regionRepository.findByIds(createDTO.getRegionIds());
        if (createDTO.getRegionIds().isEmpty() || regionList.isEmpty())
            return ResponseEntity.badRequest().body("regions is empty");
        Carrier carrier = mapper.fromCreateDto(createDTO);
        carrier.setRegions(regionList);
        repository.save(carrier);
        CarrierDTO carrierDTO = mapper.toDto(carrier);
        carrierDTO.setRegionList(regionMapper.toDto(carrier.getRegions()));
        return ResponseEntity.ok(carrierDTO);
    }

    public ResponseEntity<?> getCarriersForRegion(String name) {
        Optional<Region> optionalRegion = regionRepository.findByName(name);
        if (optionalRegion.isEmpty()) return ResponseEntity.badRequest().body("regions is empty");
        Region region = optionalRegion.get();
        List<Carrier> carriers = repository.findCarriersByRegionId(region.getId());
        List<CarrierDTO> carrierDTOS = mapper.toDto(carriers);
        for (Carrier carrier : carriers) {
            carrierDTOS.forEach(o -> o.setRegionList(regionMapper.toDto(carrier.getRegions())));
        }
        return ResponseEntity.ok(carrierDTOS);
    }

    public ResponseEntity<?> getAll() {
        List<Carrier> carriers = repository.findAll();
        List<Carrier> list = carriers.stream().sorted(Comparator.comparing(Carrier::getFirstName)).toList();
        List<CarrierDTO> carrierDTOS = mapper.toDto(list);
        for (Carrier carrier : carriers) {
            carrierDTOS.forEach(o -> o.setRegionList(regionMapper.toDto(carrier.getRegions())));
        }
        return ResponseEntity.ok(carrierDTOS);
    }
}
