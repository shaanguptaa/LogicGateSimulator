package logicGateSimulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BasicPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField inputA;
	private JTextField inputC;
	private JTextField inputB;
	private JTextField output;
	private JSeparator sep_inB_gt;
	private JSeparator sep_inC_gt;
	private JSeparator sep_inA_gt;
	private JButton calculate_btn;
	private JLabel gate;
	private JRadioButton rdbtnBinary;
	private JRadioButton rdbtnDecimal;
	private JButton switchMode;

	/**
	 * Create the panel.
	 */
	public BasicPanel() {
		setName("Basic");
		setSize(Values.Width, Values.Height);
		setBorder(null);
		setBackground(Values.BgColor);
		setLayout(null);
		
		int x, y, w;
		
//		Icons for Gates -----------------
		ImageIcon notIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/NOT Gate.png"));
		ImageIcon andIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/AND Gate.png"));
		ImageIcon nandIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/NAND Gate.png"));
		ImageIcon orIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/OR Gate.png"));
		ImageIcon norIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/NOR Gate.png"));
		ImageIcon xorIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/EX-OR Gate.png"));
		ImageIcon xnorIcon = new ImageIcon(LogicGateSimulator.class.getResource("/assets/EX-NOR Gate.png"));
		
		
//		Gate Diagram -------------------------------------------
		gate = new JLabel();
		gate.setToolTipText("Gate");
		gate.setBounds(getWidth() / 2 - 70, getHeight() / 2 - 120, 114, 97);
		add(gate);
		
		
//		Key Adapter for Inputs to only accept Decimal Numbers -------------------------
		KeyAdapter keyAdapterDecimal = new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if(!Character.isDigit(key))
					e.setKeyChar('\0');
				if(key == KeyEvent.VK_ENTER)
					calculate_btn.doClick();
				if(key == KeyEvent.VK_TAB)
					inputC.grabFocus();
			}
		};
		
//		Key Adapter for Inputs to only accept 0's and 1's -------------------------
		KeyAdapter keyAdapterBinary = new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if(!(key == '0' || key == '1'))
					e.setKeyChar('\0');
			}
		};
		 
//		Input A -----------------------------------
		inputA = new JTextField();
		inputA.setToolTipText("Input");
		inputA.setBounds(gate.getX() - 136, gate.getY() + 15, 86, 21);
		inputA.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
		inputA.addKeyListener(keyAdapterDecimal);
		add(inputA);
		inputA.setColumns(1);
		
		
//		Input B ----------------------------------
		inputB = new JTextField();
		inputB.setToolTipText("Input");
		inputB.setBounds(gate.getX() - 136, gate.getY() + gate.getHeight() / 2 - 10, 86, 21);
		inputB.addKeyListener(keyAdapterDecimal);
		add(inputB);
		inputB.setColumns(1);
		
		
//		Input C ----------------------------------
		inputC = new JTextField();
		inputC.setToolTipText("Input");
		inputC.setBounds(gate.getX() - 136, gate.getY() + gate.getHeight() - 39, 86, 21);
		inputC.addKeyListener(keyAdapterDecimal);
		add(inputC);
		inputC.setColumns(1);

		
//		Output TF ---------------------------------
		output = new JTextField();
		output.setBackground(Color.WHITE);
		output.setEditable(false);
		output.setToolTipText("Output");
		output.setBounds(gate.getX() + gate.getWidth() + 50, gate.getY() + gate.getHeight() / 2 - 10, 86, 21);
		add(output);
		output.setColumns(5);
		
		
//		Line From Gate To Output --------------------
		JSeparator sep_gt_op = new JSeparator();
		sep_gt_op.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
		sep_gt_op.setBackground(Color.BLACK);
		sep_gt_op.setForeground(Color.BLACK);
		x = gate.getX() + gate.getWidth();
		y = gate.getY() + (gate.getHeight() / 2);
		w = output.getX() - x;
		sep_gt_op.setBounds(x, y, w, 3);
		add(sep_gt_op);
		
//		Line From Input A TO Gate ---------------------
		sep_inA_gt = new JSeparator();
		sep_inA_gt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
		sep_inA_gt.setForeground(Color.BLACK);
		sep_inA_gt.setBackground(Color.BLACK);
		x = inputA.getX() + inputA.getWidth();
		y = inputA.getY() + (inputA.getHeight() / 2);
		w = gate.getX() - x;
		sep_inA_gt.setBounds(x, y, w, 3);
		add(sep_inA_gt);
		
		
