package ee.ut.math.tvt.salessystem.ui.model;

import java.util.List;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.Client;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {

	// Warehouse model
	private StockTableModel warehouseTableModel;

	// Current shopping cart model
	private PurchaseInfoTableModel currentPurchaseTableModel;

	// Puchase history model
	private PurchaseHistoryTableModel purchaseHistoryTableModel;

	private ClientTableModel clientTableModel;

	private Client selectedClient;

	/**
	 * Construct application model.
	 * 
	 * @param domainController
	 *            Sales domain controller.
	 */
	public SalesSystemModel(SalesDomainController domainController) {

		warehouseTableModel = new StockTableModel();
		currentPurchaseTableModel = new PurchaseInfoTableModel(this);
		purchaseHistoryTableModel = new PurchaseHistoryTableModel();
		clientTableModel = new ClientTableModel();

		// Load data from the database

		List<StockItem> stockItems = domainController.getAllStockItems();
		warehouseTableModel.populateWithData(stockItems);

	}

	public StockTableModel getWarehouseTableModel() {
		return warehouseTableModel;
	}

	public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
		return currentPurchaseTableModel;
	}

	public PurchaseHistoryTableModel getPurchaseHistoryTableModel() {
		return purchaseHistoryTableModel;
	}

	public ClientTableModel getClientTableModel() {
		return clientTableModel;
	}

	public void setPurchaseHistoryTableModel(
			PurchaseHistoryTableModel purchaseHistoryTableModel) {
		this.purchaseHistoryTableModel = purchaseHistoryTableModel;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client client) {
		this.selectedClient = client;
	}

}
