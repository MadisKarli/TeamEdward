

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	
	private StockItem item1;
	
	@Before
	public void setUp() {
		item1 = new StockItem((long)100,"Jogurt"," ",5,59);
	}

	
	@Test
	public void testGetSum() {
		SoldItem r = new SoldItem(item1, 10);
	    assertEquals(r.getSum(), 50, 0.0001);
	}

	@Test
	public void testGetSumWithZeroQuantity() {
		SoldItem r = new SoldItem(item1, 0);
	    assertEquals(r.getSum(), 0, 0.0001);
	}
}
