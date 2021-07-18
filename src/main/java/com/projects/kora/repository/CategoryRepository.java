package com.projects.kora.repository;

import com.projects.kora.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Integer findBitmapIdByCatName(String cat);
}
