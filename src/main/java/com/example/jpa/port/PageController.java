package com.example.jpa.port;

import com.example.jpa.application.PageService;
import com.example.jpa.model.page.Page;
import com.example.jpa.model.page.PageCompose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/page")
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping("/findByPageId")
    public Page findByPageId(){
        String id = "PAGE-20180628-9MP3XHCQ";
        Page page = pageService.findByPageId(id);
        return page;
    }
    @RequestMapping("/findAllByCategory")
    public List<PageCompose> findAllByCategory(){
        String id = "1";
        List<PageCompose> list = pageService.findAllByCategory(id);
        return list;
    }
    @RequestMapping("/queryPageList")
    public org.springframework.data.domain.Page<Page> queryPageList(){
        String category = "1";
        String pageName = "t";
        String sortProp = "desc";
        String sortOrder = "opt_time";
        int pageNumber = 2; //当前第几页
        int pageSize = 10; //每页个数
        org.springframework.data.domain.Page<Page> list = pageService.queryPageList(pageName, category, sortProp, sortOrder, pageNumber, pageSize);
        return list;
    }

}
