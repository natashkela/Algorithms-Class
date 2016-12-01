package nvacheishvili.expression;

public class SqrtNode extends UnaryOperatorNode{
			
				public SqrtNode(String op) {
					super(op);
				}
				
				/** Operator subclasses determine how to process given value. */
				public double value() {
					Double leftNode = left.value();
					if(leftNode!=null){
					return Math.sqrt(left.value());
					}
					else {
						return Math.sqrt(right.value());
					}
				}

			}