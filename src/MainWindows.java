import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
public class MainWindows extends JFrame implements Observer {

	public MainWindows(MudDataModel model,Player player)
	{
		MainContent panel = new MainContent(model,player);
		this.add(panel);
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		this.repaint();	
	}

}
