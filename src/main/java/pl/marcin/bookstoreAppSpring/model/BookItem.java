package pl.marcin.bookstoreAppSpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import pl.marcin.bookstoreAppSpring.request.BookstoreRequest;

import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name="bookone_tbl")
@NoArgsConstructor
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
//    @NotBlank(message = "title: should not be null")
    @Column(name="title")
    private String title;
//    @NotBlank(message = "author: should not be null")
    @Column(name="author")
    private String author;
    @Column(name="description")
    private String description;
    @Column(name="issue_year")
    private int issueYear;
    @CreationTimestamp
    @Column(name="date_created", nullable = false,updatable = false)
    private Date dateCreated;
    @UpdateTimestamp
    @Column(name="date_updated")
    private Date dateUpdated;

    @JoinColumn(name = "section_id")
    @OneToOne
    private Section section;

    public BookItem(BookstoreRequest bRequest) {
        this.title= bRequest.getTitle();
    }
}
