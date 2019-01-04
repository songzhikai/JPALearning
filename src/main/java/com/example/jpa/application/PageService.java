package com.example.jpa.application;

import com.example.jpa.infrastructure.page.IPageJpaRepo;
import com.example.jpa.model.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
    @Autowired
    private IPageJpaRepo iPageJpaRepo;

    public Page findByPageId(String id){
        Page page = iPageJpaRepo.findByPageId(id);
        return page;
    }
}
