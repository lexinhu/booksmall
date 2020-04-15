package com.xn2001.vuetest.controller;

import com.xn2001.vuetest.entity.Book;
import com.xn2001.vuetest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 乐心湖 on 2020/3/2 0:21
 */
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return bookRepository.findAll(pageRequest);
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable Integer id){
        return bookRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @PutMapping("/update")
    public String upate(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        bookRepository.deleteById(id);
    }
}
