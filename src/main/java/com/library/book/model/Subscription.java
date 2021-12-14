package com.library.book.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subscription")
public class Subscription {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String bookId;
	private Date subsDate;
	private Date returnDate;
	private String type;
	
	@ManyToOne
	@JoinColumn(name="bookId",insertable = false, updatable = false)
	private Book book;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public Date getSubsDate() {
		return subsDate;
	}
	public void setSubsDate(Date subsDate) {
		this.subsDate = subsDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}

}
