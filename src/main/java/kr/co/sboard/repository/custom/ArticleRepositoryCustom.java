package kr.co.sboard.repository.custom;

import com.querydsl.core.Tuple;
import kr.co.sboard.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepositoryCustom {
    public Page<Tuple> selectArticleAllForList(PageRequestDTO pageRequestDTO, Pageable pageable);
}
