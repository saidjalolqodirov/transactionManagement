package uz.qodirov.transactionmanagement.dto.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.BaseDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:50 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceCreateDTO implements BaseDTO {
    @NotBlank
    private String name;
    @NotNull
    private Long regionId;
}
