package kr.co.sboard.repository;

import com.querydsl.core.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void test1(){
        Pageable pageable = PageRequest.of(0, 10);

        Page<Tuple> pageTuple = articleRepository.selectArticleAllForList(pageable);

        List<Tuple> tupleList = pageTuple.getContent();

        System.out.println(tupleList);
    }
}