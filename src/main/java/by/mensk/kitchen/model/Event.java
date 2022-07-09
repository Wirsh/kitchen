package by.mensk.kitchen.model;

import by.mensk.kitchen.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name ="Id")
    private Integer id;
    @Column(name ="name")
    private String name;
    @Column(name = "type")
    private EventType eventType;
    @Column(name = "date")
    private Date date;
    @Column(name ="guests_num")
    private Integer guestsNum;
    @OneToMany
    private List<Meal> menu;

    public Event(String name, Date date, Integer guestsNum, List<Meal> menu) {
        this.name = name;
        this.date = date;
        this.guestsNum = guestsNum;
        this.menu = menu;
    }
}
