package ee.ut.math.tvt.salessystem.ui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

/**
 * Purchase history details model.
 */
@Entity
@Table
public class PurchaseInfoTableModel extends SalesSystemTableModel<SoldItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger
			.getLogger(PurchaseInfoTableModel.class);


	public PurchaseInfoTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity", "Sum" });
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		case 4:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (String header : headers)
			buffer.append(header + "\t");
		buffer.append("\n");

		for (final SoldItem item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getName() + "\t");
			buffer.append(item.getPrice() + "\t");
			buffer.append(item.getQuantity() + "\t");
			buffer.append(item.getSum() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}
	public String columnValues() {
		final StringBuffer buffer = new StringBuffer();

		for (final SoldItem item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getName() + "\t");
			buffer.append(item.getPrice() + "\t");
			buffer.append(item.getQuantity() + "\t");
			buffer.append(item.getSum() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}
	public ArrayList getMap(){
		ArrayList<Map> tagastus1 = new ArrayList();
		for(final SoldItem item: rows){
			Map tagastus = new HashMap();
			tagastus.put("Id", item.getId());
			tagastus.put("Name", item.getName());
			tagastus.put("Price", item.getPrice());
			tagastus.put("Quantity", item.getQuantity());
			tagastus.put("Sum", item.getSum());	
			tagastus1.add(tagastus);
		}
		return tagastus1;
	}
	
	public	List<SoldItem> getItems(){
		List<SoldItem> tagastus = new ArrayList<SoldItem>();
		for(final SoldItem item: rows){
			tagastus.add(item);
		}
		return tagastus;
	}
	/**
	 * Add new StockItem to table.
	 */
	public void addItem(final SoldItem item) {
		/**
		 * XXX In case such stockItem already exists increase the quantity of
		 * the existing stock.
		 */
		for (SoldItem soldItem : rows) {
			if (soldItem.getId() == item.getId()) {
				soldItem.setQuantity(soldItem.getQuantity()
						+ item.getQuantity());
				fireTableDataChanged();
				return;
			}
		}

		rows.add(item);
		log.debug("Added " + item.getName() + " quantity of "
				+ item.getQuantity());
		fireTableDataChanged();
	}

	// getter for sum
	public float getPurchaseSum() {
		float sum = 0;
		for (SoldItem soldItem : getTableRows()) {
			sum += soldItem.getSum();
		}
		return sum;
	}





}
