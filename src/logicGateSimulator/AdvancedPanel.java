package logicGateSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AdvancedPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton switchMode;
	private JPanel toolbar;
	private JButton calculate_btn;
	private JLabel gate;
	private JLabel heading;
	private JLabel state_lbl;
	private JToggleButton inputA;
	private JToggleButton inputB;
	private JToggleButton inputC;
	private JToggleButton outputA;
	private JToggleButton outputB;
	private ImageIcon bit0, bit1;
	private ImageIcon haddIcon, faddIcon;
	private ImageIcon hsubIcon, fsubIcon;
	private ImageIcon srffIcon, jkffIcon;
	private ImageIcon dffIcon, tffIcon;

	
	public AdvancedPanel() {
		setName("Advanced");
		setSize(Values.Width, Values.Height);
		setBackground(Values.BgColor);
		setBorder(null);
		setLayout(null);
		
		
		
		switchMode = new JButton("Basic Mode");
		switchMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getRoot(Values.advancedPanel);
				f.setContentPane(Values.basicPanel);
				f.setTitle(Values.Title);
			}
		});
		switchMode.setFont(new Font("Dialog", Font.BOLD, 14));
		switchMode.setBackground(Color.WHITE);
		switchMode.setBounds(591, 419, 164, 38);
		add(switchMode);
		
		
		bit0 = new ImageIcon(LogicGateSimulator.class.getResource("/assets/0.png"));
		bit1 = new ImageIcon(LogicGateSimulator.class.getResource("/assets/1.png"));
		haddIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/h-add.png"));
		faddIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/f-add.png"));
		hsubIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/h-sub.png"));
		fsubIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/f-sub.png"));
		srffIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/sr-ff.png"));
		jkffIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/jk-ff.png"));
		dffIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/d-ff.png"));
		tffIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/t-ff.png"));
		
		toolbar = new JPanel();
		toolbar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.GRAY));
		toolbar.setBounds(0, 0, 180, 500);
		add(toolbar);
		toolbar.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BLOCKS");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 6, 160, 14);
		toolbar.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(0, 25, toolbar.getWidth(), 2);
		toolbar.add(separator);
		
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				switch(e.getActionCommand()) {
				case "H-ADDER": updateUI("hadd");
								break;
				case "F-ADDER": updateUI("fadd");
								break;
				case "H-SUBTRACTOR": updateUI("hsub");
								break;
				case "F-SUBTRACTOR": updateUI("fsub");
								break;
				case "SR-FLIPFLOP": updateUI("srff");
								break;
				case "JK-FLIPFLOP": updateUI("jkff");
								break;
				case "D-FLIPFLOP": updateUI("dff");
								break;
				case "T-FLIPFLOP": updateUI("tff");
								break;
				}
				
			}
			
		};
		
		JButton hadder = new JButton("HALF ADDER");
		hadder.setActionCommand("H-ADDER");
		hadder.addActionListener(actionListener);
		hadder.setBackground(Values.BgColor);
		hadder.setBounds(10, 63, 160, 23);
		toolbar.add(hadder);
		
		JButton fadder = new JButton("FULL ADDER");
		fadder.addActionListener(actionListener);
		fadder.setBackground(Values.BgColor);
		fadder.setActionCommand("F-ADDER");
		fadder.setBounds(10, 97, 160, 23);
		toolbar.add(fadder);
		
		JButton hsubtractor = new JButton("HALF SUBTRACTOR");
		hsubtractor.addActionListener(actionListener);
		hsubtractor.setBackground(Values.BgColor);
		hsubtractor.setActionCommand("H-SUBTRACTOR");
		hsubtractor.setBounds(10, 173, 160, 23);
		toolbar.add(hsubtractor);
		
		JButton fsubtractor = new JButton("FULL SUBTRACTOR");
		fsubtractor.addActionListener(actionListener);
		fsubtractor.setBackground(Values.BgColor);
		fsubtractor.setActionCommand("F-SUBTRACTOR");
		fsubtractor.setBounds(10, 207, 160, 23);
		toolbar.add(fsubtractor);
		
		JButton srflipflop = new JButton("SR FLIP FLOP");
		srflipflop.addActionListener(actionListener);
		srflipflop.setBackground(Values.BgColor);
		srflipflop.setActionCommand("SR-FLIPFLOP");
		srflipflop.setBounds(10, 283, 160, 23);
		toolbar.add(srflipflop);
		
		JButton jkflipflop = new JButton("JK FLIP FLOP");
		jkflipflop.addActionListener(actionListener);
		jkflipflop.setBackground(Values.BgColor);
		jkflipflop.setActionCommand("JK-FLIPFLOP");
		jkflipflop.setBounds(10, 317, 160, 23);
		toolbar.add(jkflipflop);
		
		JButton dflipflop = new JButton("D FLIP FLOP");
		dflipflop.addActionListener(actionListener);
		dflipflop.setBackground(Values.BgColor);
		dflipflop.setActionCommand("D-FLIPFLOP");
		dflipflop.setBounds(10, 351, 160, 23);
		toolbar.add(dflipflop);
		
		JButton tflipflop = new JButton("T FLIP FLOP");
		tflipflop.addActionListener(actionListener);
		tflipflop.setBackground(Values.BgColor);
		tflipflop.setActionCommand("T-FLIPFLOP");
		tflipflop.setBounds(10, 385, 160, 23);
		toolbar.add(tflipflop);
		
		JLabel lblNewLabel_1 = new JLabel("FLIP FLOPS :");
		lblNewLabel_1.setBounds(10, 258, 130, 14);
		toolbar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SUBTRACTORS :");
		lblNewLabel_1_1.setBounds(10, 146, 130, 14);
		toolbar.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ADDERS :");
		lblNewLabel_1_1_1.setBounds(10, 38, 130, 14);
		toolbar.add(lblNewLabel_1_1_1);
		
	
