package com.example.taskFromAl;

public class AmazonNews {
    private String url;
    private String startDate;
    private String andDate;
    private String name;
    private String iconUrl;
    private String objType;

    public AmazonNews() {
        this.url = url;
        this.startDate = startDate;
        this.andDate = andDate;
        this.name = name;
        this.iconUrl = iconUrl;
        this.objType = objType;
    }

    public AmazonNews(String url, String startDate, String andDate, String name, String iconUrl, String objType) {
        this.url = url;
        this.startDate = startDate;
        this.andDate = andDate;
        this.name = name;
        this.iconUrl = iconUrl;
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
        return iconUrl;
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

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }
}
