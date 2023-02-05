package uz.qodirov.transactionmanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:15 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateDTO implements BaseDTO {
    @NotBlank
    private String placeName;
    @NotNull
    private Long productId;
}
