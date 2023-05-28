package com.example.demo.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.UserBikoRepository;
import com.example.demo.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
public class UserBikoTest {

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBikoRepository userBikoRepository;

    @Test
    public void test1() {
        var e = new UserBiko();
        e.setUserId(999);
        e.setBiko("とてちてた");
        userBikoRepository.save(e);

        var result = userBikoRepository.findAll();
        assertEquals(1, result.size());

        var user = result.get(0);
        assertEquals(1, user.getId());
        assertEquals(e.getUserId(), user.getUserId());
        assertEquals(e.getBiko(), user.getBiko());
    }

}
