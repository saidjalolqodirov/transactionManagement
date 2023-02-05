package uz.qodirov.transactionmanagement.dto.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.GenericDTO;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:44 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferDTO extends GenericDTO {
    private String placeName;

    private Long productId;
}
