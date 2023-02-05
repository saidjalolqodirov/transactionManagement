package uz.qodirov.transactionmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author: Saidjalol Qodirov 2/5/2023 5:03 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carrier extends Auditable {
    @Column(nullable = false, unique = true)
    private String carrierName;
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToMany
    private List<Region> regions;
}
