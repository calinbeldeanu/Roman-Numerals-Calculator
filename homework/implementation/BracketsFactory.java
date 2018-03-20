package homework.implementation;

import homework.interfaces.IToken;
import homework.interfaces.brackets.IBracket;
import homework.interfaces.brackets.IBracketsFactory;

public class BracketsFactory implements IBracketsFactory {

	private static BracketsFactory bracketsFactory = null;

	private BracketsFactory() {
	}

	public static BracketsFactory getInstance() {
		if (bracketsFactory == null)
			bracketsFactory = new BracketsFactory();
		return bracketsFactory;
	}

	@Override
	public IBracket createBracket(String token) {
		Bracket brack = new Bracket(token);
		return brack;
	}

	@Override
	public boolean isBracket(IToken token) {
		if (token.getSymbol().equals("(") || token.getSymbol().equals(")")
				|| token.getSymbol().equals("[")
				|| token.getSymbol().equals("]")
				|| token.getSymbol().equals("{")
				|| token.getSymbol().equals("}")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isOpenedBracket(IBracket bracket) {
		if (bracket.getSymbol().equals("(") || bracket.getSymbol().equals("[")
				|| bracket.getSymbol().equals("{")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isClosedBracket(IBracket bracket) {
		if (bracket.getSymbol().equals(")") || bracket.getSymbol().equals("]")
				|| bracket.getSymbol().equals("}")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isBracketPair(IBracket openBracket, IBracket closeBracket) {
		if (openBracket.getSymbol().equals("(")
				&& closeBracket.getSymbol().equals(")")) {
			return true;
		} else if (openBracket.getSymbol().equals("[")
				&& closeBracket.getSymbol().equals("]")) {
			return true;
		} else if (openBracket.getSymbol().equals("{")
				&& closeBracket.getSymbol().equals("}")) {
			return true;
		}
		return false;
	}
}
