package kr.co.sboard.service;

import kr.co.sboard.dto.CommentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    void getComment() {
    }

    @Test
    void getCommentAll() {
        List<CommentDTO> dtoList = commentService.getCommentAll(1301);
        System.out.println(dtoList);
    }

    @Test
    void saveComment() {
            CommentDTO commentDTO = CommentDTO.builder()
                    .ano(1285)
                    .content("1285번 댓글 입력 테스트")
                    .writer("a103")
                    .reg_ip("127.0.0.1")
                    .build();

            System.out.println(commentService.saveComment(commentDTO));

    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteComment() {
    }
}