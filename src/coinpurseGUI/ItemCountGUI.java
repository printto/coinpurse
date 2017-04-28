package coinpurseGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import coinpurse.MoneyFactory;
import coinpurse.Purse;

/**
 * Item counting GUI for Coin Purse.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Apr 28, 2017
 */
public class ItemCountGUI extends JFrame implements Observer {

	//Label showing amount of item.
	JLabel itemCount = new JLabel("0 Item");
	//Progress bar showing how much item are stored.
	JProgressBar progressBar = new JProgressBar();

	/**
	 * Create ItemCountGUI JFrame.
	 */
	public ItemCountGUI(){
		initComponents();
	}

	/**
	 * Initialize components in the JFrame
	 */
	private void initComponents() {
		this.setTitle("Current amount of items.");
		this.setAlwaysOnTop(true);
		this.setLayout(new BorderLayout());
		itemCount.setFont(new Font("Serif", Font.PLAIN, 60));
		itemCount.setForeground(new Color(0x00FF00));
		JPanel panel = new JPanel();
		panel.add(itemCount);
		this.add(panel, BorderLayout.NORTH);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.green);
		this.add(progressBar, BorderLayout.SOUTH);
		this.pack();
	}

	/**
	 * Update components in the JFrame when the information data changed.
	 */
	@Override
	public void update(Observable subject, Object info) {
		if(subject instanceof Purse){
			Purse purse = (Purse) subject;
			if(! purse.isFull()){
				itemCount.setText(purse.count() + " Item");
				itemCount.setForeground(new Color(0x00FF00));
			}
			else{
				itemCount.setText("Full");
				itemCount.setForeground(new Color(0xFF0000));
			}
			progressBar.setMaximum(purse.getCapacity());
			progressBar.setMinimum(0);
			progressBar.setValue(purse.count());
		}
		this.pack();
	}
	
	/**
	 * Make this JFrame visible.
	 */
	public void run(){
		this.setVisible(true);
	}

}
