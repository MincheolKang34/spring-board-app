package kr.co.sboard.mapper;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    public ArticleDTO select(int cno);
    // @Param : MyBatis SQL 매퍼파일(xml)에서 해당 매개변수를 참조할 수 있는 어노테이션, 반드시 선언
    public List<ArticleDTO> selectAll(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
    public int selectCountTotal(@Param("pageRequestDTO") PageRequestDTO pageRequestDTO);
}
