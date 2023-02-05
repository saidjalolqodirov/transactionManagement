package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.qodirov.transactionmanagement.services.StatisticsService;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:42 PM
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController extends AbstractController<StatisticsService> {
    public StatisticsController(StatisticsService service) {
        super(service);
    }

    @GetMapping("/deliveryRegionsPerNT")
    public ResponseEntity<?> deliveryRegionsPerNT() {
        return service.deliveryRegionsPerNT();
    }

    @GetMapping("/scorePerCarrier/{minimumScore}")
    public ResponseEntity<?> scorePerCarrier(@PathVariable Integer minimumScore) {
        return service.scorePerCarrier(minimumScore);
    }
    @GetMapping("/nTPerProduct")
    public ResponseEntity<?> nTPerProduct() {
        return service.nTPerProduct();
    }
}
