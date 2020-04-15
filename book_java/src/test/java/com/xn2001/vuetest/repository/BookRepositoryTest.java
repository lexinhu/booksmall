package com.xn2001.vuetest.repository;

import com.xn2001.vuetest.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 乐心湖 on 2020/3/2 0:13
 */
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void contextLoads(){
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Book> page = bookRepository.findAll(pageRequest);
    }

    @Test
    void sava(){
        Book book = new Book();
        book.setName("时间的秩序");
        book.setAuthor(" [意] 卡洛·罗韦利");
        book.setPublish("湖南科学技术出版社");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById(){
        System.out.println(bookRepository.findById(1).get());
    }
}