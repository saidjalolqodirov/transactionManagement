package uz.qodirov.transactionmanagement.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:38 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreDTO {
    private Long transactionId;
    private int score;
}
