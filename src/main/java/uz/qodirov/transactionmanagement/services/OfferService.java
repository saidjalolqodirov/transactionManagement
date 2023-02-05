package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.offer.OfferCreateDTO;
import uz.qodirov.transactionmanagement.dto.offer.OfferDTO;
import uz.qodirov.transactionmanagement.entity.Offer;
import uz.qodirov.transactionmanagement.entity.Place;
import uz.qodirov.transactionmanagement.mapper.OfferMapper;
import uz.qodirov.transactionmanagement.repository.OfferRepository;
import uz.qodirov.transactionmanagement.repository.PlaceRepository;

import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:42 PM
 */
@Service
public class OfferService extends AbstractService<OfferRepository, OfferMapper> {

    private final PlaceRepository placeRepository;

    protected OfferService(OfferRepository repository, OfferMapper mapper, PlaceRepository placeRepository) {
        super(repository, mapper);
        this.placeRepository = placeRepository;
    }

    public ResponseEntity<?> addOffer(OfferCreateDTO createDTO) {
        Optional<Place> optionalPlace = placeRepository.findByName(createDTO.getPlaceName());
        if (optionalPlace.isEmpty()) return ResponseEntity.badRequest().body("place not found");
        Offer request = mapper.fromCreateDto(createDTO);
        request.setPlace(optionalPlace.get());
        Offer save = repository.save(request);
        OfferDTO offerDTO = mapper.toDto(save);
        offerDTO.setPlaceName(save.getPlace().getName());
        return ResponseEntity.ok(offerDTO);
    }
}
