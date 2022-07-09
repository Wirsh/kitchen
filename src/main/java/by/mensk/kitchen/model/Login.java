package by.mensk.kitchen.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="logins")
public class Login {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name ="Id")
    private Integer id;
    @Column(name="login")
    String login = null;
    @Column(name= "pass")
    String pass = null;


}
