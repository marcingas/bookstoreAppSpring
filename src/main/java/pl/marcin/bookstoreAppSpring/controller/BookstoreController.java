package pl.marcin.bookstoreAppSpring.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.marcin.bookstoreAppSpring.model.BookItem;
import pl.marcin.bookstoreAppSpring.service.BookstoreService;

import java.util.List;

@RestController
public class BookstoreController {
    @Autowired
    BookstoreService bService;
    @GetMapping("/books")
    public List<BookItem> getBooks(Pageable page){
        return bService.getBooks(page).toList();
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<BookItem> getBook(@Valid @PathVariable Long id){

        return new ResponseEntity<BookItem>(bService.getBook(id),HttpStatus.OK);
    }
    @PostMapping("/books")
    public ResponseEntity<BookItem> addBook(@Valid @RequestBody BookItem bookItem){

        return new ResponseEntity<>(bService.addBook(bookItem),HttpStatus.CREATED);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<BookItem> updateBook(@PathVariable Long id,@Valid @RequestBody BookItem bookItem){
        bookItem.setId(id);
        return new ResponseEntity<BookItem>(bService.updateBook(bookItem),HttpStatus.OK);
    }
    @DeleteMapping("/books")
    public ResponseEntity<HttpStatus> deleteBook(@RequestParam Long id){
        bService.deleteBook(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/books/filterByTitle")
    public ResponseEntity<List<BookItem>>getBookByTitle(@RequestParam String title){
        return new ResponseEntity<List<BookItem>>(bService.getBookByTitle(title),HttpStatus.OK);
    }
    @GetMapping("/books/filterByTitleAuthor")
    public ResponseEntity<List<BookItem>>getBookByTitleAuthor(@RequestParam String title, @RequestParam String author){
        return  new ResponseEntity<List<BookItem>>(bService.getBookByTitleAndAuthor(title, author),HttpStatus.OK);
    }
    @GetMapping("/books/filterByKeyword")
    public ResponseEntity<List<BookItem>>getBookByKeyword(@RequestParam String keyword){
        return new ResponseEntity<List<BookItem>>(bService.getBookByKeyword(keyword),HttpStatus.OK);
    }
    @GetMapping("/books/{id}/{author}")
    public ResponseEntity<List<BookItem>>getBookByIdAndAuthor(@PathVariable Long id, @PathVariable String author){
        return new ResponseEntity<List<BookItem>>(bService.getBooksByIdAndAuthor(id,author),HttpStatus.OK);
    }
}
