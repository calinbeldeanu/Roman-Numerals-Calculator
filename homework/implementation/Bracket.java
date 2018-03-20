package homework.implementation;

import homework.interfaces.brackets.IBracket;

public class Bracket implements IBracket {

	public String symbol;

	public Bracket(String symbol) {
		this.symbol = symbol;
	}

	public Bracket() {
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
