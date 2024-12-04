package edu.mga.henrybookstore;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("id")
    private Long id;

    @SerializedName("author")
    private String author;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    @SerializedName("price")
    private String price;

    public Book(String s, String toString, String string, String s1, String toString1, String string1){
    }
    public Book(Long id){
        this.id = id;
    }

    public Book(String author,String title, String description,String thumbnailUrl, String price){
        this.author = author;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
    }
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return author;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public String getPrice() {
        return price;
    }


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(Long description) {
        this.id = description;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setPrice(String price) {
        this.price= price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

