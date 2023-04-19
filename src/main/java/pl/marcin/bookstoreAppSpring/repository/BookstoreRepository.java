package pl.marcin.bookstoreAppSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marcin.bookstoreAppSpring.model.BookItem;

@Repository
public interface BookstoreRepository extends JpaRepository<BookItem, Long> {
}
