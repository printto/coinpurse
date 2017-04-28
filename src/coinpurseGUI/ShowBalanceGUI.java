package coinpurseGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import coinpurse.MoneyFactory;
import coinpurse.Purse;

/**
 * Current balance GUI for Coin Purse.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Apr 28, 2017
 */
public class ShowBalanceGUI extends JFrame implements Observer{

	//Showing current balance.
	JLabel balance = new JLabel("0.0 " + MoneyFactory.getInstance().getCurrency());

	/**
	 * Create ShowBalanceGUI JFrame.
	 */
	public ShowBalanceGUI(){
		initComponents();
	}

	/**
	 * Initialize components in the JFrame.
	 */
	private void initComponents() {
		this.setTitle("Current balance.");
		this.setAlwaysOnTop(true);
		this.setLayout(new BorderLayout());
		balance.setFont(new Font("Serif", Font.PLAIN, 60));
		balance.setForeground(new Color(0xFF0000));
		JPanel panel = new JPanel();
		panel.add(balance);
		this.add(panel, BorderLayout.NORTH);
		this.pack();
	}

	/**
	 * Make this JFrame visible.
	 */
	public void run(){
		this.setVisible(true);
	}

	/**
	 * Update components in the JFrame when the information data changed.
	 */
	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse){
			Purse purse = (Purse) subject;
			balance.setText("" + purse.getBalance() + " " + MoneyFactory.getInstance().getCurrency());
		}
		this.pack();
	}
}
