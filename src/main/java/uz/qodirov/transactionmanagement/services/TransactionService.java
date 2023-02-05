package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.transaction.ScoreDTO;
import uz.qodirov.transactionmanagement.dto.transaction.TransactionCreateDTO;
import uz.qodirov.transactionmanagement.entity.Carrier;
import uz.qodirov.transactionmanagement.entity.Offer;
import uz.qodirov.transactionmanagement.entity.Request;
import uz.qodirov.transactionmanagement.entity.Transaction;
import uz.qodirov.transactionmanagement.mapper.TransactionMapper;
import uz.qodirov.transactionmanagement.repository.CarrierRepository;
import uz.qodirov.transactionmanagement.repository.OfferRepository;
import uz.qodirov.transactionmanagement.repository.RequestRepository;
import uz.qodirov.transactionmanagement.repository.TransactionRepository;

import java.util.*;

/**
 * @author: Saidjalol Qodirov 2/5/2023 8:17 PM
 */
@Service
public class TransactionService extends AbstractService<TransactionRepository, TransactionMapper> {

    private final CarrierRepository carrierRepository;

    private final OfferRepository offerRepository;

    private final RequestRepository requestRepository;

    protected TransactionService(TransactionRepository repository, TransactionMapper mapper, CarrierRepository carrierRepository, OfferRepository offerRepository, RequestRepository requestRepository) {
        super(repository, mapper);
        this.carrierRepository = carrierRepository;
        this.offerRepository = offerRepository;
        this.requestRepository = requestRepository;
    }

    public ResponseEntity<?> addTransaction(TransactionCreateDTO dto) {
        Optional<Carrier> optionalCarrier = carrierRepository.findByCarrierName(dto.getCarrierName());
        if (optionalCarrier.isEmpty()) return ResponseEntity.badRequest().body("carrier not found");
        Optional<Offer> optionalOffer = offerRepository.findById(dto.getOfferId());
        if (optionalOffer.isEmpty()) return ResponseEntity.badRequest().body("offer not found");
        Optional<Request> optionalRequest = requestRepository.findById(dto.getRequestId());
        if (optionalRequest.isEmpty()) return ResponseEntity.badRequest().body("request not found");
        if (repository.existsByOfferIdOrRequestId(dto.getOfferId(), dto.getRequestId()))
            return ResponseEntity.badRequest().body("this request or offer already connected other transaction");
        Offer offer = optionalOffer.get();
        Request request = optionalRequest.get();
        if (!Objects.equals(offer.getProductId(), request.getProductId()))
            return ResponseEntity.badRequest().body("offer productId not equal request productId");
        Carrier carrier = optionalCarrier.get();
        int count = repository.withinTheService(Arrays.asList(request.getPlace().getRegion().getId(), offer.getPlace().getRegion().getId()));
        if (!Objects.equals(request.getPlace().getRegion().getId(), offer.getPlace().getRegion().getId()) && count != 2)
            return ResponseEntity.badRequest().body("the transaction is not within the scope of the carrier's service");
        Transaction transaction = new Transaction();
        transaction.setCarrier(carrier);
        transaction.setOffer(offer);
        transaction.setRequest(request);
        Transaction save = repository.save(transaction);
        return getById(save.getId());
    }

    public ResponseEntity<?> evaluateTransaction(ScoreDTO score) {
        if (score.getScore() < 1 || score.getScore() > 10)
            return ResponseEntity.badRequest().body("score must be between 1 and 10");
        Optional<Transaction> optionalTransaction = repository.findById(score.getTransactionId());
        if (optionalTransaction.isEmpty())
            return ResponseEntity.badRequest().body("transaction not found");
        Transaction transaction = optionalTransaction.get();
        transaction.setScore(score.getScore());
        repository.save(transaction);
        return getById(transaction.getId());
    }

    public ResponseEntity<?> getAll() {
        List<Transaction> transactionList = repository.findAll();
        List<HashMap<String, String>> response = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", transaction.getId().toString());
            hashMap.put("carrierName", transaction.getCarrier().getCarrierName());
            hashMap.put("score", transaction.getScore() + "");
            response.add(hashMap);
        }
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> getById(Long id) {
        Optional<Transaction> optionalTransaction = repository.findById(id);
        Transaction transaction = optionalTransaction.get();
        List<HashMap<String, String>> response = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", transaction.getId().toString());
        hashMap.put("carrierName", transaction.getCarrier().getCarrierName());
        hashMap.put("score", transaction.getScore() + "");
        response.add(hashMap);

        return ResponseEntity.ok(response);
    }
}
