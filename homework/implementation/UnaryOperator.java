package homework.implementation;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operators.unaryOperators.IUnaryOperator;

public class UnaryOperator implements IUnaryOperator<Double> {

	public Operator operator;

	public UnaryOperator(String symbol) {
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
		operator.symbol = symbol;
	}

	@Override
	public IOperand<Double> calculate(Double operand) {
		Operand oper = new Operand(operand);
		if (this.operator.getSymbol().equals("sqrt")) {
			oper.arabValue = Math.sqrt(oper.arabValue);
		} else if (this.operator.getSymbol().equals("log")) {
			oper.arabValue = Math.log(oper.arabValue);
		}
		return oper;
	}

}
