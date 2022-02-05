package logicGateSimulator;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class LogicGateSimulator extends JFrame {

	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogicGateSimulator frame = new LogicGateSimulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LogicGateSimulator() {
		
		setTitle("Logic Gates Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(Values.getBounds());
		setResizable(false);		
		setContentPane(Values.basicPanel);
	}
}
