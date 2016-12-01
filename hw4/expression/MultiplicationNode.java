package nvacheishvili.expression;

public class MultiplicationNode extends BinaryOperatorNode{
		
			public MultiplicationNode(String op) {
				super(op);
			}
			
			/** Operator subclasses determine how to process given value. */
			public double value() {
				return left.value() * right.value();
			}

		}


