package com.example.bootrestbook.Controller;

import java.util.List;
import java.util.Optional;

 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootrestbook.Entity.Book;
import com.example.bootrestbook.Services.BookService;

@RestController
public class bookcontroller {
     
    @Autowired
    private BookService bookservice;

     
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> list = bookservice.getAllBooks();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){
     Book book = this.bookservice.getBookById(id);
     if(book==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
    return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
    Book b = null;
    try {
         b = this.bookservice.addBook(book);
        return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try {
            this.bookservice.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book , @PathVariable("id") int id){
        try {
            this.bookservice.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }    
    }
   
}
