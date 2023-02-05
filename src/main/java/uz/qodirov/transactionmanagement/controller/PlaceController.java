package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.qodirov.transactionmanagement.dto.place.PlaceCreateDTO;
import uz.qodirov.transactionmanagement.services.PlaceService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:39 AM
 */
@RestController
@RequestMapping("/place")
public class PlaceController extends AbstractController<PlaceService> {
    public PlaceController(PlaceService service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PlaceCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/getPlacesInRegion/{regionId}")
    public ResponseEntity<?> getPlacesInRegion(@PathVariable @NotNull Long regionId) {
        return service.getPlacesInRegion(regionId);
    }

    @GetMapping("/getAllPlaces")
    public ResponseEntity<?> getAllPlaces() {
        return service.getAllPlaces();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
