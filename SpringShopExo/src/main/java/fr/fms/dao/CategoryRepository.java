package fr.fms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.fms.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

	// 1.6 : Ajouter des moyens pour afficher les noms des catégories classés par ordre croissant puis décroissant
	public List<Category> findAllByOrderByNameAsc();
	public List<Category> findAllByOrderByNameDesc();
}
