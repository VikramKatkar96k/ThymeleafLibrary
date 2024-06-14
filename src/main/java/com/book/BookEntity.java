package com.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class BookEntity {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	Integer BOOKID;
	Double BOOKPRICE;
	String BOOKNAME;
	Character status;

	public Integer getBOOKID() {
		return BOOKID;
	}

	public void setBOOKID(Integer bOOKID) {
		BOOKID = bOOKID;
	}

	public Double getBOOKPRICE() {
		return BOOKPRICE;
	}

	public void setBOOKPRICE(Double bOOKPRICE) {
		BOOKPRICE = bOOKPRICE;
	}

	public String getBOOKNAME() {
		return BOOKNAME;
	}

	public void setBOOKNAME(String bOOKNAME) {
		BOOKNAME = bOOKNAME;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookEntity [BOOKID=" + BOOKID + ", BOOKPRICE=" + BOOKPRICE + ", BOOKNAME=" + BOOKNAME + ", status="
				+ status + "]";
	}

}
