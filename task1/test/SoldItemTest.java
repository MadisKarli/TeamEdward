import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {

	private StockItem item;

	@Before
	public void setUp() {
		item = new StockItem((long) 100, "Jogurt", " ", 5, 59);
	}

	@Test
	public void testGetSum() {
		SoldItem sold = new SoldItem(item, 10);
		assertEquals(sold.getSum(), 50, 0.0001);
	}

	@Test
	public void testGetSumWithZeroQuantity() {
		SoldItem sold = new SoldItem(item, 0);
		assertEquals(sold.getSum(), 0, 0.0001);
	}

	@Test
	public void testGetStockItem() {
		SoldItem sold = new SoldItem(item, 10);
		assertSame(sold.getStockItem(), 0);
	}
}
