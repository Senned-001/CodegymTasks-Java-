package com.codegym.task.task28.task2810.vo;

import java.util.Objects;

public class JobPosting {
    private String title;
    private String city;
    private String companyName;
    private String websiteName;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobPosting)) return false;
        JobPosting that = (JobPosting) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(city, that.city) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(websiteName, that.websiteName) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, city, companyName, websiteName, url);
    }
}
