package lorenzofoschetti.u5d9.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Blogpost {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private String category;

    private String cover;

    private String content;

    private int lectureTime;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Blogpost(String title, String category, String cover, String content, int lectureTime) {
        this.title = title;
        this.category = category;
        this.cover = cover;
        this.content = content;
        this.lectureTime = lectureTime;
    }
}
