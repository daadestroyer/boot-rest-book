package com.example.bootrestbook.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.bootrestbook.Entity.Book;

public interface BookRepo extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
