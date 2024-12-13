package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import fr.fms.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	// 1.2 afficher sur la console un article en base
	public Article findById(long id);
	
	// 1.2 afficher tous les articles en base.
	@Query ("select a from Article a")
	public List<Article> findAll();
	
	// 1.3 tous les articles contenants telle description et telle marque.
	public List<Article> findByBrandAndDescription(String brand, String description);
	
	// 1.4 : Ajouter une méthode qui permet de supprimer un article à partir de l’id
	public Article deleteById(long id);
	
	// 1.5 : Ajouter une méthode qui permet de mettre à jour un article à partir de l’id
	@Modifying
	@Transactional
	@Query("update Article a SET a.description = :description WHERE a.id = :id")
    void setArticleDescription(@Param("id") long id, @Param("description") String description);
	
	public List<Article> findByCategoryId(long categoryId);
	
	public List<Article> findByBrand(String brand);

}
