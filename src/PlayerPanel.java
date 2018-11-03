import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.*;

public class PlayerPanel extends JPanel implements Observer {

    private int CurrentHealth = 42;
	public PlayerPanel() 
	{
    	//super.setSize(400,150);
    	//super.setBounds(8, 8, 400, 150);
    	super.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
    	JButton button = new JButton("Attack");
        gbc.gridwidth= GridBagConstraints.REMAINDER;
        gbc.fill= gbc.HORIZONTAL;
        GridBagConstraints gc= new GridBagConstraints();
         
        gc.insets = new Insets(6, 6, 6, 6);
        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
 
        gc.gridx = 0;
        gc.gridy = 1;
        button.setPreferredSize(new Dimension(130,30));
        button.setMinimumSize(new Dimension(130,30));
        super.add(button,gc);
        JButton button1 = new JButton("Heal");
        button1.setPreferredSize(new Dimension(130,30));
        button1.setMinimumSize(new Dimension(130,30));
        gc.gridx = 1;
        super.add(button1,gc);
        JButton button2 = new JButton("Inventory");
        button2.setPreferredSize(new Dimension(130,30));
        button2.setMinimumSize(new Dimension(130,30));
        gc.gridx = 2;
        super.add(button2, gc);
        gc.gridx = 0;
        JLabel health = new JLabel("Your Health " + Integer.toString(CurrentHealth) + "/42");
        health.setMinimumSize(new Dimension(130,30));
        health.setForeground(Color.white);
        health.setFont(new Font("Times",Font.PLAIN,25));
        gc.gridy = 0;
        super.add(health, gc);

	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	
    }

}