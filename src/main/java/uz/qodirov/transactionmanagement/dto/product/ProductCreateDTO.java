package uz.qodirov.transactionmanagement.dto.product;

import lombok.Getter;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.BaseDTO;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:01 PM
 */
@Getter
@Setter
public class ProductCreateDTO implements BaseDTO {
    private String name;
}
