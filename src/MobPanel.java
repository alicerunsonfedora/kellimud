import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class MobPanel extends JPanel implements Observer {

	private int CurrentHealth=10,MaxHealth=10;
	private JLabel health = new JLabel("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
	public MobPanel() 
	{
    	super.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        CurrentHealth = Room.mob().health();
        MaxHealth = Room.mob().level()*10;
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
        TheGame.MobObserver(this);
    	super.setBackground(Color.white);

	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	MudDataModel model = (MudDataModel) o;
    	CurrentHealth = model.getMobHealth();
    	MaxHealth = model.getMobLevel()*10;
    	health.setText("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
    	this.repaint();
    }

}