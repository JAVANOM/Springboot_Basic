/*
package com.fastcampus.ch4;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTes4 {

    @Autowired
    public EntityManager em;

    @Autowired
    private BoardRepository boardRepo;

    @BeforeEach
    public void testData(){
        for(int i=1; i <= 100; i++){
            Board board = new Board();
            board.setBno((long)i);
            board.setTitle("title" + i);
            board.setContent("content" + i);
            board.setWriter("writer" + (i % 5));
            board.setViewCnt((long)(Math.random()*100));
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardRepo.save(board);
        }
    }

    @Test
    @DisplayName("querydsl로 동적 쿼리 작성 테스트")
    public void querydslTest3(){
        QBoard board = QBoard.board;
        String searchBy = "TC"; //제목(Title)과 작성내용(Content)에서 검색
        String keyword = "1";
        keyword = "%" + keyword + "%";

        BooleanBuilder builder = new BooleanBuilder();

        //동적으로 조건을 달리하게
        if(searchBy.equalsIgnoreCase("T"))
            builder.and(board.title.like(keyword));
        else if(searchBy.equalsIgnoreCase("C"))
            builder.and(board.content.like(keyword));
        else if(searchBy.equalsIgnoreCase("TC"))
            builder.and(board.title.like(keyword).or(board.content.like(keyword)));

        JPAQueryFactory qf = new JPAQueryFactory(em);
        JPAQuery query = qf.selectFrom(board)
                .where(builder)
                .orderBy(board.upDate.desc());

        List<Board> list = query.fetch();
        list.forEach(System.out::println);

    }

    @Test
    @DisplayName("querydsl로 복잡한 쿼리 작성 테스트")
    public void querydslTest2(){
        QBoard board = QBoard.board;
        //1. JPAQueryFactory를 생성
        JPAQueryFactory qf  = new JPAQueryFactory(em);

        //2, 쿼리 작성
        JPAQuery<Tuple> query  = qf.select(board.writer, board.viewCnt.sum()).from(board)
                .where(board.title.notLike("title1%"))
                .where(board.writer.eq("writer1"))
                .where(board.content.contains("content"))
                .where(board.content.isNotNull())
                .groupBy(board.writer)
                .having(board.viewCnt.sum().gt(100)) //조회수가 100이 넘는 게시물
                .orderBy(board.writer.asc())
                .orderBy(board.viewCnt.sum().desc());

        //3. 쿼리 실행
        List<Tuple> list = query.fetch();
        list.forEach(System.out::println);

    }




    @Test
    @DisplayName("querydsl로 쿼리 작성 테스트")
    public void querydslTest1(){
        QBoard board = QBoard.board;
        //1. JPAQueryFactory를 생성
        JPAQueryFactory qf  = new JPAQueryFactory(em);

        //2, 쿼리 작성
        JPAQuery<Board> query  = qf.selectFrom(board)
                .where(board.title.eq("title1"));

        //3. 쿼리 실행
        List<Board> list = query.fetch();
        list.forEach(System.out::println);

    }

}*/
