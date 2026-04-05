package logicGateSimulator;

import java.awt.EventQueue;
import java.io.Serial;
import javax.swing.JFrame;

public class LogicGateSimulator extends JFrame {

	@Serial
    private static final long serialVersionUID = 1L;
	static void main() {
		EventQueue.invokeLater(() -> {
            try {
                LogicGateSimulator frame = new LogicGateSimulator();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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
