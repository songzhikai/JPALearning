package com.example.jpa.application;

import com.example.jpa.infrastructure.page.IPageJpaRepo;
import com.example.jpa.model.page.Page;
import com.example.jpa.model.page.PageCompose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {
    @Autowired
    private IPageJpaRepo iPageJpaRepo;

    public Page findByPageId(String id){
        Page page = iPageJpaRepo.findByPageId(id);
        return page;
    }
    public List<PageCompose> findAllByCategory(String category){
        List<PageCompose> list = iPageJpaRepo.findAllByCategory(category);
        return list;
    }
    public org.springframework.data.domain.Page<Page> queryPageList(String pageName, String category, String sortProp, String sortOrder,
                                    int pageNumber, int pageSize){
        Sort sort = null;
        if(sortOrder != null && sortOrder.toLowerCase().startsWith("asc")){
            sort = new Sort(Sort.Direction.ASC, sortProp);
        }else if(sortOrder != null && sortOrder.toLowerCase().startsWith("desc")){
            sort = new Sort(Sort.Direction.DESC, sortProp);
        }
        Pageable pageable = null;
        if(sort == null){
            pageable = new PageRequest(pageNumber, pageSize);
        }else{
            pageable = new PageRequest(pageNumber, pageSize, sort);
        }
        Specification<Page> specification = new Specification<Page>() {
            @Override
            public Predicate toPredicate(Root<Page> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if(!"".equals(pageName)&&null!=pageName) {
                    Predicate p1 = criteriaBuilder.like(root.get("name").as(String.class), "%" + pageName + "%");
                    list.add(p1);
                }
                if(!"".equals(category)&&null!=category) {
                    Predicate p1 = criteriaBuilder.equal(root.get("category").as(String.class), category);
                    list.add(p1);
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        };
        org.springframework.data.domain.Page<Page> list = iPageJpaRepo.findAll(specification, pageable);
        return list;
    }
}
