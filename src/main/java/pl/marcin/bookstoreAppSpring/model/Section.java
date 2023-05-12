package pl.marcin.bookstoreAppSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "section_tbl")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "section")
    @JsonIgnore
    private List<BookItem> bookItems;

}
