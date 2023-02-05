package uz.qodirov.transactionmanagement.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:00 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductStatisticsResponseDTO {
    private Long productId;

    private Integer transactionCount;
}
