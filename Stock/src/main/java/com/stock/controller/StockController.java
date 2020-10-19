package com.stock.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.stock.model.Stock;
import com.stock.service.StockService;

@Controller
public class StockController {
	
	@Autowired
	StockService stockService;
	
	@GetMapping(value="/allStocks")
	public ResponseEntity<?> stockList()
	{
		return new ResponseEntity<List<Stock>>(stockService.allStock(),HttpStatus.OK);
	}
	
	@GetMapping(value="/topFiveStocks")
	public ResponseEntity<?> topFiveStocks()
	{
		return new ResponseEntity<List<Stock>>(stockService.topFiveStock(),HttpStatus.OK);
	}
	
	@GetMapping(value="/searchStockById/{id}")
	public ResponseEntity<?> searchStockById(@PathVariable("id") int id)
	{
		Stock stck = stockService.searchStockById(id);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stock>(stck,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchStockByName/{name}")
	public ResponseEntity<?> searchStockById(@PathVariable("name") String name)
	{
		Stock s = stockService.searchStockByName(name);
		if(s==null){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stock>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchStockByPrice/{startPrice}/{endPrice}")
	public ResponseEntity<?> searchStockByPrice(@PathVariable("startPrice") Double startPrice, @PathVariable("endPrice") Double endPrice )
	{
		List<Stock> s = stockService.searchStockByPrice(startPrice,endPrice);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Stock>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchStockByVolume/{startVolume}/{endVolume}")
	public ResponseEntity<?> searchStockByVolume(@PathVariable("startVolume") Double startVolume, @PathVariable("endVolume") Double endVolume )
	{
		List<Stock> s = stockService.searchStockByVolume(startVolume,endVolume);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Stock>>(s,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchStockByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchStockById(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<Stock> s = stockService.searchStockByDate(startDate,endDate);
		if(s.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Stock>>(s,HttpStatus.OK);
	}
}
