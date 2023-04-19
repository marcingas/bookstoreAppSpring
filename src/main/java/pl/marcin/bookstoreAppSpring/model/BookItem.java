package pl.marcin.bookstoreAppSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="book_tbl")
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="description")
    private String description;
    @Column(name="issueYear")
    private int issueYear;
    @CreationTimestamp
    @Column(name="date_created", nullable = false,updatable = false)
    private Date dateCreated;
    @UpdateTimestamp()
    @Column(name="date_updated")
    private Date dateUpdated;

}
