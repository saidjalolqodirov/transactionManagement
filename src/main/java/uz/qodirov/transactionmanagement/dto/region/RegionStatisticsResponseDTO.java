package uz.qodirov.transactionmanagement.dto.region;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/5/2023 11:15 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionStatisticsResponseDTO {
    public Integer transactionNumber;

    private RegionDTO regionDTO;
}
