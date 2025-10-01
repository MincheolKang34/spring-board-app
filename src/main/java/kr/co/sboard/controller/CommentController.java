package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.CommentDTO;
import kr.co.sboard.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments/{ano}")
    public ResponseEntity<List<CommentDTO>> list(@PathVariable("ano") int ano){
        List<CommentDTO> dtoList = commentService.getCommentAll(ano);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/comment/{cno}")
    public ResponseEntity<?> comment(@PathVariable("cno") int cno){
        CommentDTO commentDTO = commentService.getComment(cno);
        return ResponseEntity.ok(commentDTO);
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDTO> register(@RequestBody CommentDTO commentDTO, HttpServletRequest request){
        log.info("commentDTO = {}", commentDTO);

        String regip = request.getRemoteAddr();
        commentDTO.setReg_ip(regip);

        CommentDTO savedComment = commentService.saveComment(commentDTO);
        log.info("savedComment = {}", savedComment);
        return ResponseEntity.ok(savedComment);
    }

    @PutMapping("/comment")
    public void modify(){}

    @DeleteMapping("/comment")
    public void delete(){}
}
