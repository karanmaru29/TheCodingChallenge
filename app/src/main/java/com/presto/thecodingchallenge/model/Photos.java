package com.presto.thecodingchallenge.model;

import java.util.List;

public class Photos {
  private String total;
  private String page;
  private String pages;
  private List<Photo> photo;
  private String perpage;

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public List<Photo> getPhoto() {
    return photo;
  }

  public void setPhoto(List<Photo> photo) {
    this.photo = photo;
  }

  public String getPerpage() {
    return perpage;
  }

  public void setPerpage(String perpage) {
    this.perpage = perpage;
  }

  @Override public String toString() {
    return "ClassPojo [total = "
        + total
        + ", page = "
        + page
        + ", pages = "
        + pages
        + ", photo = "
        + photo
        + ", perpage = "
        + perpage
        + "]";
  }
}
