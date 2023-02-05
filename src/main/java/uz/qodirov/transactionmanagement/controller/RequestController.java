package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.qodirov.transactionmanagement.dto.request.RequestCreateDTO;
import uz.qodirov.transactionmanagement.services.RequestService;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:07 PM
 */
@RestController
@RequestMapping("/request")
public class RequestController extends AbstractController<RequestService> {

    public RequestController(RequestService service) {
        super(service);
    }

    @PostMapping("/addRequest")
    public ResponseEntity<?> addRequest(@RequestBody RequestCreateDTO createDTO) {
        return service.addRequest(createDTO);
    }
}
