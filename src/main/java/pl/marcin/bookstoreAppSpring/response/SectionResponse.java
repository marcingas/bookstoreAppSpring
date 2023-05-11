package pl.marcin.bookstoreAppSpring.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionResponse {
    private Long id;
    private String sectionName;
    private String bookitemtitle;
}
