package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Article findById(long id);
	
	@Query ("select a from Article a")
	
	public List<Article> findAll();
	
	public List<Article> findByBrandAndDescription(String brand, String description);
	
	public Article deleteById(long id);
	
	@Modifying
	@Transactional
	@Query("update Article a SET a.description = :description WHERE a.id = :id")
    void setArticleDescription(@Param("id") long id, @Param("description") String description);
	
	public List<Article> findByCategoryId(long categoryId);
	
	public List<Article> findByBrand(String brand);

}
