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
    public List<Page> queryPageList(){
        String sortOrder = "desc";
        String sortProp = "optTime";
        int pageNumber = 0; //从第几条开始查，默认是第一条
        int pageSize = 10; //每页个数
        org.springframework.data.domain.Page<Page> list = pageService.queryPageList(sortProp, sortOrder, pageNumber, pageSize);
        List<Page> res = list.getContent();
        return res;
    }

}
