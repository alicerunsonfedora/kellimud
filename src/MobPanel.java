import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class MobPanel extends JPanel implements Observer {

	private int CurrentHealth=10,MaxHealth=10;
	public MobPanel() 
	{
    	super.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
    	JLabel health = new JLabel("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
        gbc.gridwidth= GridBagConstraints.REMAINDER;
        gbc.fill= gbc.HORIZONTAL;
        GridBagConstraints gc= new GridBagConstraints();
         
        gc.insets = new Insets(6, 6, 6, 6);
        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
 
        gc.gridx = 0;
        gc.gridy = 0;
        health.setMinimumSize(new Dimension(130,30));
        health.setForeground(Color.white);
        health.setFont(new Font("Times",Font.PLAIN,25));
        super.add(health,gc);

	}
	
    public void paintComponent(Graphics g)
    {
    	super.setBackground(Color.white);
    	//super.setSize(100, 100);
    	//super.setBounds(864, 8, 400, 150);
        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	
    }

}