package uz.qodirov.transactionmanagement.dto.carrier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:07 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrierCreateDTO implements BaseDTO {
    @NotBlank
    private String carrierName;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String phoneNumber;
    private HashSet<Long> regionIds;
}
