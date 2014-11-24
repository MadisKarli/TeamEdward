import static org.junit.Assert.assertEquals;

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
	long i = 12345678910L;
	long j = 12314L;

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

	@Test
	public void testHasEnoughInStock() throws VerificationFailedException {
		// not sure what is expected here, just adding item and cheking stock
		stock3 = new StockItem(j, "stock3", "", 14, 10);
		test1.addItem(stock3);
		assertEquals(test1.getItemById(j).getQuantity(), 10, 0.001);
	}

	@Test
	public void testGetItemByIdWhenItemExists() {
		stock3 = test1.getItemById(i);
		assertEquals(stock3.getName(), stock1.getName());
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException() {
		stock3 = test1.getItemById(1);

	}
}
