package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.qodirov.transactionmanagement.dto.transaction.ScoreDTO;
import uz.qodirov.transactionmanagement.dto.transaction.TransactionCreateDTO;
import uz.qodirov.transactionmanagement.services.TransactionService;

/**
 * @author: Saidjalol Qodirov 2/5/2023 8:16 PM
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractController<TransactionService> {
    public TransactionController(TransactionService service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addTransaction(@RequestBody TransactionCreateDTO dto) {
        return service.addTransaction(dto);
    }

    @PutMapping("/evaluateTransaction")
    public ResponseEntity<?> evaluateTransaction(@RequestBody ScoreDTO score) {
        return service.evaluateTransaction(score);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getbyId(@PathVariable Long id) {
        return service.getById(id);
    }
}
