package me.nabeelkottol.spotsoon;

/**
 * Created by nabeelkottol on 12/06/17.
 */

public class Item {
  private int coverArt;
  private String description;
  private String time;
  private String title;

  public Item(int coverArt, String title, String time, String description) {
    this.coverArt = coverArt;
    this.description = description;
    this.time = time;
    this.title = title;
  }

  public int getDrawable() {
    return coverArt;
  }

  public void setDrawable(int coverArt) {
    this.coverArt = coverArt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
