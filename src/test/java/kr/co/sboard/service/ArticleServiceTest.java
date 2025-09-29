package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    void getArticle() {
    }

    @Test
    void getArticleAll() {
    }

    @Test
    void save() {
        ArticleDTO articleDTO = ArticleDTO.builder()
                .title("제목2")
                .content("내용2")
                .writer("a101")
                .reg_ip("127.0.0.1")
                .build();
        articleService.save(articleDTO);
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
    }
}