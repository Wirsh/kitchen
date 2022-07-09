package by.mensk.kitchen.model;

import by.mensk.kitchen.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "user_type")
    public UserType userType;
    @Column(name = "name")
    public String name;
    @Column(name = "last_name")
    public String lastName;
    @Column(name = "pass")
    public String pass;
    @Column(name = "phone")
    public Integer phone;
    @Column(name = "email", unique = true)
    public String email;
    @OneToMany
    public List<Event> eventList;


    public User(UserType type, String name, String lastName, Integer phone, String email) {
        this.userType = type;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public User(String pass, String email) {
        this.pass = pass;
        this.email = email;
    }
}
