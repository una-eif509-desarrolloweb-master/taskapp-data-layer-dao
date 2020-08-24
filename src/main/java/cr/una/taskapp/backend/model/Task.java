/*
 *
 *  *
 *  * Universidad Nacional de Costa Rica  2020
 *  *
 *  * mike@guzmanalan.com
 *  *
 *
 */

package cr.una.taskapp.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity for Task
 */
@Entity
@Table( name = "task" )
public class Task {

    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task")
    @Getter
    @Setter
    private Long idTask;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String notes;
    @Getter @Setter
    private Date createDate;
    @Getter @Setter
    private Date dueDate;

    // Relationship definition
    @ManyToOne
    @JoinColumn(name = "id_priority", nullable = false)
    @Getter @Setter
    private Priority priority;
    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    @Getter @Setter
    private Status status;
}
