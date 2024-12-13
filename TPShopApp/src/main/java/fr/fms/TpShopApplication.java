package fr.fms;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.entities.Article;
import fr.fms.entities.Category;
import fr.fms.services.IShopImpl;

@SpringBootApplication
public class TpShopApplication implements CommandLineRunner {

	private Scanner scanner = new Scanner(System.in);
	private IShopImpl iShopImpl;

	public TpShopApplication(IShopImpl iShopImpl) {
		this.iShopImpl = iShopImpl;
	}

	public static void main(String[] args) {
		SpringApplication.run(TpShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		   int option;
	        do {
	            System.out.println(" ==== Application I have to grab it\n"
	            		+ " ! ==== ");
	            System.out.println("1. Afficher les articles");
	            System.out.println("==== Articles ==== ");
	            System.out.println("2. Ajouter un article");
	            System.out.println("3. Afficher un article");
	            System.out.println("4. Supprimer un article");
	            System.out.println("5. Mettre à jour un article");
	            System.out.println("===== Catégorie ===== ");
	            System.out.println("6. Ajouter une catégorie");
	            System.out.println("7. Afficher une catégorie");
	            System.out.println("8. Supprimer une catégorie");
	            System.out.println("9. Mettre à jour une catégorie");
	            System.out.println("10. Afficher tous les articles d'une catégorie");
	            System.out.println("11. Quitter");
	            System.out.print("Choisissez une option: ");
	            option = scanner.nextInt();
	            scanner.nextLine();

	            switch (option) {
	                case 1:
	                    displayArticles();
	                    break;
	                case 2:
	                    addArticle();
	                    break;
	                case 3:
	                    displayArticle();
	                    break;
	                case 4:
	                    removeArticle();
	                    break;
	                case 5:
	                    updateArticle();
	                    break;
	                case 6:
	                    addCategory();
	                    break;
	                case 7:
	                    displayCategory();
	                    break;
	                case 8:
	                    removeCategory();
	                    break;
	                case 9:
	                    updateCategory();
	                    break;
	                case 10:
	                    displayArticleByCategory();
	                    break;
	                case 11:
	                    System.out.println("A bientot !");
	                    break;
	                default:
	                    System.out.println("Option invalide.");
	            }
	        } while (option != 11);
	}

	private void displayArticles() {
		List<Article> articles = iShopImpl.getAllArticles();
		for (Article article : articles) {
			System.out.println(article);
		}
	}
	
	 

	    private void addArticle() {
	        System.out.print("Description : ");
	        String description = scanner.nextLine();
	        System.out.print("Marque : ");
	        String brand = scanner.nextLine();
	        System.out.print("Prix : ");
	        double price = scanner.nextDouble();
	        scanner.nextLine();
	        System.out.print("Nom de la catégorie : ");
	        String categoryName = scanner.nextLine();

	        try {
	        	iShopImpl.addArticle(description, brand, price, categoryName);
	            System.out.println("Article ajouté !");
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void displayArticle() {
	        System.out.print("ID de l'article : ");
	        Long id = scanner.nextLong();
	        Optional<Article> article = iShopImpl.getArticleById(id);
	        if (article.isPresent()) {
	            System.out.println(article.get());
	        } else {
	            System.out.println("Article non trouvé.");
	        }
	    }

	    private void removeArticle() {
	        System.out.print("ID de l'article à supprimer : ");
	        Long id = scanner.nextLong();
	        try {
	            iShopImpl.deleteArticle(id);
	            System.out.println("Article supprimé.");
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void updateArticle() {
	        System.out.print("ID de l'article : ");
	        Long id = scanner.nextLong();
	        scanner.nextLine();
	        System.out.print("Nouvelle description : ");
	        String description = scanner.nextLine();
	        System.out.print("Nouvelle marque : ");
	        String brand = scanner.nextLine();
	        System.out.print("Nouveau prix : ");
	        double price = scanner.nextDouble();
	        scanner.nextLine();
	        System.out.print("Nouvelle catégorie : ");
	        String categoryName = scanner.nextLine();

	        try {
	        	iShopImpl.updateArticle(id, description, brand, price, categoryName);
	            System.out.println("Article mis à jour.");
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void addCategory() {
	        System.out.print("Nom de la catégorie : ");
	        String name = scanner.nextLine();
	        try {
	        	iShopImpl.addCategory(name);
	            System.out.println("Catégorie ajoutée.");
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void displayCategory() {
	        System.out.print("ID de la catégorie : ");
	        Long id = scanner.nextLong();
	        Optional<Category> category = iShopImpl.getCategoryById(id);
	        if (category.isPresent()) {
	            System.out.println(category.get());
	        } else {
	            System.out.println("Catégorie non trouvée.");
	        }
	    }

	    private void removeCategory() {
	        System.out.print("ID de la catégorie : ");
	        Long id = scanner.nextLong();
	        try {
	        	iShopImpl.deleteCategory(id);
	            System.out.println("Catégorie supprimée.");
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void updateCategory() {
	        System.out.print("ID de la catégorie : ");
	        Long id = scanner.nextLong();
	        scanner.nextLine();
	        System.out.print("Nouveau nom : ");
	        String newName = scanner.nextLine();
	        try {
	        	iShopImpl.updateCategory(id, newName);
	            System.out.println("Catégorie mise à jour.");
	        } catch (RuntimeException e) {
	            System.out.println(e.getMessage());
	        }
	    }

	    private void displayArticleByCategory() {
	        System.out.print("ID de la catégorie : ");
	        Long id = scanner.nextLong();
	        List<Article> articles = iShopImpl.getArticlesByCategoryId(id);
	        if (articles.isEmpty()) {
	            System.out.println("Aucun article trouvé.");
	        } else {
	            for (Article article : articles) {
	                System.out.println(article);
	            }
	        }
	    }

}
