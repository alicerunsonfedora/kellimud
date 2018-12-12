import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import mdlaf.*;                        // Using Material Design components
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;     // Using Material Design colors

public class MobPanel extends JPanel implements Observer {

	private int CurrentHealth, MaxHealth, CurrentLevel;
	private JLabel health = new JLabel("Mob Health " + Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth));
	private MudDataModel model;

	private JButton leaveButton;

	private GridBagConstraints viewConstraints;

	Icon leaveIcon;

	public MobPanel(MudDataModel model,Player player)
	{
		this.model = model;
		leaveIcon = new ImageIcon("src/res/exit.png");

        try {
            UIManager.setLookAndFeel (new MaterialLookAndFeel ());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace ();
        }

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
        Font font = health.getFont();
        health.setFont(font.deriveFont(Font.PLAIN, 24f));
        super.add(health,viewConstraints);

        leaveButton = new JButton("");
        leaveButton.setIcon(leaveIcon);
        leaveButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable(player).move();
            }
         });
        leaveButton.setMinimumSize(new Dimension(64,32));
        leaveButton.setMaximumSize(new Dimension(64,32));
        leaveButton.setPreferredSize(new Dimension(64,32));
        leaveButton.setBackground(MaterialColors.CYAN_500);
        MaterialUIMovement.add(leaveButton, MaterialColors.GRAY_200);


        viewConstraints.gridy = 1;
        viewConstraints.insets = new Insets(16, 6, 6, 16);
        super.add(leaveButton, viewConstraints);
        TheGame.MobObserver(player,this);
    	super.setBackground(Color.white);

	}
	
    public void paintComponent(Graphics g)
    {
    	CurrentHealth = model.getMobHealth();
    	MaxHealth = model.getMobLevel()*10;
    	CurrentLevel = model.getMobLevel();
    	if (model.getThisDungeon().room().MobAlive()) {
    	    health.setForeground(MaterialColors.BLUE_500);
            health.setText(Integer.toString(CurrentHealth) + "/" + Integer.toString(MaxHealth) + " (Level " + Integer.toString(CurrentLevel) + ")");
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