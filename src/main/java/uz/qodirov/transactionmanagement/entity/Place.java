package uz.qodirov.transactionmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author: Saidjalol Qodirov 2/5/2023 9:37 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Place extends Auditable {
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    private Region region;
}
