import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
public class MainWindows extends JFrame implements Observer {

	private MainContent x;
	public MainWindows(MudDataModel model,Player player)
	{
		MainContent x = new MainContent(model,player);
		this.x = x;
		MainContent panel = this.x;
		this.add(panel);
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
