import java.awt.*;
import javax.swing.*;

public class MainContent extends JPanel {

	private Image background = Toolkit.getDefaultToolkit().createImage("src/res/bg.png");
	public MainContent() 
	{

	}
	
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(background,0,0,this);
    }

}
