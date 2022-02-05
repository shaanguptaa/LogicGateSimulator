package logicGateSimulator;

public class LogicGates {
	static String q = "0", qbar = "0";
	
//	NOT operation ---------------------------
	static String not(String inA) {
		
		String output = "";
		for(int i = 0; i < inA.length(); i++) {
			output += (inA.charAt(i) == '0') ? 1 : 0;
		}
		
		return output;
	}
	
//	AND operation ------------------------------
	static String and(String inA, String inB) {
		
		String output = "";
		
		int l = inA.length() - inB.length();
		
		for(int i = 0; i < Math.abs(l); i++) {
			if(l<0)
				inA = "0" + inA;
			else if(l>0)
				inB = "0" + inB;
		}
		
		for(int i = 0; i < inA.length(); i++) {
			output += (char) (inA.charAt(i) & inB.charAt(i));
		}
		
		return output;
	}
	
//	OR operation ------------------------------
	static String or(String inA, String inB) {
		
		String output = "";
		int l = inA.length() - inB.length();
		
		for(int i = 0; i < Math.abs(l); i++) {
			if(l<0)
				inA = "0" + inA;
			else if(l>0)
				inB = "0" + inB;
		}
		
		for(int i = 0; i < inA.length(); i++) {
			output += (char) (inA.charAt(i) | inB.charAt(i));
		}
		
		return output;
	}
	
//	NAND operation ----------------------------
	static String nand(String inA, String inB) {
		
//		NAND = ~ (A & B)
		return not(and(inA, inB));
		
//		for(int i = 0; i < inA.length(); i++) {
//
//			output += not(and("" + inA.charAt(i), "" + inB.charAt(i)));
//		}
//		
//		return output;
	}
	
//	NOR operation -----------------------------
	static String nor(String inA, String inB) {	
		
//		NOR = ~ (A | B)
		return not(or(inA, inB));
		
//		String output = "";
//		for(int i = 0; i < inA.length(); i++) {
//
//			output += not(or("" + inA.charAt(i), "" + inB.charAt(i)));
//		}
//		
//		return output;
	}
	
//	EX-OR operation ----------------------------
	static String xor(String inA, String inB) {
		
		int l = inA.length() - inB.length();
				
		for(int i = 0; i < Math.abs(l); i++) {
			if(l<0)
				inA = "0" + inA;
			else if(l>0)
				inB = "0" + inB;
		}
		
//		XOR = (A | B) & (~A | ~B)		OR		(A & ~B) | (~A & B)
		return and(or(inA, inB), or(not(inA), not(inB)));
//		return or(and(inA, not(inB)), and(not(inA), inB));
		
//		String output = "";
//		for(int i = 0; i < inA.length(); i++) {
//
//			output += or("" + and("" + inA.charAt(i), "" + not("" + inB.charAt(i))), "" + and("" + not("" + inA.charAt(i)), "" + inB.charAt(i)));
//		}
//		
//		return output;
	}
	
//	EX-NOR operation -----------------------------
	static String xnor(String inA, String inB) {
		
//		XOR = ~ ( (A | B) & (~A | ~B) )
		return not(xor(inA, inB));
		
//		String output = "";
//		for(int i = 0; i < inA.length(); i++) {
//
//			output += not("" + xor("" + inA.charAt(i), "" + inB.charAt(i)));
//		}
//		
//		return output;
	}
	
	
//	HALF ADDER operation
	static String[] halfAdder(String inA, String inB) {
		String output[] = {"", ""}; //sum = output[0], carry = output[1]
		
//		sum = A XOR B
//		carry = A AND B
		
		output[0] = xor(inA, inB);
		output[1] = and(inA, inB);
		
		return output;
		
	}
	
//	FULL ADDER operation
	static String[] fullAdder(String inA, String inB, String inC) {
		String output[] = {"", ""}; //sum = output[0], carry = output[1]
		
//		sum = (A XOR B) XOR C
//		carry = ((A XOR B) AND C) OR (A AND B)
		
		output[0] = xor(xor(inA, inB), inC);
		output[1] = or(and(xor(inA, inB), inC), and(inA, inB));
		
		return output;
	}
	
//	HALF SUBTRACTOR operation
	static String[] halfSubtractor(String inA, String inB) {
		String output[] = {"", ""}; //diff = output[0], borrow = output[1]
		
//		diff = A XOR B
//		borrow = (NOT A) AND B
		
		output[0] = xor(inA, inB);
		output[1] = and(not(inA), inB);
		
		return output;
	}
	
//	FULL SUBTRACTOR operation
	static String[] fullSubtractor(String inA, String inB, String inC) {
		String output[] = {"", ""}; //diff = output[0], borrow = output[1]
		
//		diff = (A XOR B) XOR C
//		borrow = ((A XOR B) AND C) OR (A AND B)
		
		output[0] = xor(xor(inA, inB), inC);
		output[1] = or(and(not(xor(inA, inB)), inC), and(not(inA), inB));
		
		return output;
	}
	
//	S-R FLIPFLOP operation
	static String[] srFlipflop(String inA, String clk, String inB) {
		String output[] = {"0", "0"};

		
		if(clk.equals("1")) {
			if(inA.equals("0") && inB.equals("0")) {
				Values.ffState = "PREVIOUS";
			} else if(inA.equals("0") && inB.equals("1")) {
				q = "0";
				qbar = "1";
				Values.ffState = "RESET";
			} else if(inA.equals("1") && inB.equals("0")) {
				q = "1";
				qbar = "0";
				Values.ffState = "SET";
			} else if(inA.equals("1") && inB.equals("1")) {
				q = "0";
				qbar = "0";
				Values.ffState = "FORBIDDEN";
				
			}
		} else {
			q = "0";
			qbar = "0";
			Values.ffState = "NO CLOCK PLUSE";
		}
		
		output[0] = q;
		output[1] = qbar;
		return output;
		
	}
	
	
//	J-K FLIPFLOP operation
	static String[] jkFlipflop(String inA, String clk, String inB) {
		String output[] = {"0", "0"};

		
		if(clk.equals("1")) {
			if(inA.equals("0") && inB.equals("0")) {
				Values.ffState = "NO CHANGE";
			} else if(inA.equals("0") && inB.equals("1")) {
				q = "0";
				qbar = "1";
				Values.ffState = "RESET";
			} else if(inA.equals("1") && inB.equals("0")) {
				q = "1";
				qbar = "0";
				Values.ffState = "SET";
			} else if(inA.equals("1") && inB.equals("1")) {
				q = not(q);
				qbar = not(qbar);
				Values.ffState = "TOGGLE";
				
			}
		} else {
			q = "0";
			qbar = "0";
			Values.ffState = "NO CLOCK PLUSE";
		}
		
		output[0] = q;
		output[1] = qbar;
		return output;
		
	}
	
//	D FLIPFLOP operation
	static String[] dFlipflop(String inA, String clk) {
		String output[] = {"0", "0"};

		
		if(clk.equals("1")) {
			if(inA.equals("0")) {
				q = "0";
				qbar = "1";
			} else if(inA.equals("1")) {
				q = "1";
				qbar = "0";
			}
		} else {
			q = "0";
			qbar = "1" ;
		}
		
		output[0] = q;
		output[1] = qbar;
		return output;
		
	}
	
//	T FLIPFLOP operation
	static String[] tFlipflop(String inA, String clk) {
		String output[] = {"0", "0"};

		
		if(clk.equals("1") && inA.equals("1")) {
			q = not(q);
			qbar = not(qbar);
		}
		
		output[0] = q;
		output[1] = qbar;
		return output;
	}

}
