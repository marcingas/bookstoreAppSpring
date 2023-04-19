package pl.marcin.bookstoreAppSpring.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.marcin.bookstoreAppSpring.model.BookItem;
import pl.marcin.bookstoreAppSpring.service.BookstoreService;

import java.util.List;

@RestController
public class BookstoreController {
    @Autowired
    BookstoreService bService;
    @GetMapping("/books")
    public List<BookItem> getBooks(){
        return bService.getBooks();
    }
    @GetMapping("/books/{id}")
    public BookItem getBook(@PathVariable Long id){
        return bService.getBook(id);
    }
    @PostMapping("/books")
    public BookItem addBook(@Valid @RequestBody BookItem bookItem){
        return bService.addBook(bookItem);
    }
    @PutMapping("/books/{id}")
    public BookItem updateBook(@PathVariable Long id,@Valid @RequestBody BookItem bookItem){
        bookItem.setId(id);
        return bService.updateBook(bookItem);
    }
    @DeleteMapping("/books")
    public String deleteBook(@RequestParam Long id){
        bService.deleteBook(id);
        return "Book, id: " + id + " deleted";
    }
}
