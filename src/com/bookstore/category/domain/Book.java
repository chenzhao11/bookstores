package com.bookstore.category.domain;

public class Book {
private String bid;
private String bname;
private String author;
private String cid;
private String image;
private int price;
public String getBid() {
	return bid;
}
public void setBid(String bid) {
	this.bid = bid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", cid=" + cid + ", image=" + image
			+ ", price=" + price + "]";
}

}
