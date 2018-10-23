package com.presto.thecodingchallenge.model;

public class FlickerResponse {

  private Photos photos;
  private String stat;
  private String message;
  private String code;

  public Photos getPhotos() {
    return photos;
  }

  public void setPhotos(Photos photos) {
    this.photos = photos;
  }

  public String getStat() {
    return stat;
  }

  public void setStat(String stat) {
    this.stat = stat;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override public String toString() {
    return "ClassPojo [photos = "
        + photos
        + ", stat = "
        + stat
        + ", message = "
        + message
        + ", code = "
        + code
        + "]";
  }
}
