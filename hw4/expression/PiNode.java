package nvacheishvili.expression;

public class PiNode extends NoParameterOperatorNode{
	
			
				public PiNode(String op) {
					super(op);
				}
				
				/** Operator subclasses determine how to process given value. */
				public double value() {
					return Math.PI;
				}

			}


