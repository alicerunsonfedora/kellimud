import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class MobPanel extends JPanel implements Observer {

	private int CurrentHealth, MaxHealth;
	private JLabel health = new JLabel("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
	private MudDataModel model;

	private JButton leaveButton;

	private GridBagConstraints viewConstraints;

	Icon leaveIcon;

	public MobPanel(MudDataModel model)
	{
		this.model = model;
		leaveIcon = new ImageIcon("src/res/exit.png");

    	super.setLayout(new GridBagLayout());
        viewConstraints = new GridBagConstraints();
        CurrentHealth = Room.mob().health();
        MaxHealth = Room.mob().level()*10;
        viewConstraints.gridwidth= GridBagConstraints.REMAINDER;
        viewConstraints.fill= GridBagConstraints.HORIZONTAL;

        viewConstraints.insets = new Insets(16, 6, 6, 16);
        viewConstraints.anchor = GridBagConstraints.NORTH;
        viewConstraints.weightx = 0.5;
        viewConstraints.weighty = 0.5;
 
        viewConstraints.gridx = 0;
        viewConstraints.gridy = 0;

        health.setMinimumSize(new Dimension(64,32));
        health.setForeground(Color.white);
        health.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
        super.add(health,viewConstraints);

        leaveButton = new JButton("");
        leaveButton.setIcon(leaveIcon);
        leaveButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable().move();
            }
         });
        leaveButton.setMinimumSize(new Dimension(64,32));
        leaveButton.setMaximumSize(new Dimension(64,32));
        leaveButton.setPreferredSize(new Dimension(64,32));


        viewConstraints.gridy = 1;
        viewConstraints.insets = new Insets(16, 6, 6, 16);
        super.add(leaveButton, viewConstraints);
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
            health.setText("No mob present");
        }

        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	this.repaint();
    }

}