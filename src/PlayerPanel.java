import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.*;
import mdlaf.*;                        // Using Material Design components
import mdlaf.utils.MaterialColors;     // Using Material Design colors
import mdlaf.animation.MaterialUIMovement;

public class PlayerPanel extends JPanel implements Observer {

    private int CurrentHealth = 42;
    private int CurrentLevel = 1;
    private JLabel health = new JLabel(Integer.toString(CurrentHealth) + "/42");
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

        try {
            UIManager.setLookAndFeel (new MaterialLookAndFeel ());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace ();
        }

    	super.setLayout(new GridBagLayout());
        viewConstraints = new GridBagConstraints();

        if (player.name().equalsIgnoreCase("Tom")) {
            attackButton = new JButton("TOM");
        } else {
            attackButton = new JButton("");
            attackButton.setIcon(attackIcon);
        }

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
        //attackButton.setPreferredSize(new Dimension(48,48));
        attackButton.setMinimumSize(new Dimension(48,48));
        attackButton.setBackground(MaterialColors.RED_500);
        MaterialUIMovement.add (attackButton, MaterialColors.GRAY_200);

        super.add(attackButton,gc);
        attackButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable(player).attack();
            }
         });

        if (player.name().equalsIgnoreCase("Tom")) {
            healButton = new JButton("TOM");
        } else {
            healButton = new JButton("");
            healButton.setIcon(healIcon);
        }

        healButton.setToolTipText("Heal");
        //healButton.setPreferredSize(new Dimension(48,48));
        healButton.setMinimumSize(new Dimension(48,48));

        healButton.setBackground(MaterialColors.AMBER_500);
        MaterialUIMovement.add (healButton, MaterialColors.GRAY_200);

        gc.gridx = 1;
        healButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
               TheGame.observable(player).heal();               
            }
         });
        super.add(healButton,gc);

        if (player.name().equalsIgnoreCase("Tom")) {
            equipButton = new JButton("TOM");
        } else {
            equipButton = new JButton("");
            equipButton.setIcon(equipIcon);
        }

        equipButton.setToolTipText("Equip");
        //equipButton.setPreferredSize(new Dimension(48,48));
        equipButton.setMinimumSize(new Dimension(48,48));
        equipButton.setBackground(MaterialColors.AMBER_500);
        MaterialUIMovement.add (equipButton, MaterialColors.GRAY_200);
        gc.gridx = 2;



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
    	CurrentLevel = model.getPlayerLevel();
    	if (CurrentHealth <= 10) {
    	    health.setForeground(MaterialColors.RED_500);
        } else if (CurrentHealth >= 10 && CurrentHealth <= 39) {
            health.setForeground(MaterialColors.YELLOW_500);
        } else {
    	    health.setForeground(MaterialColors.GREEN_500);
        }
    	if (attackButton.getText().equalsIgnoreCase("TOM")) {
            health.setText(Integer.toString(CurrentHealth) + "/42" + " (Level TOM)");
        } else {
            health.setText(Integer.toString(CurrentHealth) + "/42" + " (Level " + Integer.toString(CurrentLevel) + ")");
        }

        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	this.repaint();
    }

}