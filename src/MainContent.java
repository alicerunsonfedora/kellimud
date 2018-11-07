import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class MainContent extends JPanel implements Observer {

	private Image background = Toolkit.getDefaultToolkit().createImage("src/res/bg.png");
	public MainContent() 
	{
		/*
		this.setLayout(new BorderLayout());
		PlayerPanel g = new PlayerPanel();
		MobPanel g1 = new MobPanel();
		JLabel exit = new JLabel("");
		this.setOpaque(false);
		g.setOpaque(false);
		g1.setOpaque(false);
		this.add(g,BorderLayout.LINE_START);
		this.add(exit,BorderLayout.CENTER);
		this.add(g1,BorderLayout.LINE_END);
		TheGame.MainObserver(this);
		*/
	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }

	@Override
	public void update(Observable o, Object arg) 
	{
		this.repaint();	
	}

}
