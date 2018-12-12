import org.omg.CORBA.Current;

import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.*;

public class PlayerPanel extends JPanel implements Observer {

    private int CurrentHealth = 42;
    private JLabel health = new JLabel("Your Health " + Integer.toString(CurrentHealth) + "/42");
    private JButton attackButton;
    private JButton healButton;
    private JButton equipButton;

    private GridBagConstraints viewConstraints;

    Icon attackIcon;
    Icon healIcon;
    Icon equipIcon;

    private MudDataModel model;
	public PlayerPanel(MudDataModel model,Player player)
	{
		this.model= model;
        attackIcon = new ImageIcon("src/res/sword.png");
        healIcon = new ImageIcon("src/res/health.png");
        equipIcon = new ImageIcon("src/res/inventory.png");

    	super.setLayout(new GridBagLayout());
        viewConstraints = new GridBagConstraints();
    	// Normally, we'd set text here, but we're using an icon.
        attackButton = new JButton("");
        viewConstraints.gridwidth= GridBagConstraints.REMAINDER;
        viewConstraints.fill= viewConstraints.HORIZONTAL;
        GridBagConstraints gc= new GridBagConstraints();
         
        //gc.insets = new Insets(6, 6, 6, 6);
        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 1;

        attackButton.setToolTipText("Attack");
        attackButton.setPreferredSize(new Dimension(48,48));
        attackButton.setMinimumSize(new Dimension(48,48));
        attackButton.setIcon(attackIcon);

        super.add(attackButton,gc);
        attackButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable(player).attack();
            }
         });
        // Normally, we'd set text, but the icon replaces this.
        healButton = new JButton("");
        healButton.setToolTipText("Heal");
        healButton.setPreferredSize(new Dimension(48,48));
        healButton.setMinimumSize(new Dimension(48,48));
        healButton.setIcon(healIcon);

        gc.gridx = 1;
        healButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable(player).heal();               
            }
         });
        super.add(healButton,gc);

        // We'd normally set text, but we have an icon instead
        equipButton = new JButton("");
        equipButton.setToolTipText("Equip");
        equipButton.setPreferredSize(new Dimension(48,48));
        equipButton.setMinimumSize(new Dimension(48,48));
        gc.gridx = 2;

        equipButton.setIcon(equipIcon);

        super.add(equipButton, gc);
        equipButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable(player).equip();
            }
         });
        gc.gridx = 0;
        gc.insets = new Insets(16, 16, 6, 6);
        health.setMinimumSize(new Dimension(130,30));
        health.setForeground(Color.white);
        Font font = health.getFont();
        health.setFont(font.deriveFont(Font.PLAIN, 24f));

        health.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "The Realm of the Mad Tom is committed to the well-being of its prisoners.\nSafe Java practice counseling will be available at the end of your death.", "Game Over", JOptionPane.WARNING_MESSAGE);
                model.setPlayerHealth(1);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gc.gridy = 0;
        super.add(health, gc);
        TheGame.PlayerObserver(player,this);
	}
	
    public void paintComponent(Graphics g)
    {
    	CurrentHealth = model.getPlayerHealth();
    	if (CurrentHealth <= 10) {
    	    health.setForeground(Color.red);
        } else {
    	    health.setForeground(Color.white);
        }
        health.setText("Your Health " + Integer.toString(CurrentHealth) + "/42");
        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	this.repaint();
    }

}