//		Line From Input B TO Gate -------------------
		sep_inB_gt = new JSeparator();
		sep_inB_gt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
		sep_inB_gt.setForeground(Color.BLACK);
		sep_inB_gt.setBackground(Color.BLACK);
		x = inputB.getX() + inputB.getWidth();
		y = inputB.getY() + (inputB.getHeight() / 2);
		w = gate.getX() - x;
		sep_inB_gt.setBounds(x, y, w, 3);
		add(sep_inB_gt);
		
//		Line From Input C To Gate-----------------------
		sep_inC_gt = new JSeparator();
		sep_inC_gt.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
		sep_inC_gt.setForeground(Color.BLACK);
		sep_inC_gt.setBackground(Color.BLACK);
		x = inputC.getX() + inputC.getWidth();
		y = inputC.getY() + (inputC.getHeight() / 2);
		w = gate.getX() - x;
		sep_inC_gt.setBounds(x, y, w, 3);
		add(sep_inC_gt);
		
//		Calculate Button ------------------------------------------
		calculate_btn = new JButton("Perform Operation");
		calculate_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		calculate_btn.setBackground(Color.WHITE);
		calculate_btn.setBounds(getWidth() - 350, getHeight() - 200, 164, 38);
		add(calculate_btn);
		calculate_btn.setActionCommand("NOT");
		calculate_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				output.setText(" ");
				String op = "";
				
				if(e.getActionCommand() == "NOT") {
					String inp = rdbtnDecimal.isSelected()?Integer.toBinaryString(Integer.parseInt(inputB.getText())):inputB.getText();
					if(inp.length() % 2 != 0 && rdbtnDecimal.isSelected())
						inp = "0" + inp;
					op = LogicGates.not(inp);
					
				} else {
					String inpA = rdbtnDecimal.isSelected()?Integer.toBinaryString(Integer.parseInt(inputA.getText())):inputA.getText();
					String inpB = rdbtnDecimal.isSelected()?Integer.toBinaryString(Integer.parseInt(inputC.getText())):inputC.getText();
					
					if(inpA.length() % 2 != 0 && rdbtnDecimal.isSelected())
						inpA = "0" + inpA;
					if(inpB.length() % 2 != 0 && rdbtnDecimal.isSelected())
						inpB = "0" + inpB;
					
					if(e.getActionCommand() == "AND")
						op = LogicGates.and(inpA, inpB);
					else if(e.getActionCommand() == "OR")
						op = LogicGates.or(inpA, inpB);
					else if(e.getActionCommand() == "NAND")
						op = LogicGates.nand(inpA, inpB);
					else if(e.getActionCommand() == "NOR")
						op = LogicGates.nor(inpA, inpB);
					else if(e.getActionCommand() == "EX-OR")
						op = LogicGates.xor(inpA, inpB);
					else if(e.getActionCommand() == "EX-NOR")
						op = LogicGates.xnor(inpA, inpB);
					
				}
				
				op = rdbtnDecimal.isSelected()?"" + Integer.parseInt(op, 2):op;
				output.setText(op);

			}
		});
		
		
