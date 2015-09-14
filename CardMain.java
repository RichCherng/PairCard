package CardGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CardMain extends JFrame implements ActionListener
{
	public CardMain()
	{
		
		reset = new JButton("Reset");
		reset.addActionListener(this);
		
		m = new Menu();
		i = new Card(m);
		
		m.add(reset);
		
		setLayout(new BorderLayout());
		add(m, BorderLayout.NORTH);
		add(i, BorderLayout.CENTER);

//		this.setContentPane(i);
//		this.getContentPane().add(m);
		
		setBounds(100, 100, 700, 400);
		setTitle("Card");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new CardMain();
	}
	
	private Card i;
	private Menu m;
	JButton reset;
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{	
		i.resetGame();
	}
}
