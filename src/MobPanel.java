import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class MobPanel extends JPanel implements Observer {

	public MobPanel() 
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