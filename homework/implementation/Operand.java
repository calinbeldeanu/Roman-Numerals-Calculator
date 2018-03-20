package homework.implementation;

import homework.interfaces.operands.IOperand;

public class Operand implements IOperand<Double> {

	public String symbol;
	public char chSymbol;
	public String resymbol;
	public Token tok;
	public Double arabValue;

	public Operand(Double number) {
		this.arabValue = number;
	}

	public Operand(Token tok) {
		this.symbol = tok.symbol;
		this.tok = tok;
		this.resymbol = null;
	}

	public Operand() {
	}

	@Override
	public String getSymbol() {
		return this.symbol;
	}

	public Double getArabValue() {
		return arabValue;
	}

	public void setArabValue(Double arabValue) {
		this.arabValue = arabValue;
	}

	@Override
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public Double getSymbolValue() {
		switch (this.chSymbol) {
		case 'I':
			this.arabValue = (double) 1;
			return arabValue;
		case 'V':
			this.arabValue = (double) 5;
			return arabValue;
		case 'X':
			this.arabValue = (double) 10;
			return arabValue;
		case 'L':
			this.arabValue = (double) 50;
			return arabValue;
		case 'C':
			this.arabValue = (double) 100;
			return arabValue;
		case 'D':
			this.arabValue = (double) 500;
			return arabValue;
		case 'M':
			this.arabValue = (double) 1000;
			return arabValue;
		default:
			break;

		}
		return null;
	}

	@Override
	public void setSymbolValue(Double value) {
		if (value == (double) 1) {
			this.resymbol = "I";
		} else if (value == (double) 4) {
			this.resymbol = "IV";
		} else if (value == (double) 5) {
			this.resymbol = "V";
		} else if (value == (double) 9) {
			this.resymbol = "IX";
		} else if (value == (double) 10) {
			this.resymbol = "X";
		} else if (value == (double) 40) {
			this.resymbol = "XL";
		} else if (value == (double) 50) {
			this.resymbol = "L";
		} else if (value == (double) 90) {
			this.resymbol = "XC";
		} else if (value == (double) 100) {
			this.resymbol = "C";
		} else if (value == (double) 400) {
			this.resymbol = "CD";
		} else if (value == (double) 500) {
			this.resymbol = "D";
		} else if (value == (double) 900) {
			this.resymbol = "CM";
		} else if (value == (double) 1000) {
			this.resymbol = "M";
		}

	}

}
