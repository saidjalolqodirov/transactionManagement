package uz.qodirov.transactionmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.GenericDTO;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:15 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO extends GenericDTO {
    private String placeName;

    private Long productId;
}
