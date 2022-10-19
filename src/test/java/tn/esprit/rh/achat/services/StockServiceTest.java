/*package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;

class StockServiceImpTest {

	@Autowired
	private IStockService stockService;
	
	@Test
	public void testAddStock() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQte(10);
		s.setQteMin(100);
		Stock savedStock= stockService.addStock(s);
		assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
		}
	
	@Test
	public void testGetStock() {
		Stock s = new Stock();
		s.setLibelleStock("stock test");
		s.setQte(10);
		s.setQteMin(100);
		Stock savedStock= stockService.addStock(s);
		Stock getStock = stockService.retrieveStock(savedStock.getIdStock());
		assertNotNull(getStock.getLibelleStock());
		assertEquals(savedStock.getIdStock(), getStock.getIdStock());
		
		stockService.deleteStock(savedStock.getIdStock());
	}
	
	@Test
	public void testUpdateStock() {
		Stock s = new Stock();
		int expected = 9;
		s.setLibelleStock("stock test");
		s.setQte(10);
		s.setQteMin(100);
		Stock savedStock= stockService.addStock(s);
		
		savedStock.setQte(expected);
		stockService.updateStock(savedStock);
		
		assertEquals(savedStock.getQte(), expected);
		
		stockService.deleteStock(savedStock.getIdStock());
	}
	
	/*
	@Test
	public void testAddOptimizedStock() {
		Stock s =  Stock.builder().libelleStock("test stock").qte(50).qteMin(10).build();
		Stock savedStock = stockService.addStock(s);
	    assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		}
		*/
	


