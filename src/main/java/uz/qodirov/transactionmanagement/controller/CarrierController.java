package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.qodirov.transactionmanagement.dto.carrier.CarrierCreateDTO;
import uz.qodirov.transactionmanagement.services.CarrierService;

import javax.validation.Valid;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:01 PM
 */
@RestController
@RequestMapping("/carrier")
public class CarrierController extends AbstractController<CarrierService> {
    public CarrierController(CarrierService service) {
        super(service);
    }

    @PostMapping("/addCarrier")
    public ResponseEntity<?> addCarrier(@RequestBody @Valid CarrierCreateDTO createDTO) {
        return service.addCarrier(createDTO);
    }

    @GetMapping("/getCarriersForRegion/{regionName}")
    public ResponseEntity<?> getCarriersForRegion(@PathVariable String regionName) {
        return service.getCarriersForRegion(regionName);
    }

    @GetMapping("/getALL")
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }
}
