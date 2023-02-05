package uz.qodirov.transactionmanagement.dto.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.GenericDTO;
import uz.qodirov.transactionmanagement.dto.place.PlaceDTO;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:03 AM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionDTO extends GenericDTO {
    private String name;

    private List<PlaceDTO> places;
}