//		Key Listener for Inputs to only accept 0's and 1's -------------------------
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
					calculate_btn.doClick();
			}
		});

		outputA = new JToggleButton();
		outputA.setIcon(bit0);
		outputA.setBounds(660, 144, 35, 35);
		add(outputA);
		
		outputB = new JToggleButton();
		outputB.setIcon(bit0);
		outputB.setBounds(660, 234, 35, 35);
		add(outputB);
		
		calculate_btn = new JButton("Perfrom Operation");
		calculate_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output[] = {"", ""};
				
				switch(heading.getText()) {
				case "HALF ADDER": output = LogicGates.halfAdder(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1");
							break;
				case "FULL ADDER": output = LogicGates.fullAdder(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1", inputC.getIcon() == bit0?"0":"1");
							break;
				case "HALF SUBTRACTOR": output = LogicGates.halfSubtractor(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1");
							break;
				case "FULL SUBTRACTOR": output = LogicGates.fullSubtractor(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1", inputC.getIcon() == bit0?"0":"1");
							break;
				case "SR FLIP FLOP": output = LogicGates.srFlipflop(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1", inputC.getIcon() == bit0?"0":"1");
							state_lbl.setText("State : " + Values.ffState);
							break;
				case "JK FLIP FLOP": output = LogicGates.jkFlipflop(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1", inputC.getIcon() == bit0?"0":"1");
							state_lbl.setText("State : " + Values.ffState);
							break;
				case "D FLIP FLOP": output = LogicGates.dFlipflop(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1");
							break;
				case "T FLIP FLOP": output = LogicGates.tFlipflop(inputA.getIcon() == bit0?"0":"1", inputB.getIcon() == bit0?"0":"1");
							break;
				}
				
				outputA.setIcon(output[0].equals("0")?bit0:bit1);
				outputB.setIcon(output[1].equals("0")?bit0:bit1);
			}
		});
		calculate_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		calculate_btn.setBackground(Color.WHITE);
		calculate_btn.setBounds(375, 419, 192, 38);
		add(calculate_btn);
		
		gate = new JLabel();
		gate.setIcon(haddIcon);
		gate.setBounds(322, 127, 274, 171);
		add(gate);
		
		heading = new JLabel("HALF ADDER");
		heading.setFont(new Font("Calibri Light", Font.BOLD, 20));
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(190, 26, 586, 21);
		add(heading);
		
		ItemListener itemListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(inputA.isSelected()) {
					inputA.setIcon(bit1);
				} else {
					inputA.setIcon(bit0);
				}
				
				if(inputB.isSelected()) {
					inputB.setIcon(bit1);
				} else {
					inputB.setIcon(bit0);
				}
				
				if(inputC.isSelected()) {
					inputC.setIcon(bit1);
				} else {
					inputC.setIcon(bit0);
				}
			}
			
		};
		
		inputA = new JToggleButton();
		inputA.setIcon(bit0);
		inputA.addItemListener(itemListener);
		inputA.setBounds(267, 183, 35, 35);
		add(inputA);
		
		inputB = new JToggleButton();
		inputB.setIcon(bit0);
		inputB.addItemListener(itemListener);
		inputB.setBounds(267, 234, 35, 35);
		add(inputB);
		
		inputC = new JToggleButton();
		inputC.setIcon(bit0);
		inputC.addItemListener(itemListener);
		inputC.setBounds(267, 280, 35, 35);
		add(inputC);
		
		state_lbl = new JLabel("State : ");
		state_lbl.setFont(new Font("Arial", Font.PLAIN, 14));
		state_lbl.setBackground(getBackground());
		state_lbl.setBounds(462, 370, 205, 38);
		add(state_lbl);
		
		
		
		
		updateUI("hadd");
	}
	
	void updateUI(String block) {
		inputA.setSelected(false);
		inputB.setSelected(false);
		inputC.setSelected(false);
		outputA.setIcon(bit0);
		outputB.setIcon(bit1);
		LogicGates.q = "0";
		LogicGates.qbar = "1";
		if(block == "hadd") {
			
			heading.setText("HALF ADDER");
			gate.setBounds(getWidth()/2 - 110, getHeight()/2 - 150, 351, 236);
			gate.setIcon(haddIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 15, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 55, 35, 35);
			inputB.setVisible(true);
			inputC.setVisible(false);
			state_lbl.setVisible(false);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 31, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 172, 35, 35);
			
		} else if(block == "fadd") {
			
			heading.setText("FULL ADDER");
			gate.setBounds(getWidth()/2 - 160, getHeight()/2 - 140, 487, 226);
			gate.setIcon(faddIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 6, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 60, 35, 35);
			inputB.setVisible(true);
			inputC.setBounds(gate.getX() - 35, gate.getY() + 112, 35, 35);
			inputC.setVisible(true);
			state_lbl.setVisible(false);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 32, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 136, 35, 35);
			
		} else if(block == "hsub") {
			
			heading.setText("HALF SUBTRACTOR");
			gate.setBounds(getWidth()/2 - 110, getHeight()/2 - 150, 351, 236);
			gate.setIcon(hsubIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 15, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 55, 35, 35);
			inputB.setVisible(true);
			inputC.setVisible(false);
			state_lbl.setVisible(false);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 31, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 172, 35, 35);
			
		} else if(block == "fsub") {
			
			heading.setText("FULL SUBTRACTOR");
			gate.setBounds(getWidth()/2 - 160, getHeight()/2 - 140, 487, 226);
			gate.setIcon(fsubIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 6, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 60, 35, 35);
			inputB.setVisible(true);
			inputC.setBounds(gate.getX() - 35, gate.getY() + 112, 35, 35);
			inputC.setVisible(true);
			state_lbl.setVisible(false);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 32, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 136, 35, 35);
			
		} else if(block == "srff") {
			
			heading.setText("SR FLIP FLOP");
			gate.setBounds(getWidth()/2 - 110, getHeight()/2 - 150, 358, 244);
			gate.setIcon(srffIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 5, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 106, 35, 35);
			inputB.setVisible(true);
			inputC.setBounds(gate.getX() - 35, gate.getY() + 207, 35, 35);
			inputC.setVisible(true);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 35, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 176, 35, 35);
			state_lbl.setBounds(gate.getX() + (gate.getWidth()/2) - 100, gate.getY() + gate.getHeight() + 10, 205, 38);
			state_lbl.setText("State : NO CHANGE");
			state_lbl.setVisible(true);
			
		} else if(block == "jkff") {
			
			heading.setText("JK FLIP FLOP");
			gate.setBounds(getWidth()/2 - 110, getHeight()/2 - 160, 358, 262);
			gate.setIcon(jkffIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 26, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 113, 35, 35);
			inputB.setVisible(true);
			inputC.setBounds(gate.getX() - 35, gate.getY() + 199, 35, 35);
			inputC.setVisible(true);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 43, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 184, 35, 35);
			state_lbl.setBounds(gate.getX() + (gate.getWidth()/2) - 100, gate.getY() + gate.getHeight() + 10, 205, 38);
			state_lbl.setText("State : NO CHANGE");
			state_lbl.setVisible(true);
			
		} else if(block == "dff") {
			
			heading.setText("D FLIP FLOP");
			gate.setBounds(getWidth()/2 - 130, getHeight()/2 - 140, 396, 250);
			gate.setIcon(dffIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 5, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 105, 35, 35);
			inputB.setVisible(true);
			inputC.setVisible(false);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 35, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 176, 35, 35);
			state_lbl.setVisible(false);
			
		} else if(block == "tff") {
			
			heading.setText("T FLIP FLOP");
			gate.setBounds(getWidth()/2 - 130, getHeight()/2 - 150, 396, 262);
			gate.setIcon(tffIcon);
			inputA.setBounds(gate.getX() - 35, gate.getY() + 27, 35, 35);
			inputA.setVisible(true);
			inputB.setBounds(gate.getX() - 35, gate.getY() + 114, 35, 35);
			inputB.setVisible(true);
			inputC.setVisible(false);
			outputA.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 43, 35, 35);
			outputB.setBounds(gate.getX() + gate.getWidth(), gate.getY() + 185, 35, 35);
			state_lbl.setVisible(false);
			
		} 
	}
}
