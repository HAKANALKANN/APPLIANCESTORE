package com.finalProject.applianceStore.applianceStore.dataaccess;

import com.finalProject.applianceStore.applianceStore.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Integer> {

    Optional<Categories> findAllById(int categoriesId);
}
