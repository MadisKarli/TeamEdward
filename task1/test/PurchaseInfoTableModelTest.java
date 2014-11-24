import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseInfoTableModelTest {

	private StockItem stockitem1;
	private StockItem stockitem2;
	private StockItem stockitem3;

	private SoldItem solditem1;
	private SoldItem solditem2;
	private SoldItem solditem3;

	@Before
	public void setUp() {

		stockitem1 = new StockItem((long) 100, "Caffe Latte", "Piimane", 5.50,
				20);
		stockitem2 = new StockItem((long) 101, "Cappuccino", "Kergelt piimane",
				5, 30);
		stockitem3 = new StockItem((long) 102, "Espresso", "Good morning", 7,
				40);

		solditem1 = new SoldItem(stockitem1, 2);
		solditem2 = new SoldItem(stockitem2, 3);
		solditem3 = new SoldItem(stockitem3, 4);

	}

	@Test
	public void testAddSoldItem() {
		PurchaseInfoTableModel purchase = new PurchaseInfoTableModel();
		purchase.addItem(solditem1);
		assertSame(purchase.getItems().get(0), solditem1);
	}

	@Test
	public void testGetSumWithNoItems() {
		PurchaseInfoTableModel purchase = new PurchaseInfoTableModel();
		assertEquals(purchase.getPurchaseSum(), 0, 0.001);
	}

	@Test
	public void testGetSumWithOneItem() {
		PurchaseInfoTableModel purchase = new PurchaseInfoTableModel();
		purchase.addItem(solditem3);
		assertEquals(purchase.getPurchaseSum(), 28, 0.001);
	}

	@Test
	public void testGetSumWithMultipleItems() {
		PurchaseInfoTableModel purchase = new PurchaseInfoTableModel();
		purchase.addItem(solditem1);
		purchase.addItem(solditem2);
		purchase.addItem(solditem3);
		assertEquals(purchase.getPurchaseSum(), (11 + 15 + 28), 0.001);
	}
}
