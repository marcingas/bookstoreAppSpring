package pl.marcin.bookstoreAppSpring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.marcin.bookstoreAppSpring.model.BookItem;

import java.util.List;

public interface BookstoreService {
    Page<BookItem> getBooks(Pageable page);
    BookItem getBook(Long id);
    BookItem addBook(BookItem bookItem);
    void deleteBook(Long id);
    BookItem updateBook(BookItem bookItem);
    List<BookItem>getBookByTitle(String title);
    List<BookItem>getBookByTitleAndAuthor(String title,String author);
    List<BookItem>getBookByKeyword(String keyword);
    List<BookItem> getBooksByIdAndAuthor(Long id, String author);

}
