package uz.qodirov.transactionmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.qodirov.transactionmanagement.dto.product.ProductCreateDTO;
import uz.qodirov.transactionmanagement.services.ProductService;

/**
 * @author: Saidjalol Qodirov 2/5/2023 6:56 PM
 */
@RestController
@RequestMapping("/product")
public class ProductController extends AbstractController<ProductService> {

    public ProductController(ProductService service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addProduct(@RequestBody ProductCreateDTO dto) {
        return service.create(dto);
    }
}
