package kr.co.sboard.repository;

import com.querydsl.core.Tuple;
import jakarta.transaction.Transactional;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Transactional
    void test1(){
        Pageable pageable = PageRequest.of(0, 10);
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        Page<Tuple> pageTuple = articleRepository.selectArticleAllForList(pageRequestDTO, pageable);

        List<Tuple> tupleList = pageTuple.getContent();

        System.out.println(tupleList);
    }

    /*
     * failed to lazily initialize a collection of role: kr.co.sboard.entity.Article.fileList: could not initialize proxy - no Session
     * select 작업이 연쇄되어 두 번 이상 실행되어 트랜잭션 설정이 필요한 경우 발생하는 오류
     */
    @Test
    @Transactional
    void test2(){
        Optional<Article> optArticle = articleRepository.findById(11);

        if(optArticle.isPresent()){
            Article article = optArticle.get();
            System.out.println(article);
        }
    }
}