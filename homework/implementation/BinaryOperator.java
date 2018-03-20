package homework.implementation;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.binaryOperators.IBinaryOperator;

public class BinaryOperator implements IBinaryOperator<Double> {

	public Operator operator;

	public BinaryOperator(String symbol) {
		this.operator = new Operator(symbol);
	}

	@Override
	public int getPriority() {
		return operator.getPriority();
	}

	@Override
	public String getSymbol() {
		return operator.getSymbol();
	}

	@Override
	public void setSymbol(String symbol) {
		this.operator.setSymbol(symbol);

	}

	@Override

	public IOperand<Double> calculate(Double leftOperand, Double rightOperand) {
		Operand left = new Operand(leftOperand);
		Operand right = new Operand(rightOperand);
		// System.out.println(leftOperand);
		// System.out.println(rightOperand);
		Operand rezult = new Operand((double) 0);
		if (this.operator.getSymbol().equals("+")) {
			rezult.arabValue = left.arabValue + right.arabValue;
			return rezult;
		} else if (this.operator.getSymbol().equals("-")) {
			rezult.arabValue = left.arabValue - right.arabValue;
			return rezult;
		} else if (this.operator.getSymbol().equals("*")) {
			rezult.arabValue = left.arabValue * right.arabValue;
			return rezult;
		} else if (this.operator.getSymbol().equals("/")) {
			rezult.arabValue = left.arabValue / right.arabValue;
			return rezult;
		} else if (this.operator.getSymbol().equals("^")) {
			rezult.arabValue = Math.pow(left.arabValue, right.arabValue);
			return rezult;
		}
		return rezult;
	}

}
