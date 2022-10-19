package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceTest {
	
	@InjectMocks
	StockServiceImpl mockAS;
	@Mock
	StockRepository mockAR;
	
	@Autowired
	IStockService AS;

	@Test
	@Order(1)
	public void retrieveAllStockReturnsEmptyListWhenDbIsEmpty() {
		List<Stock> listStock = AS.retrieveAllStocks();
		Assertions.assertEquals(0, listStock.size());
	}

	/*@Test
	@Order(2)
	public void retrieveAllStockMocked() {
		// create mock list
		List<Stock> mockedList = new ArrayList<Stock>();
		mockedList.add(new Stock("1", "food"));
		mockedList.add(new Stock("2", "sport"));
		mockedList.add(new Stock("3", "music"));

		Mockito.when(mockAR.findAll()).thenReturn(mockedList);
		List<Stock> listStock = mockAS.retrieveAllStocks();
		Assertions.assertEquals(3, listStock.size());
	}

	@Test
	@Order(3)
	public void testAddDeleteRetrieveAllWithDb() {
		List<Stock> addedStock = new ArrayList<Stock>();

		addedStock.add(AS.addStock(new Stock("1", "food")));
		addedStock.add(AS.addStock(new Stock("2", "sport")));
		addedStock.add(AS.addStock(new Stock("3", "music")));

		List<Stock> listStock = AS.retrieveAllStocks();
		Assertions.assertEquals(3, listStock.size());

		for (int i = 0; i < addedStock.size(); i++) {
			Stock secteurActivite = addedStock.get(i);
			AS.deleteStock(secteurActivite.getIdStock());
		}

		listStock = AS.retrieveAllStocks();
		Assertions.assertEquals(0, listStock.size());
	}

	@Test
	@Order(4)
	public void testUpdateWithDb() {
		Stock secteurActivite = AS.addStock(new Stock("1", "food"));
		
		Assertions.assertEquals("1", secteurActivite.getCodeStock());
		Assertions.assertEquals("food", secteurActivite.getLibelleStock());
		
		secteurActivite.setCodeStock("2");
		secteurActivite.setLibelleStock("sport");
		
		Stock updatedStock = AS.updateStock(secteurActivite);
		
		Assertions.assertEquals(secteurActivite.getIdStock(), updatedStock.getIdStock());
		Assertions.assertEquals("2", updatedStock.getCodeStock());
		Assertions.assertEquals("sport", updatedStock.getLibelleStock());
		
		AS.deleteStock(updatedStock.getIdStock());
	}
	
	@Test
	@Order(5)
	public void testRetrieveByIdWithDb() {
		Stock secteurActivite = AS.addStock(new Stock("1", "food"));
		
		Stock retrievedStock = AS.retrieveStock(secteurActivite.getIdStock());
		
		Assertions.assertEquals(secteurActivite.getIdStock(), retrievedStock.getIdStock());
		Assertions.assertEquals(secteurActivite.getCodeStock(), retrievedStock.getCodeStock());
		Assertions.assertEquals(secteurActivite.getLibelleStock(), retrievedStock.getLibelleStock());
		
		AS.deleteStock(retrievedStock.getIdStock());
	}
	
	@Test
	@Order(6)
	public void testRetrieveByIdNullIfNotExistWithDb() {
		Stock retrievedStock = AS.retrieveStock(5L);
		
		Assertions.assertNull(retrievedStock);
	}*/
}