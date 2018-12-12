import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import mdlaf.*;                        // Using Material Design components

public class MainContent extends JPanel implements Observer {

	private Image background;
	private MudDataModel thisModel;
	public MainContent(MudDataModel model,Player player)
	{
		changeBackground(1);

		try {
			UIManager.setLookAndFeel (new MaterialLookAndFeel ());
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace ();
		}

		this.setLayout(new BorderLayout());
		thisModel = model;
		PlayerPanel g = new PlayerPanel(thisModel,player);
		MobPanel g1 = new MobPanel(thisModel,player);
		JLabel exit = new JLabel("");
		this.setOpaque(false);
		g.setOpaque(false);
		g1.setOpaque(false);
		this.add(g,BorderLayout.LINE_START);
		this.add(exit,BorderLayout.CENTER);
		this.add(g1,BorderLayout.LINE_END);
		TheGame.MainObserver(player,this);
	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }

    public void changeBackground(int bgNumber) {

		background = Toolkit.getDefaultToolkit().createImage("src/res/bg" + Integer.toString(bgNumber) + ".png");

	}

	@Override
	public void update(Observable o, Object arg) 
	{
		this.repaint();
	}

}
