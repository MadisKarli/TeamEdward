package ee.ut.math.tvt.salessystem.ui.dialogs;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseHistoryDialog {
	private PurchaseInfoTableModel purchase;
	private JDialog dialog;

	public PurchaseHistoryDialog(PurchaseInfoTableModel purchase) {
		super();
		this.purchase = purchase;

		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);

		dialog = new JDialog();
		JPanel mainPanel = new JPanel();
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(400, 300);

		// Create the basketPane
		// JPanel historyPane = new JPanel();
		mainPanel.setLayout(new GridBagLayout());

		// Create the table, put it inside a scollPane,
		// and add the scrollPane to the historyPanel.
		final JTable table = new JTable(purchase);
		JScrollPane scrollPane = new JScrollPane(table);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - dialog.getWidth()) / 2;
		int y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);

		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

		mainPanel.add(scrollPane, getPurchasePaneConstraints());
		dialog.add(mainPanel);
		dialog.setVisible(true);
	}

	private GridBagConstraints getPurchasePaneConstraints() {
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		return gc;
	}
}
