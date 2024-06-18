package com.fastcampus.ch4;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OneToOneTest {

    @Autowired
    public EntityManager em;

    @Autowired
    private CartRepository cartRepos;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void oneToOneTest(){
         Member member = new Member();
         member.setId(1L);
         member.setName("aaa");
         member.setEmail("aaa@aaa.com");
         member.setPassword("1234");
         memberRepo.save(member);

         Cart cart = new Cart();
         cart.setId(1L);
         cart.setMember(member);
         cartRepos.save(cart);

         cart = cartRepos.findById(cart.getId()).orElse(null);
         assertTrue(cart != null);
         System.out.println("cart = " + cart);

         member = memberRepo.findById(member.getId()).orElse(null);
         assertTrue(member != null);
         System.out.println("member = " + member);

    }

}