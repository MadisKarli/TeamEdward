package ee.ut.math.tvt.salessystem.ui.model;

import java.util.ArrayList;
import java.util.List;

import ee.ut.math.tvt.salessystem.domain.data.Purchase;

public class HistoryTableModel extends SalesSystemTableModel<Purchase> {

	public HistoryTableModel() {
		super(new String[] { "Date of the order", "Time of the order",
				"Total order price" });
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected Object getColumnValue(Purchase purchase, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return purchase.getDate();
		case 1:
			return purchase.getTime();
		case 2:
			return purchase.getPurchase().getPurchaseSum();
		}

		throw new IllegalArgumentException("Column index out of range");
	}

	public void addPurchase(PurchaseInfoTableModel currentPurchase) {

		rows.add(new Purchase(currentPurchase));
		fireTableDataChanged();
	}

	public	List<Purchase> getItems(){
		List<Purchase> tagastus = new ArrayList<Purchase>();
		for(final Purchase item: rows){
			tagastus.add(item);
		}
		return tagastus;
	}
}
