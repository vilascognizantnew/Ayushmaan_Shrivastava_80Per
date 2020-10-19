package com.stock.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockDAO;
import com.stock.model.Stock;

@Service
public class StockService {
	
	@Autowired
	StockDAO stockDao;
	
	public List<Stock> allStock(){
		return (List<Stock>) stockDao.findAll();
	}
	
	public List<Stock> topFiveStock(){
		return (List<Stock>) stockDao.findTopFiveStocks();
	}
	
	public Stock searchStockById(int id){
		Optional<Stock> s = stockDao.findById(id);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public Stock searchStockByName(String name){
		Optional<Stock> s = stockDao.findByStockName(name);
		if(s.isPresent()){
			return s.get();
		}
		return null;
	}
	
	public List<Stock> searchStockByPrice(Double startPrice, Double endPrice){
		return (List<Stock>) stockDao.findByPriceBetween(startPrice,endPrice);
	}
	
	public List<Stock> searchStockByVolume(Double startVolume, Double endVolume){
		return (List<Stock>) stockDao.findByVolumeBetween(startVolume,endVolume);
	}
	
	public List<Stock> searchStockByDate(Date startDate, Date endDate){
		return (List<Stock>) stockDao.findByDateBetween(startDate,endDate);
	}
	
}
