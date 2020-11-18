package pl.kl.carworkshop.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepairOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderContents;

    @CreationTimestamp
    private LocalDateTime creationDate;

    private boolean orderClosed;
    private LocalDateTime closingDate;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Car car;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mechanic_repair_order", joinColumns = @JoinColumn(name = "repairorder_id"), inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Mechanic> mechanicSet;
}
