package homework.implementation;

import homework.interfaces.operators.IOperator;

public class Operator implements IOperator {

	public String symbol;

	public Operator() {
	}

	public Operator(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public void setSymbol(String symbol) {
		this.symbol = symbol;

	}

	@Override
	public int getPriority() {
		if (this.symbol.equals("+") || this.symbol.equals("-")) {
			return 0;
		} else if (this.symbol.equals("*") || this.symbol.equals("/")) {
			return 1;
		} else if (this.symbol.equals("^")) {
			return 2;
		} else if (this.symbol.equals("sqrt") || this.symbol.equals("log")) {
			return 3;
		}
		return -1;
	}

}
