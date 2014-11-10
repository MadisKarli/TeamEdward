package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ee.ut.math.tvt.salessystem.ui.dialogs.PurchaseHistoryDialog;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {

	private SalesSystemModel model;

	// TODO - implement!

	public HistoryTab(SalesSystemModel model) {
		this.model = model;

	}

	public Component draw() {
		// Create the basketPane
		JPanel historyPane = new JPanel();
		historyPane.setLayout(new GridBagLayout());
		historyPane.setBorder(BorderFactory
				.createTitledBorder("Purchase History"));

		// Create the table, put it inside a scollPane,
		// and add the scrollPane to the historyPanel.
		final JTable table = new JTable(model.getHistoryTableModel());
		JScrollPane scrollPane = new JScrollPane(table);

		historyPane.add(scrollPane, getHistoryPaneConstraints());

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int col = table.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					new PurchaseHistoryDialog(model.getHistoryTableModel()
							.getTableRows().get(row).getPurchase());
				}
			}
		});

		return historyPane;
	}

	private GridBagConstraints getHistoryPaneConstraints() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		return gc;
	}
}