package com.xn2001.vuetest.repository;

import com.xn2001.vuetest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 乐心湖 on 2020/3/2 0:12
 */
public interface BookRepository extends JpaRepository<Book,Integer> {

}
