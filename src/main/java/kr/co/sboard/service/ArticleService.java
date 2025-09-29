package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleDTO getArticle(int ano){
        Optional<Article> optArticle = articleRepository.findById(ano);
        if(optArticle.isPresent()){
            Article article = optArticle.get();
            return modelMapper.map(article, ArticleDTO.class);
        }
        return null;
    }
    public List<ArticleDTO> getArticleAll(){
        List<Article> list = articleRepository.findAll();
        return list.stream()
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .toList();
    }
    public int save(ArticleDTO articleDTO){
        Article article = modelMapper.map(articleDTO, Article.class);
        Article savedArticle = articleRepository.save(article);

        return savedArticle.getAno();
    }
    public void modify(ArticleDTO articleDTO){
        if(articleRepository.existsById(articleDTO.getAno())){
            Article article = modelMapper.map(articleDTO, Article.class);
            articleRepository.save(article);
        }
    }
    public void delete(int ano){
        articleRepository.deleteById(ano);
    }
}
