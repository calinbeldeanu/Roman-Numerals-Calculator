package homework.implementation;

import homework.interfaces.operands.IOperand;
import homework.interfaces.operands.IOperandsFactory;

public class OperandsFactory implements IOperandsFactory<Double> {

	private static OperandsFactory operandsFactory = null;

	private OperandsFactory() {
	}

	public static OperandsFactory getInstance() {
		if (operandsFactory == null)
			operandsFactory = new OperandsFactory();
		return operandsFactory;
	}

	@Override
	public IOperand<Double> createOperand(String token) {
		Token tok = new Token(token);
		Operand operand = new Operand(tok);
		String simb = tok.getSymbol();
		operand.setSymbol(simb);
		return operand;
	}

	@Override
	public IOperand<Double> convertToRomanNumber(Double arabNumber) {
		Operand oper = new Operand();
		oper.arabValue = arabNumber;
		if (arabNumber > 0) {
			while (oper.arabValue != 0) {
				// System.out.println(arabNumber);
				if ((oper.arabValue - (double) 1000) >= 0) {
					oper.arabValue = oper.arabValue - (double) 1000;
					oper.setSymbolValue((double) 1000);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 900) >= 0) {
					oper.arabValue = oper.arabValue - (double) 900;
					oper.setSymbolValue((double) 900);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 500) >= 0) {
					oper.arabValue = oper.arabValue - (double) 500;
					oper.setSymbolValue((double) 500);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 400) >= 0) {
					oper.arabValue = oper.arabValue - (double) 400;
					oper.setSymbolValue((double) 400);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 100) >= 0) {
					oper.arabValue = oper.arabValue - (double) 100;
					oper.setSymbolValue((double) 100);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 90) >= 0) {
					oper.arabValue = oper.arabValue - (double) 90;
					oper.setSymbolValue((double) 90);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 50) >= 0) {
					oper.arabValue = oper.arabValue - (double) 50;
					oper.setSymbolValue((double) 50);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 40) >= 0) {
					oper.arabValue = oper.arabValue - (double) 40;
					oper.setSymbolValue((double) 40);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 10) >= 0) {
					oper.arabValue = oper.arabValue - (double) 10;
					oper.setSymbolValue((double) 10);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 9) >= 0) {
					oper.arabValue = oper.arabValue - (double) 9;
					oper.setSymbolValue((double) 9);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 5) >= 0) {
					oper.arabValue = oper.arabValue - (double) 5;
					oper.setSymbolValue((double) 5);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 4) >= 0) {
					oper.arabValue = oper.arabValue - (double) 4;
					oper.setSymbolValue((double) 4);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue - (double) 1) >= 0) {
					oper.arabValue = oper.arabValue - (double) 1;
					oper.setSymbolValue((double) 1);
					if (oper.symbol == null) {
						oper.symbol = oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				}

			}

		} else {
			while (oper.arabValue != 0) {
				// System.out.println(arabNumber);
				if ((oper.arabValue + (double) 1000) <= 0) {
					oper.arabValue = oper.arabValue + (double) 1000;
					oper.setSymbolValue((double) 1000);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 900) <= 0) {
					oper.arabValue = oper.arabValue + (double) 900;
					oper.setSymbolValue((double) 900);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 500) <= 0) {
					oper.arabValue = oper.arabValue + (double) 500;
					oper.setSymbolValue((double) 500);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 400) <= 0) {
					oper.arabValue = oper.arabValue + (double) 400;
					oper.setSymbolValue((double) 400);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 100) <= 0) {
					oper.arabValue = oper.arabValue + (double) 100;
					oper.setSymbolValue((double) 100);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 90) <= 0) {
					oper.arabValue = oper.arabValue + (double) 90;
					oper.setSymbolValue((double) 90);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 50) <= 0) {
					oper.arabValue = oper.arabValue + (double) 50;
					oper.setSymbolValue((double) 50);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 40) <= 0) {
					oper.arabValue = oper.arabValue + (double) 40;
					oper.setSymbolValue((double) 40);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 10) <= 0) {
					oper.arabValue = oper.arabValue + (double) 10;
					oper.setSymbolValue((double) 10);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 9) <= 0) {
					oper.arabValue = oper.arabValue + (double) 9;
					oper.setSymbolValue((double) 9);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 5) <= 0) {
					oper.arabValue = oper.arabValue + (double) 5;
					oper.setSymbolValue((double) 5);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 4) <= 0) {
					oper.arabValue = oper.arabValue + (double) 4;
					oper.setSymbolValue((double) 4);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				} else if ((oper.arabValue + (double) 1) <= 0) {
					oper.arabValue = oper.arabValue + (double) 1;
					oper.setSymbolValue((double) 1);
					if (oper.symbol == null) {
						oper.symbol = "- " + oper.resymbol;
					} else {
						oper.symbol = oper.symbol + oper.resymbol;
					}
				}

			}
		}
		return oper;
	}

	@Override
	public IOperand<Double> convertToArabNumber(String romanNumber) {
		Operand oper = new Operand();
		Double zero = (double) 0;
		Operand decimal = new Operand(zero);
		Double lastNum = (double) 0;
		for (int i = romanNumber.length() - 1; i >= 0; i--) {
			oper.chSymbol = romanNumber.charAt(i);
			oper.getSymbolValue();
			decimal.arabValue = decimalProc(oper.arabValue, lastNum,
					decimal.arabValue);
			lastNum = oper.arabValue;
		}
		return decimal;
	}

	public static Double decimalProc(double decimal, double lastNum,
			double lastDec) {
		if (lastNum > decimal) {
			return lastDec - decimal;
		} else {
			return lastDec + decimal;
		}
	}
}
