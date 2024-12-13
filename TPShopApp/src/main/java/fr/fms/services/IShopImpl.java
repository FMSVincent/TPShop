package fr.fms.services;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class IShopImpl implements IShop {

	private ArticleRepository articleRepository;
	private CategoryRepository categoryRepository;

	public IShopImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
		this.articleRepository = articleRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}
	
    @Override
    public void addArticle(String description, String brand, double price, String categoryName) {
        Optional<Category> categoryOpt = categoryRepository.findByName(categoryName);
        if (categoryOpt.isPresent()) {
            Article article = new Article(description, brand, price, categoryOpt.get());
            articleRepository.save(article);
        } else {
            throw new RuntimeException("Catégorie inexistante");
        }
    }
    
    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void updateArticle(Long articleId, String newDescription, String newBrand, double newPrice, String newCategoryName) {
        Optional<Article> articleOpt = articleRepository.findById(articleId);
        if (articleOpt.isPresent()) {
            Article article = articleOpt.get();
            article.setDescription(newDescription);
            article.setBrand(newBrand);
            article.setPrice(newPrice);

            Optional<Category> categoryOpt = categoryRepository.findByName(newCategoryName);
            if (categoryOpt.isPresent()) {
                article.setCategory(categoryOpt.get());
                articleRepository.save(article);
            } else {
                throw new RuntimeException("Catégorie inexistante");
            }
        } else {
            throw new RuntimeException("Article non trouvé");
        }
    }

    @Override
    public void deleteArticle(Long articleId) {
        if (articleRepository.existsById(articleId)) {
            articleRepository.deleteById(articleId);
        } else {
            throw new RuntimeException("Article non trouvé");
        }
    }

    @Override
    public void addCategory(String categoryName) {
        Optional<Category> existingCategory = categoryRepository.findByName(categoryName);
        if (!existingCategory.isPresent()) {
            Category category = new Category();
            category.setName(categoryName);
            categoryRepository.save(category);
        } else {
            throw new RuntimeException("La catégorie existe déjà");
        }
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Long categoryId, String newName) {
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
        if (categoryOpt.isPresent()) {
            Category category = categoryOpt.get();
            category.setName(newName);
            categoryRepository.save(category);
        } else {
            throw new RuntimeException("Catégorie non trouvée");
        }
    }

    @Override
    public void deleteCategory(Long categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
        } else {
            throw new RuntimeException("Catégorie non trouvée");
        }
    }

    @Override
    public List<Article> getArticlesByCategoryId(Long categoryId) {
        return articleRepository.findByCategoryId(categoryId);
    }

}
