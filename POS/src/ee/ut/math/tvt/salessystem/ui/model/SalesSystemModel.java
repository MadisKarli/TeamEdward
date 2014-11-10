package ee.ut.math.tvt.salessystem.ui.model;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.dialogs.ExceptionDialog;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {

	private static final Logger log = Logger.getLogger(SalesSystemModel.class);

	// Warehouse model
	private StockTableModel warehouseTableModel;

	// Current shopping cart model
	private PurchaseInfoTableModel currentPurchaseTableModel;

	// Current history model
	private HistoryTableModel historyTableModel;

	private final SalesDomainController domainController;

	/**
	 * Construct application model.
	 * 
	 * @param domainController
	 *            Sales domain controller.
	 */
	public SalesSystemModel(SalesDomainController domainController) {
		this.domainController = domainController;

		warehouseTableModel = new StockTableModel();
		currentPurchaseTableModel = new PurchaseInfoTableModel();
		historyTableModel = new HistoryTableModel();

		// populate stock model with data from the warehouse
		warehouseTableModel.populateWithData(domainController
				.loadWarehouseState());

	}

	public StockTableModel getWarehouseTableModel() {
		return warehouseTableModel;
	}

	public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
		return currentPurchaseTableModel;
	}

	public HistoryTableModel getHistoryTableModel() {
		return historyTableModel;
	}

	public void updateWarehouseTableModel(SoldItem soldItem) {
		StockItem stockItem = warehouseTableModel.getItemById(soldItem.getId());
		int stockItemQuantity = stockItem.getQuantity();
		int soldItemQuantity = soldItem.getQuantity();
		if (stockItemQuantity > soldItemQuantity)
			stockItem.setQuantity(stockItemQuantity - soldItemQuantity);
		else {
			stockItem.setQuantity(0);
			new ExceptionDialog("We're out of " + stockItem.getName(), "Ok");
		}
	}

	public void cancelCurrentPurchase() {
		for (SoldItem item : getCurrentPurchaseTableModel().getTableRows()) {
			try {
				StockItem stockItem = warehouseTableModel.getItemById(item
						.getId());
				stockItem.setQuantity(stockItem.getQuantity()
						+ item.getQuantity());
			} catch (NoSuchElementException e) {
				warehouseTableModel.addItem(new StockItem(item.getId(), item
						.getName(), "", item.getPrice(), item.getQuantity()));
			}
		}
	}

	public SalesDomainController getDomainController() {
		return domainController;
	}

}
