package pl.marcin.bookstoreAppSpring.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookstoreRequest {
    private String title;
    private String section;
}
