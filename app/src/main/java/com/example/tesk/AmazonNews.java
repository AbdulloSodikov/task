package com.example.tesk;

public class AmazonNews {
    private String url;
    private String startDate;
    private String andDate;
    private String name;
    private String icon;
    private String objType;

    public AmazonNews() {
        this.url = url;
        this.startDate = startDate;
        this.andDate = andDate;
        this.name = name;
        this.icon = icon;
        this.objType = objType;
    }

    public AmazonNews(String url, String startDate, String andDate, String name, String icon, String objType) {
        this.url = url;
        this.startDate = startDate;
        this.andDate = andDate;
        this.name = name;
        this.icon = icon;
        this.objType = objType;
    }

    public String getUrl() {
        return url;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getAndDate() {
        return andDate;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getObjType() {
        return objType;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setAndDate(String andDate) {
        this.andDate = andDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }
}
