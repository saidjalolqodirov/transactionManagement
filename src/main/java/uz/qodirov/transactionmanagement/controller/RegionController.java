package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.qodirov.transactionmanagement.dto.region.RegionCreateDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionUpdateDTO;
import uz.qodirov.transactionmanagement.services.RegionService;

import javax.validation.Valid;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:00 AM
 */
@RestController
@RequestMapping("/region")
public class RegionController extends AbstractController<RegionService> {
    public RegionController(RegionService service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RegionCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid RegionUpdateDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
