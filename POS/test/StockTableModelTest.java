

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {
	
	private StockItem item1;
	private StockItem item2;
	@Before
	public void setUp() {

		item1 = new StockItem((long) 100, "Caffe Latte", "Piimane", 5.50,
				20);
		item2= new StockItem((long) 101, "Cappuccino", "Kergelt piimane",
				5, 0);
	}

	// TODO
	public void testValidateNameUniqueness() {
	}

	@Test
	public void testHasEnoughInStock() {
		assertTrue(item1.getQuantity() >0);
		assertFalse(item2.getQuantity() >0);
	}


	// TODO
	@Test
	public void testGetItemByIdWhenItemExists() {
	}

	// TODO
	public void testGetItemByIdWhenThrowsException() {
	}
}