package edu.mga.restapi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {

	@Id @Column(name="id")
	@GeneratedValue
	private Long id;
	
	@Column(name="author")
	private String author;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="thumbnailurl")
	private String thumbnailUrl;
	
	@Column(name="price")
	private Double price;
	

		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
		

	public Book() {	}
	
	public Book(Long id, String author, String title, String description, String thumbnailUrl, Double price) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.description = description;
		this.thumbnailUrl = thumbnailUrl;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", thumbnailUrl=" + thumbnailUrl + ", price=" + price + "]";
	}
	
	
}
