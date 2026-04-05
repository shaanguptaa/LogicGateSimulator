package logicGateSimulator;

import java.awt.EventQueue;
import java.io.Serial;
import javax.swing.JFrame;

public class LogicGateSimulator extends JFrame {

	@Serial
    private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		try {
			EventQueue.invokeLater(() -> {
				try {
					LogicGateSimulator frame = new LogicGateSimulator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Error creating frame: " + e.getMessage());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in main: " + e.getMessage());
		}
	}

	public LogicGateSimulator() {
		
		setTitle("Logic Gates Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(Values.getBounds());
		setResizable(false);		
		setContentPane(Values.getBasicPanel());
	}
}
