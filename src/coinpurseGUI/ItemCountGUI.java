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

public class ItemCountGUI extends JFrame implements Observer {

	JLabel itemCount = new JLabel("0 Item");
	JProgressBar progressBar = new JProgressBar();

	public ItemCountGUI(){
		initComponents();
	}

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
	
	public void run(){
		this.setVisible(true);
	}

}
