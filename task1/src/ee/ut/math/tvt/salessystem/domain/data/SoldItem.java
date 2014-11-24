package ee.ut.math.tvt.salessystem.domain.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Already bought StockItem. SoldItem duplicates name and price for preserving
 * history.
 */
// @Entity
// @Table(name = "SOLDITEM")
public class SoldItem implements Cloneable, DisplayableItem {

	@Id
	// @Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// @ManyToOne(fetch=FetchType.EAGER)
	// @JoinColumn(name = "STOCKITEM_ID")
	// @Column(name = "STOCKITEM_ID", nullable = false)
	private StockItem stockItem;

	@Column(name = "STOCKITEM_ID")
	private int id2 = 23;

	@Column(name = "SALE_ID", nullable = false)
	private int sale_id;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "QUANTITY", nullable = false)
	private int quantity;

	@Column(name = "ITEMPRICE", nullable = false)
	private double price;

	@Column(name = "SALETIME", nullable = false)
	private Timestamp saletime;

	public SoldItem(StockItem stockItem, int quantity) {
		this.stockItem = stockItem;
		this.id = stockItem.getId();
		this.name = stockItem.getName();
		this.price = stockItem.getPrice();
		this.quantity = quantity;

	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public Timestamp getSaletime() {
		return saletime;
	}

	public void setSaletime(Timestamp saletime) {
		this.saletime = saletime;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getSum() {
		return price * ((double) quantity);
	}

	public StockItem getStockItem() {
		return stockItem;
	}

	public void setStockItem(StockItem stockItem) {
		this.stockItem = stockItem;
	}

}