//		Gate Choice ------------------------------------------
		JComboBox<String> cb_gate = new JComboBox<String>();
		cb_gate.setFont(new Font("Dialog", Font.BOLD, 14));
		cb_gate.setBackground(Color.WHITE);
		cb_gate.setToolTipText("Select Gate");
		cb_gate.setModel(new DefaultComboBoxModel<String>(new String[] {"  NOT", "  AND", "  OR", "  NAND", "  NOR", "  EX-OR", "  EX-NOR"}));
		cb_gate.setSelectedIndex(0);
		cb_gate.setBounds(calculate_btn.getX() - 200, calculate_btn.getY(), 104, 38);
		add(cb_gate);
		cb_gate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				output.setText("");
				switch(e.getItem().toString()) {
				case "  AND": calculate_btn.setActionCommand("AND");
						inputA.setVisible(true);
						inputC.setVisible(true);
						sep_inA_gt.setVisible(true);
						sep_inC_gt.setVisible(true);
						inputB.setVisible(false);
						sep_inB_gt.setVisible(false);
						gate.setIcon(andIcon);
						break;
				case "  OR": calculate_btn.setActionCommand("OR");
						inputA.setVisible(true);
						inputC.setVisible(true);
						sep_inA_gt.setVisible(true);
						sep_inC_gt.setVisible(true);
						inputB.setVisible(false);
						sep_inB_gt.setVisible(false);
						gate.setIcon(orIcon);
						break;
				case "  NOT": calculate_btn.setActionCommand("NOT");
						inputA.setVisible(false);
						inputC.setVisible(false);
						sep_inA_gt.setVisible(false);
						sep_inC_gt.setVisible(false);
						inputB.setVisible(true);
						sep_inB_gt.setVisible(true);
						gate.setIcon(notIcon);
						break;
				case "  NAND": calculate_btn.setActionCommand("NAND");
						inputA.setVisible(true);
						inputC.setVisible(true);
						sep_inA_gt.setVisible(true);
						sep_inC_gt.setVisible(true);
						inputB.setVisible(false);
						sep_inB_gt.setVisible(false);
						gate.setIcon(nandIcon);
						break;
				case "  NOR": calculate_btn.setActionCommand("NOR");
						inputA.setVisible(true);
						inputC.setVisible(true);
						sep_inA_gt.setVisible(true);
						sep_inC_gt.setVisible(true);
						inputB.setVisible(false);
						sep_inB_gt.setVisible(false);
						gate.setIcon(norIcon);
						break;
				case "  EX-OR": calculate_btn.setActionCommand("EX-OR");
						inputA.setVisible(true);
						inputC.setVisible(true);
						sep_inA_gt.setVisible(true);
						sep_inC_gt.setVisible(true);
						inputB.setVisible(false);
						sep_inB_gt.setVisible(false);
						gate.setIcon(xorIcon);
						break;
				case "  EX-NOR": calculate_btn.setActionCommand("EX-NOR");
						inputA.setVisible(true);
						inputC.setVisible(true);
						sep_inA_gt.setVisible(true);
						sep_inC_gt.setVisible(true);
						inputB.setVisible(false);
						sep_inB_gt.setVisible(false);
						gate.setIcon(xnorIcon);
						break;
				}
			}
		});
		
//		Label For Gate Choice ---------------------------------
		JLabel lbl_gt = new JLabel("Select Gate:");
		lbl_gt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_gt.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_gt.setLabelFor(cb_gate);
		lbl_gt.setBounds(cb_gate.getX() - 100, cb_gate.getY() + 9, 89, 18);
		add(lbl_gt);
		
//		TITLE -----------------------------
		JLabel lblNewLabel = new JLabel("LOGIC Gates Simulator".toUpperCase());
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 50, getWidth(), 25);
		add(lblNewLabel);
		

		
		
		rdbtnBinary = new JRadioButton("Binary");
		rdbtnBinary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		rdbtnBinary.setBounds(295, 381, 79, 25);
		rdbtnBinary.setBackground(new Color(247, 247, 247));
		rdbtnBinary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputA.setText("");
				inputB.setText("");
				inputC.setText("");
				inputA.addKeyListener(keyAdapterBinary);
				inputB.addKeyListener(keyAdapterBinary);
				inputC.addKeyListener(keyAdapterBinary);
			}
			
		});
		add(rdbtnBinary);
		
		rdbtnDecimal = new JRadioButton("Decimal");
		rdbtnDecimal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnDecimal.setBounds(383, 381, 86, 25);
		rdbtnDecimal.setBackground(new Color(247, 247, 247));
		rdbtnDecimal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputA.setText("");
				inputB.setText("");
				inputC.setText("");
				inputA.removeKeyListener(keyAdapterBinary);
				inputB.removeKeyListener(keyAdapterBinary);
				inputC.removeKeyListener(keyAdapterBinary);
			}
			
		});
		add(rdbtnDecimal);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnBinary);
		bg.add(rdbtnDecimal);
		
		JLabel lbl_in_method = new JLabel("Select Input Type:");
		lbl_in_method.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_in_method.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_in_method.setBounds(150, 382, 130, 18);
		add(lbl_in_method);
		
//		START / INITIALIZE THE START OF THE APPLICATION:
		gate.setIcon(notIcon);
		inputA.setVisible(false);
		inputC.setVisible(false);
		sep_inA_gt.setVisible(false);
		sep_inC_gt.setVisible(false);
		rdbtnBinary.setSelected(true);
		
		switchMode = new JButton("Advanced Mode");
		switchMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getRoot(Values.basicPanel);
				f.setContentPane(Values.advancedPanel);
				f.setTitle("Advanced - " + Values.Title);
			}
		});
		switchMode.setFont(new Font("Dialog", Font.BOLD, 14));
		switchMode.setBackground(Color.WHITE);
		switchMode.setBounds(591, 419, 164, 38);
		add(switchMode);
		
		
		inputA.addKeyListener(keyAdapterBinary);
		inputB.addKeyListener(keyAdapterBinary);
		inputC.addKeyListener(keyAdapterBinary);

	}

}
