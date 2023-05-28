package com.example.demo.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
public class UserTest {

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    UserRepository userRepository;

    @Test
    public void test1() {
        var e = new User();
        e.setName("東京 太郎");
        userRepository.save(e);

        var result = userRepository.findAll();
        assertEquals(1, result.size());

        var user = result.get(0);
        assertEquals(1, user.getId());
        assertEquals(e.getName(), user.getName());
    }

}
