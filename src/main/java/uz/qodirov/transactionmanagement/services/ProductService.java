package uz.qodirov.transactionmanagement.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.qodirov.transactionmanagement.dto.product.ProductCreateDTO;
import uz.qodirov.transactionmanagement.entity.Product;
import uz.qodirov.transactionmanagement.mapper.ProductMapper;
import uz.qodirov.transactionmanagement.repository.ProductRepository;

/**
 * @author: Saidjalol Qodirov 2/5/2023 6:57 PM
 */
@Service
public class ProductService extends AbstractService<ProductRepository, ProductMapper> {
    protected ProductService(ProductRepository repository, ProductMapper mapper) {
        super(repository, mapper);
    }

    public ResponseEntity<?> create(ProductCreateDTO dto) {
        if (repository.existsByName(dto.getName()))
            return ResponseEntity.badRequest().body("this product already exist");
        Product product = mapper.fromCreateDto(dto);
        Product save = repository.save(product);
        return ResponseEntity.ok(mapper.toDto(save));
    }
}
