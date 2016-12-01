package nvacheishvili.expression;

public class ExponentNode extends BinaryOperatorNode{
			
				public ExponentNode(String op) {
					super(op);
				}
				
				/** Operator subclasses determine how to process given value. */
				public double value() {
					return Math.pow(left.value(), right.value());
				}

			}
