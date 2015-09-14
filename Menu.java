package CardGame;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JPanel 
{
	public Menu()
	{
		setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		tfStatus = new JTextField("Place a bet, then pick a card",25);
		lBet = new JLabel("Bet :");
		tfBet = new JTextField("",5);
		lMoney = new JLabel("Money :");
		tfMoney = new JTextField(Integer.toString(money),5);
		
		add(tfStatus);
		add(lBet);
		add(tfBet);
		add(lMoney);
		add(tfMoney);
	}
	
	public void reset()
	{
		tfStatus.setText("Place a bet, then pick a card");
	}
	public void addWin() 
	{
		int bet = Integer.parseInt(tfBet.getText());
		money += bet;
		tfMoney.setText(money+"");
		tfStatus.setText("You Won! Press Reset");
	}
	
	public void lost()
	{
		
		int bet = Integer.parseInt(tfBet.getText());
		money -= bet;
		tfMoney.setText(money+"");
		tfStatus.setText("You Lost! Press Reset");
	}
	public boolean checkBet()
	{
		int num;
		 try {
		        num = Integer.parseInt(tfBet.getText());
		    } catch(NumberFormatException ex)
		    {
		    	tfStatus.setText("Not a Valid Bet, try again");
		    	return false;
		    }
		 
		 if(num > money)
		 {
			 tfStatus.setText("Not a Valid Bet, try again");
			 return false;
		 }
		 else
			 return true;
	}
	
	private int money = 100;
	JTextField tfStatus, tfBet, tfMoney;
	JLabel lBet,lMoney;
	
}
