package uz.qodirov.transactionmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author: Saidjalol Qodirov 2/5/2023 7:09 PM
 */
@Getter
@Setter
@Entity
public class Request implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Place place;
    private Long productId;
}
