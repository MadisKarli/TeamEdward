import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class HistoryTableModelTest {

	private StockItem stockitem1;
	private StockItem stockitem2;
	private StockItem stockitem3;

	private SoldItem solditem1;
	private SoldItem solditem2;
	private SoldItem solditem3;

	private PurchaseInfoTableModel purchaseInfo1;
	private PurchaseInfoTableModel purchaseInfo2;

	private HistoryTableModel history;

	@Before
	public void setUp() {

		purchaseInfo1 = new PurchaseInfoTableModel();
		purchaseInfo2 = new PurchaseInfoTableModel();
		history = new HistoryTableModel();
		stockitem1 = new StockItem((long) 100, "Caffe Latte", "Piimane", 5.50,
				20);
		stockitem2 = new StockItem((long) 101, "Cappuccino", "Kergelt piimane",
				5, 30);
		stockitem3 = new StockItem((long) 102, "Espresso", "Good morning", 7,
				40);
	}

	@Test
	public void testAddPurchaseOneItem() {
		solditem1 = new SoldItem(stockitem1, 2);
		purchaseInfo1.addItem(solditem1);
		history.addPurchase(purchaseInfo1);

		assertSame((history.getItems().get(0)).getPurchase(), purchaseInfo1);

	}

	@Test
	public void testAddPurchaseMultipleItem() {
		solditem1 = new SoldItem(stockitem1, 2);
		solditem2 = new SoldItem(stockitem2, 3);
		solditem3 = new SoldItem(stockitem3, 4);

		purchaseInfo1.addItem(solditem1);
		purchaseInfo2.addItem(solditem2);
		purchaseInfo2.addItem(solditem3);
		history.addPurchase(purchaseInfo1);
		history.addPurchase(purchaseInfo2);
		assertSame((history.getItems().get(0)).getPurchase(), purchaseInfo1);
		assertSame((history.getItems().get(1)).getPurchase(), purchaseInfo2);

	}

}
