package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.request.RequestCreateDTO;
import uz.qodirov.transactionmanagement.dto.request.RequestDTO;
import uz.qodirov.transactionmanagement.entity.Place;
import uz.qodirov.transactionmanagement.entity.Request;
import uz.qodirov.transactionmanagement.mapper.RequestMapper;
import uz.qodirov.transactionmanagement.repository.PlaceRepository;
import uz.qodirov.transactionmanagement.repository.RequestRepository;

import java.util.Optional;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:08 PM
 */
@Service
public class RequestService extends AbstractService<RequestRepository, RequestMapper> {

    private final PlaceRepository placeRepository;

    protected RequestService(RequestRepository repository, RequestMapper mapper, PlaceRepository placeRepository) {
        super(repository, mapper);
        this.placeRepository = placeRepository;
    }

    public ResponseEntity<?> addRequest(RequestCreateDTO createDTO) {
        Optional<Place> optionalPlace = placeRepository.findByName(createDTO.getPlaceName());
        if (optionalPlace.isEmpty()) return ResponseEntity.badRequest().body("place not found");
        Request request = mapper.fromCreateDto(createDTO);
        request.setPlace(optionalPlace.get());
        Request save = repository.save(request);
        RequestDTO requestDTO = mapper.toDto(save);
        requestDTO.setPlaceName(save.getPlace().getName());
        return ResponseEntity.ok(requestDTO);
    }
}
