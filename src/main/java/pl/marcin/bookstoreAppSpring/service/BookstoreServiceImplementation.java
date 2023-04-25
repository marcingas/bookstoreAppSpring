package pl.marcin.bookstoreAppSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.marcin.bookstoreAppSpring.model.BookItem;
import pl.marcin.bookstoreAppSpring.repository.BookstoreRepository;


import java.util.List;
import java.util.Optional;

@Service
public class BookstoreServiceImplementation implements BookstoreService{
    @Autowired
    BookstoreRepository bRepository;
    @Override
    public Page<BookItem> getBooks(Pageable page) {

        return bRepository.findAll(page);
    }

    @Override
    public BookItem getBook(Long id) {
        Optional<BookItem> bookItem = bRepository.findById(id);
        if(bookItem.isPresent()){
        return bookItem.get();
        } else{
            throw new RuntimeException("Book not found by id: " + id);
        }
    }

    @Override
    public BookItem addBook(BookItem bookItem) {
        return bRepository.save(bookItem);
    }

    @Override
    public void deleteBook(Long id) {
        bRepository.deleteById(id);
    }

    @Override
    public BookItem updateBook(BookItem bookItem) {
        return bRepository.save(bookItem);
    }

    @Override
    public List<BookItem> getBookByTitle(String title) {
        return bRepository.findByTitle(title);
    }

    @Override
    public List<BookItem> getBookByTitleAndAuthor(String title, String author) {
        return bRepository.findByTitleAndAuthor(title, author);
    }

    @Override
    public List<BookItem> getBookByKeyword(String keyword) {
        return bRepository.findByTitleContaining(keyword);
    }

    @Override
    public List<BookItem> getBooksByIdAndAuthor(Long id, String author) {
        return bRepository.getBookItemByIdAndAuthor(0L,"author");
    }

    @Override
    public Integer deleteBookByTitle(String title) {
        return bRepository.deleteBookByTitle(title);
    }
}
