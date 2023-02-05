package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.qodirov.transactionmanagement.dto.offer.OfferCreateDTO;
import uz.qodirov.transactionmanagement.dto.request.RequestCreateDTO;
import uz.qodirov.transactionmanagement.services.OfferService;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:41 PM
 */
@RestController
@RequestMapping("/request")
public class OfferController extends AbstractController<OfferService> {
    public OfferController(OfferService service) {
        super(service);
    }

    @PostMapping("/addOffert")
    public ResponseEntity<?> addRequest(@RequestBody OfferCreateDTO createDTO) {
        return service.addOffer(createDTO);
    }
}
