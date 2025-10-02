package kr.co.sboard.mapper;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;

    @Test
    void selectAll() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                                                        .pg(2)
                                                        .build();
        List<ArticleDTO> dtoList = articleMapper.selectAll(pageRequestDTO);
        System.out.println(dtoList);
    }
}