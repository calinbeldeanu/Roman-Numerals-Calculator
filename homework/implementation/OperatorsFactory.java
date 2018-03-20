package homework.implementation;

import homework.interfaces.IToken;
import homework.interfaces.operators.IOperator;
import homework.interfaces.operators.IOperatorsFactory;

public class OperatorsFactory implements IOperatorsFactory {

	private static OperatorsFactory operatorsFactory = null;

	private OperatorsFactory() {
	}

	public static OperatorsFactory getInstance() {
		if (operatorsFactory == null)
			operatorsFactory = new OperatorsFactory();
		return operatorsFactory;
	}

	@Override
	public IOperator createOperator(String token) {
		if (token.equals("sqrt") || token.equals("log")) {
			return new UnaryOperator(token);
		} else {
			return new BinaryOperator(token);
		}
	}

	@Override
	public boolean isOperator(IToken token) {
		if (token.getSymbol().equals("+") || token.getSymbol().equals("-")
				|| token.getSymbol().equals("*")
				|| token.getSymbol().equals("/")
				|| token.getSymbol().equals("^")
				|| token.getSymbol().equals("sqrt")
				|| token.getSymbol().equals("log")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isUnaryOperator(IOperator operator) {
		if (operator.getSymbol().equals("sqrt")
				|| operator.getSymbol().equals("log")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isBinaryOperator(IOperator operator) {
		if (operator.getSymbol().equals("+") || operator.getSymbol().equals("-")
				|| operator.getSymbol().equals("*")
				|| operator.getSymbol().equals("/")
				|| operator.getSymbol().equals("^")) {
			return true;
		}
		return false;
	}
}
