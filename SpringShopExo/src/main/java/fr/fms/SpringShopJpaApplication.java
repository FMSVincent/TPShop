package fr.fms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopJpaApplication implements CommandLineRunner {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringShopJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// creation des categories et des articles
//		Category smartphone = categoryRepository.save(new Category("Smartphone"));
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		Category pc = categoryRepository.save(new Category("PC"));
//		
//		articleRepository.save(new Article( "Sasmung", "S10", 500, smartphone));
//		articleRepository.save(new Article( "Samsung", "S9", 350, smartphone));
//		articleRepository.save(new Article( "Xiaomi", "MI10", 100, smartphone));
//		
//		articleRepository.save(new Article("Samsung", "GalaxyTab",  450, tablet));
//		articleRepository.save(new Article( "Apple", "ipad", 350, tablet));
//		
//		articleRepository.save(new Article("Asus", "R510", 600, pc));

		// 1.2 afficher dans la console un article en base
//		Article article =  articleRepository.findById(1);
//		System.out.println(article);
		
		// 1.2 afficher tous les articles
//		List<Article> allArticles = articleRepository.findAll();
//		for (Article article : allArticles) {
//			System.out.println(article);
//		}

		// 1.3 tous les articles contenants telle description et telle marque.
//		for (Article article : articleRepository.findByBrandAndDescription("Samsung", "S9")) {
//			System.out.println(article);
//		}
//	
		// 1.4 : Ajouter une méthode qui permet de supprimer un article à partir de l’id
//		articleRepository.deleteById(1);

		// 1.5 : Ajouter une méthode qui permet de mettre à jour un article à partir de l’id
//		articleRepository.setArticleDescription(3, "nouvelle description");

		// 1.6 : Ajouter des moyens pour afficher les noms des catégories classés par ordre croissant puis décroissant
//	 	 for (Category cate : categoryRepository.findAllByOrderByNameAsc()) {
//			System.out.println(cate);
//		}
//		for (Category cate : categoryRepository.findAllByOrderByNameDesc()) {
//			System.out.println(cate);
//		}


	}
}
