package kr.co.sboard.service;

import kr.co.sboard.dto.CommentDTO;
import kr.co.sboard.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentMapper commentMapper;

    public CommentDTO getComment(int cno) {
        return commentMapper.select(cno);
    }
    public List<CommentDTO> getCommentAll(int ano) {
        return commentMapper.selectAll(ano);
    }
    public CommentDTO saveComment(CommentDTO commentDTO) {
        commentMapper.insert(commentDTO);
        return getComment(commentDTO.getCno());
    }
    public void updateComment(CommentDTO commentDTO) {
        commentMapper.update(commentDTO);
    }
    public void deleteComment(int cno) {
        commentMapper.delete(cno);
    }
}
