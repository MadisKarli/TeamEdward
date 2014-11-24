package ee.ut.math.tvt.salessystem.domain.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class Purchase implements Cloneable, DisplayableItem {

	private LocalTime time;
	private LocalDate date;
	private PurchaseInfoTableModel purchase;

	public Purchase(PurchaseInfoTableModel purchase) {
		super();
		this.purchase = purchase;
		this.time = LocalTime.now(ZoneId.systemDefault());
		this.date = LocalDate.now(ZoneId.systemDefault());
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public PurchaseInfoTableModel getPurchase() {
		return purchase;
	}

	public void setPurchase(PurchaseInfoTableModel purchase) {
		this.purchase = purchase;
	}

	@Override
	public Long getId() {
		return null;
	}

}
