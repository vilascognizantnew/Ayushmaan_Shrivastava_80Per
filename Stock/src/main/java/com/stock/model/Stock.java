package com.stock.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stocks")
public class Stock {
	@Id
	private int stockId;
	private String stockName;
	private double price;
	private double volume;
	private Date date;
	
	
	
	public Stock() {
		super();
	}
	public Stock(int stockId, String stockName, double price, double volume, Date date) {
		super();
		this.stockId = stockId;
		this.stockName = stockName;
		this.price = price;
		this.volume = volume;
		this.date = date;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
