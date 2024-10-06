package graficos;
import java.awt.*;
import javax.swing.*;

public class Layout2 
{

	public static void main(String[] args) 
	{
		FrameLayout2 myFrame=new FrameLayout2();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class FrameLayout2 extends JFrame
{
	public FrameLayout2()
	{
		Toolkit myScreen=Toolkit.getDefaultToolkit();
		Dimension screenSize=myScreen.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		setSize(width/2,height/2);
		setLocation(width/4,height/4);
		setTitle("Layout 2");
		LaminaDisp lamina=new LaminaDisp();
		add(lamina);
	}
}

//DIVIDO EL LAYOUT EN FILAS Y COLUMAS

class LaminaDisp extends JPanel
{
	public LaminaDisp()
	{
		
	}
}
