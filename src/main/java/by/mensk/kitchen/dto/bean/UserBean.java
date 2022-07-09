package by.mensk.kitchen.dto.bean;

import by.mensk.kitchen.enums.UserType;
import by.mensk.kitchen.model.Event;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    //todo Private fields
    private UserType userType;

    private String name;

    private String lastName;

    private String pass;

    private Integer phone;

    private String email;

    public List<Event> eventList;

}
