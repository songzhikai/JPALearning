package com.example.jpa.infrastructure.page;

import com.example.jpa.model.page.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPageJpaRepo extends JpaRepository<Page, String>{

    Page findByPageId(@Param("id") String id);
}
