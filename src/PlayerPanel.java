import java.awt.*;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class PlayerPanel extends JPanel implements Observer {

	public PlayerPanel() 
	{

	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	
    }

}