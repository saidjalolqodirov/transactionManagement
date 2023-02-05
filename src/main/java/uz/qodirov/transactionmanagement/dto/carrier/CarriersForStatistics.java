package uz.qodirov.transactionmanagement.dto.carrier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/5/2023 10:28 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarriersForStatistics {
    private CarrierDTO carrierDTO;
    private Integer score;
}
