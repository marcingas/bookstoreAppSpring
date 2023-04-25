package pl.marcin.bookstoreAppSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.marcin.bookstoreAppSpring.model.BookItem;

import java.util.List;

@Repository
public interface BookstoreRepository extends JpaRepository<BookItem,Long> {
    List<BookItem> findByTitle(String title);
    List<BookItem> findByTitleAndAuthor(String title, String author);
    List<BookItem> findByTitleContaining(String keyword);
    @Query("FROM BookItem WHERE id = :id OR author = :author")
    List<BookItem> getBookItemByIdAndAuthor(Long id, String author);
    @Transactional
    @Modifying
    @Query("DELETE From BookItem WHERE title = :title")
    Integer deleteBookByTitle(String title);
}
