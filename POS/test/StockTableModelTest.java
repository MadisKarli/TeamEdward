import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {
	private StockTableModel test1;
	private StockItem stock1;
	private StockItem stock2;
	private StockItem stock3;
	long i = (long)1;
	long j = (long)2;
	long k = (long)3;

	@Before
	public void setUp() throws VerificationFailedException {
		test1 = new StockTableModel();
		stock1 = new StockItem(i, "stock1", "", 12.0, 5); // unique
		stock2 = new StockItem(j, "stock1", "", 3.0, 3); // same name as stock1
		test1.addItem(stock1);

	}

	@Test(expected = VerificationFailedException.class)
	public void testValidateNameUniqueness() throws VerificationFailedException {
		// trying to add item with name already in use
		test1.addItem(stock2);
	}

	// TODO
	@Test
	public void testHasEnoughInStock() throws VerificationFailedException {
		//since we don't have max or min values we cannot implement it correctly
		//testing with 0 qty and 5 qty and checking wheter they are bigger than 0 or not
		stock3 = new StockItem(k, "stock3", "", 15.0, 0);
		test1.addItem(stock3);
		assertTrue(test1.getItemById(i).getQuantity() >0);
		assertFalse(test1.getItemById(k).getQuantity()>0);
	}

	@Test
	public void testGetItemByIdWhenItemExists() {
		stock3 = test1.getItemById(i);
		assertEquals(stock3.getName(), stock1.getName());
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException() {
		stock3 = test1.getItemById(3);

	}
}