package uz.qodirov.transactionmanagement.dto.carrier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.qodirov.transactionmanagement.dto.GenericDTO;
import uz.qodirov.transactionmanagement.dto.region.RegionDTO;

import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:07 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrierDTO extends GenericDTO {
    private String carrierName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<RegionDTO> regionList;
}
