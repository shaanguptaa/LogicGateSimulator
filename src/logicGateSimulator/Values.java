package logicGateSimulator;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Values {
	public static String Title = "Logic Gates Simulator";
	public static int X = 275;
	public static int Y = 100;
	public static int Height = 500;
	public static int Width = 800;
	public static Color BgColor = new Color(247, 247, 247);
	public static JPanel basicPanel = new BasicPanel();
	public static JPanel advancedPanel = new AdvancedPanel();
	public static String ffState = "";
	
	public static Rectangle getBounds() {
		return new Rectangle(X, Y, Width, Height);		
	}
	
	
}
