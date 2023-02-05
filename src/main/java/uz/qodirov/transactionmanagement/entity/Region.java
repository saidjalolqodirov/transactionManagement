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
 * @author: Saidjalol Qodirov 2/5/2023 7:52 AM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Region extends Auditable {
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "regions")
    private List<Carrier> carrierList;
}
