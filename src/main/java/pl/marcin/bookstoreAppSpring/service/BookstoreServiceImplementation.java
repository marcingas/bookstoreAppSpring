package pl.marcin.bookstoreAppSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<BookItem> getBooks() {
        return bRepository.findAll();
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
}
