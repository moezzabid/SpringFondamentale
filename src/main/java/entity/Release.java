package entity;

import javax.persistence.*;


@Entity
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String releaseDate;
    private String description;

    public Release() {
    }

    public Release(Integer id, String releaseDate, String description) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.description = description;
    }
}
