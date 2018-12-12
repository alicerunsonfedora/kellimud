import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
public class MainWindows extends JFrame implements Observer {

	private MainContent x;
	private int width = 1280;
	private int height = 720;

	public MainWindows(MudDataModel model,Player player)
	{
		MainContent x = new MainContent(model,player);
		this.x = x;
		MainContent panel = this.x;
		this.add(panel);

		setSize(width, height);
		setTitle(player.name() + " - Realm of the Mad Tom");
		setResizable(false);
		setVisible(true);
	}

	public MainContent GetContent()
	{
		return this.x;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		this.repaint();	
	}

}
