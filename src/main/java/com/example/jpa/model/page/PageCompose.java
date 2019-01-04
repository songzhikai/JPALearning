package com.example.jpa.model.page;

public class PageCompose {
    private Page page;
    private PageCategory pageCategory;
    public PageCompose(Page page, PageCategory pageCategory){
        this.page = page;
        this.pageCategory = pageCategory;
    }
    public Page getPage(){
        return page;
    }
    public PageCategory getPageCategory(){
        return pageCategory;
    }
}
