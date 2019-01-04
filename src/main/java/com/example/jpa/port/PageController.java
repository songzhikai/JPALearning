package com.example.jpa.port;

import com.example.jpa.application.PageService;
import com.example.jpa.model.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
