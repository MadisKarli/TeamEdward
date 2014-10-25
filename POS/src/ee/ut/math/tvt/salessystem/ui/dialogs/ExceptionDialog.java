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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jgoodies.looks.windows.WindowsLookAndFeel;

public class ExceptionDialog {

	String message;
	JDialog dialog, owner;

	public ExceptionDialog(String message, JDialog owner) {
		super();
		this.message = message;

		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// JFrame.setDefaultLookAndFeelDecorated(true);

		dialog = new JDialog(owner);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 1, 10, 10));
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setSize(200, 150);

		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		mainPanel.add(new JLabel(message, SwingConstants.CENTER));
		mainPanel.add(createTryAgainButton());

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

	private JButton createTryAgainButton() {
		JButton b = new JButton("Try Again");
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
