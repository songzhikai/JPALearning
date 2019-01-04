package com.example.jpa.infrastructure.page;

import com.example.jpa.model.page.Page;
import com.example.jpa.model.page.PageCompose;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPageJpaRepo extends JpaRepository<Page, String>{

    org.springframework.data.domain.Page findAll(Specification<Page> specification, Pageable pageable);

    Page findByPageId(@Param("id") String id);

    @Query(value="select new com.example.jpa.model.page.PageCompose(p, pc)  from Page p left join PageCategory pc on p.category = pc.categoryId where pc.categoryId = :category")
    List<PageCompose> findAllByCategory(@Param("category") String category);
}
