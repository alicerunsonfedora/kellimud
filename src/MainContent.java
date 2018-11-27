import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.*;

public class MainContent extends JPanel implements Observer {

	private Image background;
	public MainContent(MudDataModel model)
	{
		Random bgRandom = new Random();
		int bgNumber = bgRandom.nextInt(3);

		if (bgNumber == 0) {
			bgNumber = 1;
		}

		background = Toolkit.getDefaultToolkit().createImage("src/res/bg" + Integer.toString(bgNumber) + ".png");

		this.setLayout(new BorderLayout());
		PlayerPanel g = new PlayerPanel(model);
		MobPanel g1 = new MobPanel(model);
		JLabel exit = new JLabel("");
		this.setOpaque(false);
		g.setOpaque(false);
		g1.setOpaque(false);
		this.add(g,BorderLayout.LINE_START);
		this.add(exit,BorderLayout.CENTER);
		this.add(g1,BorderLayout.LINE_END);
		TheGame.MainObserver(this);
	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }

    public void changeBackground() {
		Random bgRandom = new Random();
		int bgNumber = bgRandom.nextInt(3);

		if (bgNumber == 0) {
			bgNumber = 1;
		}

		background = Toolkit.getDefaultToolkit().createImage("src/res/bg" + Integer.toString(bgNumber) + ".png");

	}

	@Override
	public void update(Observable o, Object arg) 
	{
		Boolean didMove = (Boolean) arg;
		if (didMove) {
			changeBackground();
		}
		this.repaint();
	}

}
