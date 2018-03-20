package homework.implementation;

import homework.interfaces.IToken;

public class Token implements IToken {

	public String symbol;

	public Token(String symbol) {
		this.symbol = symbol;
	}

	public Token() {
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

	@Override
	public void setSymbol(String symbol) {
		this.symbol = symbol;

	}

}
