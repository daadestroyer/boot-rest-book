package com.example.bootrestbook.Services;

import java.util.List;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bootrestbook.Dao.BookRepo;
import com.example.bootrestbook.Entity.Book;

@Component
public class BookService {
   
    @Autowired
   private BookRepo bookrepo;
   // get all book
    public List<Book> getAllBooks() {
         List<Book> list = (List<Book>) this.bookrepo.findAll();
         return list;
    }
   
    // get single book
    public Book getBookById(int id){
      Book book =  this.bookrepo.findById(id);
       return book;
    }
   
    // add book 
   public Book addBook(Book book){
    Book result = this.bookrepo.save(book);   
    return result;
    }
   
    // delete book
    public void deleteBook(int id){
        this.bookrepo.deleteById(id);
    }
   
    // update book
    public void updateBook(Book book , int id){
       book.setId(id);
       this.bookrepo.save(book);
    }
   
    
   
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Java","XYZ"));
    //     list.add(new Book(13,"Python","ABC"));
    //     list.add(new Book(14,"C++","PEQ"));
    // }

    // // get all book
    // public List<Book> getAllBooks() {
    //     return list;
    // }

    // // get single book
    // public Book getBookById(int id){
    //    Book book = null;
    //    try{
    //     book =  list.stream().filter(e->e.getId()==id).findFirst().get();
    //    }
    //    catch(Exception e){
    //     e.printStackTrace();
    //    }
    //    return book;
    // }

    // public Book addBook(Book book){
    //     list.add(book);
    //     return book;
    // }

    // public void deleteBook(int id){
    //     list = list.stream().filter(book->book.getId() != id).
    //     collect(Collectors.toList());
    // }

    // public void updateBook(Book book , int id){
    //    list = list.stream().map(b->{
    //         if(b.getId() == id){
    //             b.setTitle(book.getTitle());
    //             b.setAuthor(book.getAuthor());
    //         }
    //         return b;
    //     }).collect(Collectors.toList());
    // }
}
