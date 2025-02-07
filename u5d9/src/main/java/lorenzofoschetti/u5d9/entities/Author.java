package lorenzofoschetti.u5d9.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String surname;

    private String email;

    private LocalDate dataDiNascita;

    private String avatar;

    public Author(String name, String surname, String email, LocalDate dataDiNascita) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataDiNascita = dataDiNascita;

    }


}
