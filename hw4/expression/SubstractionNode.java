package nvacheishvili.expression;

public class SubstractionNode extends BinaryOperatorNode{
	
		public SubstractionNode(String op) {
			super(op);
		}
		
		/** Operator subclasses determine how to process given value. */
		public double value() {
			return left.value() - right.value();
		}

	}

