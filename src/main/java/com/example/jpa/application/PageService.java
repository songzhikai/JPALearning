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

import javax.persistence.criteria.*;
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
    public org.springframework.data.domain.Page<Page> queryPageList(String sortProp, String sortOrder, int pageNumber, int pageSize){
        Sort sort = null;
//        if(sortOrder != null && sortOrder.toLowerCase().startsWith("asc")){
//            sort = new Sort(Sort.Direction.ASC, sortProp);
//        }else if(sortOrder != null && sortOrder.toLowerCase().startsWith("desc")){
//            sort = new Sort(Sort.Direction.DESC, sortProp);
//        }
        Pageable pageable = null;
        if(sort == null){
            pageable = new PageRequest(pageNumber, pageSize);
        }else{
            pageable = new PageRequest(pageNumber, pageSize, sort);
        }

        //SELECT * from EPM_CONTENT_PAGE p where p.opt_user = 'U001' and (p.name = 'szk_page' or p.name = 'testhb') order by p.opt_time desc
        Specification<Page> specification = new Specification<Page>() {
            @Override
            public Predicate toPredicate(Root<Page> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> listAnd = new ArrayList<Predicate>();
                Predicate p1 = criteriaBuilder.equal(root.get("optUser").as(String.class), "U001");
                listAnd.add(p1);
                Predicate p2 = criteriaBuilder.equal(root.get("name").as(String.class), "szk_page");
                Predicate p3 = criteriaBuilder.equal(root.get("name").as(String.class), "testhb");
                Predicate p4 = criteriaBuilder.or(p2, p3);
                listAnd.add(p4);
                Predicate[] p = new Predicate[listAnd.size()];
                Predicate resPredicate = criteriaBuilder.and(listAnd.toArray(p));
//                criteriaQuery.multiselect(root.get("optUser").alias("optUser"), root.get("name").alias("name"));
                criteriaQuery.where(resPredicate);
//                List<Order> orders = new ArrayList<>();
//                orders.add(Order.asc("name"));
//                criteriaQuery.orderBy(orders);
                return criteriaQuery.getRestriction();
            }
        };
        org.springframework.data.domain.Page<Page> list = iPageJpaRepo.findAll(specification, pageable);
        return list;
    }
}
