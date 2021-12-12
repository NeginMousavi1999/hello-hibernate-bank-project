package model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Negin Mousavi
 */
@Data
@Entity
@Table(name = "update_info") //because of UPDATE keyword in mysql!!
public class Update {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @Column(name = "update_time")
    private Date updateTime;
    @ManyToOne
    private User user;
}
