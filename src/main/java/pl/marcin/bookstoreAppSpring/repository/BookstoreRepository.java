package pl.marcin.bookstoreAppSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marcin.bookstoreAppSpring.model.BookItem;

import java.util.List;

@Repository
public interface BookstoreRepository extends JpaRepository<BookItem, Long> {
    List<BookItem> findByTitle(String title);
    List<BookItem> findByTitleAndAuthor(String title, String author);
    List<BookItem> findByTitleContaining(String keyword);
}
