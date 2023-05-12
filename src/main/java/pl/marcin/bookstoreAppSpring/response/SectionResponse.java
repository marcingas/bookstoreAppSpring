package pl.marcin.bookstoreAppSpring.response;

import lombok.Getter;
import lombok.Setter;
import pl.marcin.bookstoreAppSpring.model.BookItem;

import java.util.List;

@Getter
@Setter
public class SectionResponse {
    private Long id;
    private String sectionName;
    private List<String> bookItemsTitles;
}
