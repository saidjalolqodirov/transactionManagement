package uz.qodirov.transactionmanagement.dto.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.GenericDTO;

import javax.validation.constraints.NotBlank;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:03 AM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionUpdateDTO extends GenericDTO {
    @NotBlank
    private String name;
}
