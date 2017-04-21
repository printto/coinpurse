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

public class ShowBalanceGUI extends JFrame implements Observer{

	JLabel balance = new JLabel("0.0 " + MoneyFactory.getInstance().getCurrency());

	public ShowBalanceGUI(){
		initComponents();
	}

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

	public void run(){
		this.setVisible(true);
	}

	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse){
			Purse purse = (Purse) subject;
			balance.setText("" + purse.getBalance() + " " + MoneyFactory.getInstance().getCurrency());
		}
		this.pack();
	}
}
