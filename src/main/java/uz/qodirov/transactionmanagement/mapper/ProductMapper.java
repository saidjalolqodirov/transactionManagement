package uz.qodirov.transactionmanagement.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.qodirov.transactionmanagement.dto.product.ProductCreateDTO;
import uz.qodirov.transactionmanagement.dto.product.ProductDTO;
import uz.qodirov.transactionmanagement.dto.product.ProductUpdateDTO;
import uz.qodirov.transactionmanagement.entity.Product;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:00 PM
 */

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductDTO, Product, ProductCreateDTO, ProductUpdateDTO> {
}
