package com.example.jpa.model.page;

import javax.persistence.*;

@Entity
@Table(name = "EPM_CONTENT_PAGE")
public class Page {
    @Id
    @Column(name = "pageId", columnDefinition = ("varchar(50)"))
    private String pageId;

    @Column(name = "shopId", columnDefinition = ("varchar(50)"))
    private String shopId;

    @Column(name = "templateId", columnDefinition = ("varchar(50)"))
    private String templateId;

    @Column(name = "name", columnDefinition = ("varchar(100)"))
    private String name;

    @Column(name = "category", columnDefinition = ("varchar(50)"))
    private String category;

    @Column(name = "navigationId", columnDefinition = ("varchar(50)"))
    private String navigationId;

    @Column(name = "style", columnDefinition = ("varchar(50)"))
    private String style;

    @Column(name = "isHomePage", columnDefinition = ("varchar(50)"))
    private String isHomePage;

    @Column(name = "state", columnDefinition = ("varchar(50)"))
    private String state;

    @Column(name = "url", columnDefinition = ("varchar(300)"))
    private String url;

    @Column(name = "qrcodeId", columnDefinition = ("varchar(50)"))
    private String qrcodeId;

    @Lob
    @Column(name = "metaJson")
    private String metaJson;

    @Column(name = "optUser", columnDefinition = ("varchar(50)"))
    private String optUser;

    @Column(name = "optTime", columnDefinition = ("varchar(50)"))
    private String optTime;

    @Column(name = "tenantId", columnDefinition = ("varchar(50)"))
    private String tenantId;

    @Column(name = "activityId", columnDefinition = ("varchar(50)"))
    private String activityId;

    @Column(name = "qcTemplate", columnDefinition = ("varchar(100)"))
    private String qcTemplate;

    @Column(name = "opResourcesId", columnDefinition = ("varchar(5000)  default null comment '运营位图片(资源编码)'"))
    private String opResourcesId;

    @Column(name = "opResourcesPath", columnDefinition = ("text  default null comment '运营位图片途径'"))
    private String opResourcesPath;

    /*2018.10.17增加是否动态组件*/
    @Column(name = "isDynComp", columnDefinition = ("varchar(500)"))
    private String isDynComp;//是否动态组件 1,2,3  第一位是1表示是动态组件  后面的2,3  表示有那些动态组件  如果只有0 那就是不包含动态组件

    /*2018.10.31区分页面是系统页面或者是其他页面*/
    @Column(name = "pageType", columnDefinition = ("varchar(50)"))
    private String pageType;// 1是系统页面,1是其他页面

    /*2018.11.12增加静态页面直接通过路由跳转*/
    @Column(name = "pageRoot", columnDefinition = ("varchar(50)"))
    private String pageRoot;//页面来源,1真实数据 2静态页面

    /*2018.11.12增加静态页面直接通过路由跳转*/
    @Column(name = "pageRoute")
    private String pageRoute;//pageRoot为2是  这里记录路由

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(String navigationId) {
        this.navigationId = navigationId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIsHomePage() {
        return isHomePage;
    }

    public void setIsHomePage(String isHomePage) {
        this.isHomePage = isHomePage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getQrcodeId() {
        return qrcodeId;
    }

    public void setQrcodeId(String qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

    public String getMetaJson() {
        return metaJson;
    }

    public void setMetaJson(String metaJson) {
        this.metaJson = metaJson;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    public String getOptTime() {
        return optTime;
    }

    public void setOptTime(String optTime) {
        this.optTime = optTime;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getQcTemplate() {
        return qcTemplate;
    }

    public String getOpResourcesId() {
        return opResourcesId;
    }

    public void setOpResourcesId(String opResourcesId) {
        this.opResourcesId = opResourcesId;
    }

    public String getOpResourcesPath() {
        return opResourcesPath;
    }

    public void setOpResourcesPath(String opResourcesPath) {
        this.opResourcesPath = opResourcesPath;
    }

    public String getIsDynComp() {
        return isDynComp;
    }

    public void setIsDynComp(String isDynComp) {
        this.isDynComp = isDynComp;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    //protected
    public Page setQcTemplate(String qcTemplate) {
        this.qcTemplate = qcTemplate;
        return this;
    }

    public String getPageRoot() {
        return pageRoot;
    }

    public void setPageRoot(String pageRoot) {
        this.pageRoot = pageRoot;
    }

    public String getPageRoute() {
        return pageRoute;
    }

    public void setPageRoute(String pageRoute) {
        this.pageRoute = pageRoute;
    }
}