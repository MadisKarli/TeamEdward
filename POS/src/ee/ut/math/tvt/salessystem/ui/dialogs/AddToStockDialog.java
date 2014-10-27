package ee.ut.math.tvt.salessystem.ui.dialogs;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class AddToStockDialog {
	private SalesSystemModel model;
	private JDialog dialog;

	private JTextField barCodeField, nameField, priceField, quantityField,
			descriptionField;

	public AddToStockDialog(SalesSystemModel model) {
		super();
		this.model = model;

		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);

		dialog = new JDialog();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(250, 250);

		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		barCodeField = new JTextField();
		nameField = new JTextField();
		priceField = new JTextField();
		quantityField = new JTextField();
		descriptionField = new JTextField();

		mainPanel.add(new JLabel("Barcode:"));
		mainPanel.add(barCodeField);
		mainPanel.add(new JLabel("Name:"));
		mainPanel.add(nameField);
		mainPanel.add(new JLabel("Description:"));
		mainPanel.add(descriptionField);
		mainPanel.add(new JLabel("Price:"));
		mainPanel.add(priceField);
		mainPanel.add(new JLabel("Quantity:"));
		mainPanel.add(quantityField);
		mainPanel.add(createDoneButton());
		mainPanel.add(createCancelButton());

		dialog.add(mainPanel);

		// Center the window
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - dialog.getWidth()) / 2;
		int y = (screenSize.height - dialog.getHeight()) / 2;
		dialog.setLocation(x, y);

		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

		dialog.setVisible(true);
	}

	private JButton createDoneButton() {
		JButton b = new JButton("Done");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doneButtonClicked();
			}
		});
		b.setEnabled(true);

		return b;
	}

	protected void doneButtonClicked() {

		try {
			Long barCode = Long.parseLong(barCodeField.getText());
			String name = nameField.getText();
			String description = descriptionField.getText();
			double price = Double.parseDouble(priceField.getText());
			int quantity = Integer.parseInt(quantityField.getText());

			StockItem newItem = new StockItem(barCode, name, description,
					price, quantity);

			model.getWarehouseTableModel().addItem(newItem);
			dialog.dispose();
		} catch (NumberFormatException e) {
			new ExceptionDialog("Invalid input!", "Try Again");
		}

	}

	private JButton createCancelButton() {
		JButton b = new JButton("Cancel");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		b.setEnabled(true);

		return b;
	}

}
