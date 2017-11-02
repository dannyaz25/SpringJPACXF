package com.bean;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.packt.trading.MarketWatcher;
import com.packt.trading.Portfolio;

public class StockBrokerTest {
	 MarketWatcher marketWatcher =Mockito.mock(MarketWatcher.class);
	Portfolio portfolio =Mockito.mock(Portfolio.class);
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
	 public void sanity() throws Exception {
	 assertNotNull(marketWatcher);
	 assertNotNull(portfolio);
	 }

		@Test
		public void testStockBroker() {
			fail("Not yet implemented");
		}
	
		@Test
		public void testPerform() {
			fail("Not yet implemented");
		}

}
