package uz.qodirov.transactionmanagement.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Saidjalol Qodirov 2/5/2023 8:20 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreateDTO implements BaseDTO {
    @NotNull
    private Long requestId;
    @NotNull
    private Long offerId;
    @NotBlank
    private String carrierName;
}
