package pl.marcin.bookstoreAppSpring.request;

import lombok.Getter;
import lombok.Setter;
import pl.marcin.bookstoreAppSpring.model.Section;
@Setter
@Getter
public class BookstoreRequest {
    private String title;
    private String author;
    private String description;
    private int issueYear;
    private String section;
}
