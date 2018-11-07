import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class MobPanel extends JPanel implements Observer {

	private int CurrentHealth=10,MaxHealth=10;
	private JLabel health = new JLabel("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
	private MudDataModel model;
	public MobPanel(MudDataModel model)
	{
		this.model = model;
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
        JButton button2 = new JButton("Move");
        button2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable().move();
            }
         });
        button2.setMinimumSize(new Dimension(130,30));
        button2.setForeground(Color.white);
        button2.setFont(new Font("Times",Font.PLAIN,25));
        super.add(health,gc);
        gc.gridy = 1;
        super.add(button2, gc);
        TheGame.MobObserver(this);
    	super.setBackground(Color.white);

	}
	
    public void paintComponent(Graphics g)
    {
    	CurrentHealth = model.getMobHealth();
    	MaxHealth = model.getMobLevel()*10;
    	if (model.getThisDungeon().room().MobAlive()) {
            health.setText("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
        } else {
            health.setText("");
        }

        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	this.repaint();
    }

}