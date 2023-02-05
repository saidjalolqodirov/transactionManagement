package uz.qodirov.transactionmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:44 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Place place;
    private Long productId;
}
