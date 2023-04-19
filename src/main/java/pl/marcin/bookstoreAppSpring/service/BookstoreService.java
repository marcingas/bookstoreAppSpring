package pl.marcin.bookstoreAppSpring.service;

import pl.marcin.bookstoreAppSpring.model.BookItem;

import java.util.List;

public interface BookstoreService {
    List<BookItem> getBooks();
    BookItem getBook(Long id);
    BookItem addBook(BookItem bookItem);
    void deleteBook(Long id);
    BookItem updateBook(BookItem bookItem);

}
