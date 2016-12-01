package nvacheishvili.expression;

public class DivisionNode extends BinaryOperatorNode{
	
			
				public DivisionNode(String op) {
					super(op);
				}
				
				/** Operator subclasses determine how to process given value. */
				public double value() {
					if(right.value()!=0){
					return left.value() / right.value();
					}
					else{
						throw new IllegalArgumentException("Argument 'divisor' is 0");
					}
				}

			}


