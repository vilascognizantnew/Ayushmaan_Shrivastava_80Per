package com.stock.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.Stock;

@Repository
public interface StockDAO extends CrudRepository<Stock, Integer> {
	
	@Query(nativeQuery = true, value = "select * from stocks order by price desc limit 5;")
	public List<Stock> findTopFiveStocks();

	public Optional<Stock> findByStockName(String name);

	public List<Stock> findByPriceBetween(Double startPrice, Double endPrice);

	public List<Stock> findByVolumeBetween(Double startVolume, Double endVolume);

	public List<Stock> findByDateBetween(Date startDate, Date endDate);
	
	
}
