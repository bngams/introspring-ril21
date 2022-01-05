package fr.cesi.ril21.demospring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// @Entity => Java Bean => Constructeur, getters/setters
@Entity
@Table(name="contacts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String lastname;
    private String firstname;
    private String email;
    @Column(name="tel")
    private String phone;
}
