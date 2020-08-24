package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity for the priority
 */
@Entity
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_priority")
    @Getter
    @Setter
    private Long idPriority;
    @Column(name = "label")
    @Getter @Setter
    private String label;
}
