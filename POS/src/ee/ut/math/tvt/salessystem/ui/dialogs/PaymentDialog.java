package ee.ut.math.tvt.salessystem.ui.dialogs;
//TODO kui vajutab done, siis salvestab ostu historysse!
//logid ka 
//kui cancel, siis taastab lao seisu
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class PaymentDialog {
	private SalesSystemModel model;
	private JDialog dialog;
	private JTextField totalSum, paymentAmount, changeAmount;


	public PaymentDialog(SalesSystemModel model) {
		super();
		this.model = model;

		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame.setDefaultLookAndFeelDecorated(true);

		dialog = new JDialog();
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(250, 250);

		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		totalSum = new JTextField(String.valueOf(model.getCurrentPurchaseTableModel().getPurchaseSum()));
		paymentAmount = new JTextField();
		changeAmount = new JTextField();

		//listener for Payment Amount
		paymentAmount.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				changeAmount.setText(String.valueOf((double)Math.round(100*(Float.parseFloat(paymentAmount
						.getText()) - Float.parseFloat(totalSum.getText())))/100));
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				try {
					changeAmount.setText(String.valueOf((double)Math.round(100*(Float.parseFloat(paymentAmount
							.getText()) - Float.parseFloat(totalSum.getText())))/100));
				} catch (NumberFormatException e) {
				}
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				try {
					changeAmount.setText(String.valueOf((double)Math.round(100*(Float.parseFloat(paymentAmount
							.getText()) - Float.parseFloat(totalSum.getText())))/100));
				} catch (NumberFormatException e) {
				}
			}

		});
		
		mainPanel.add(new JLabel("Total sum:"));
		mainPanel.add(totalSum);
		mainPanel.add(new JLabel("Payment amount:"));
		mainPanel.add(paymentAmount);
		mainPanel.add(new JLabel("Change amount: "));
		mainPanel.add(changeAmount);
		mainPanel.add(createDoneButton());
		mainPanel.add(createCancelButton());
		dialog.add(mainPanel);
		
		totalSum.setEditable(false);
		changeAmount.setEditable(false);
		
		// Center the window
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - dialog.getWidth()) / 2;
		int y = (screenSize.height - dialog.getHeight()) / 2;
		
		dialog.setLocation(x, y);
		dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		dialog.setVisible(true);
		


	}
	
	//create Done and Cancel buttons.

	private JButton createDoneButton() {
		JButton a = new JButton("Done");
		a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doneButtonClicked();
			}
		});
		a.setEnabled(true);

		return a;
	}

	protected void doneButtonClicked() {
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
