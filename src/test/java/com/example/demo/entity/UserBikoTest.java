package com.example.demo.entity;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.UserBikoRepository;
import com.example.demo.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
public class UserBikoTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBikoRepository userBikoRepository;

    @Test
    @Transactional
    public void test1() {
        var user = new User();
        user.setId(1);
        user.setName("東京 太郎");
        userRepository.save(user);
        userRepository.flush();

        var e = new UserBiko();
        e.setId(1);
        e.setUserId(user.getId());
        e.setBiko("とてちてた");
        userBikoRepository.save(e);
        userBikoRepository.flush();

        entityManager.clear();

        var result = userBikoRepository.findAll();
        assertEquals(1, result.size());

        var userBiko = result.get(0);
        System.out.println(userBiko);
        //assertEquals(e, userBiko);
    }

}
