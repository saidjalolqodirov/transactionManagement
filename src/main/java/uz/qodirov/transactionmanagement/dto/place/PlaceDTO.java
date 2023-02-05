package uz.qodirov.transactionmanagement.dto.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.GenericDTO;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:50 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDTO extends GenericDTO {
    private String name;
}
