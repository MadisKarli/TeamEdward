

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
public class StockItemTest {
	
	private StockItem item;
	@Before
	public void setUp() {
		item = new StockItem((long)100, "limonaad", "traditsiooniline", 1.5, 79);
	}

	
	@Test
	public void testClone() {
		
		StockItem item2 = (StockItem)item.clone();
			
		assertEquals(item2.getId(), item.getId(), 0.0001);
		assertEquals(item2.getName(), (String)item.getName());
		assertEquals(item2.getPrice(), item.getPrice(), 0.0001);
		assertEquals(item2.getDescription(), item.getDescription());
		assertEquals(item2.getQuantity(), item.getQuantity(), 0.0001);
	}

	@Test
	public void testGetColumn() {
		assertEquals(item.getId(), (long)item.getColumn(0), 0.0001);
    	assertEquals(item.getName(), (String)item.getColumn(1));
    	assertEquals(item.getPrice(), (double)item.getColumn(2), 0.0001);
    	assertEquals(item.getQuantity(), (int)item.getColumn(3), 0.0001);
	}


}
