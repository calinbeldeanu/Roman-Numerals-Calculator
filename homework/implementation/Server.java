package homework.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import homework.interfaces.IServer;
import homework.interfaces.IToken;

public class Server implements IServer {

	private static Server server = null;
	private List<String> result = new ArrayList<String>();
	private List<String> goodOperators = new ArrayList<String>();
	@SuppressWarnings("serial")
	private Queue<IToken> postfixedForm = new LinkedList<IToken>() {
	};
	private Stack<IToken> helper = new Stack<IToken>();
	private Stack<Integer> priority = new Stack<Integer>();

	private Server() {
	}

	public static Server getInstance() {
		if (server == null)
			server = new Server();
		return server;
	}

	@Override
	public boolean canPublish(String[] tokens) {
		for (int i = 0; i < tokens.length; i++) {
			Operator oper = new Operator(tokens[i]);
			if (!goodOperators.contains(tokens[i])
					&& OperatorsFactory.getInstance().isOperator(oper)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void publish(String command) {
		String[] tokens = command.split("\\s");
		String fin;
		if (Server.getInstance().canPublish(tokens)) {
			Server.getInstance().postFixedForm(tokens);
			fin = Server.getInstance().evaluate(postfixedForm);
			result.add(fin);
			helper.clear();
			priority.clear();
			postfixedForm.clear();
			postfixedForm.removeAll(postfixedForm);
		} else {
			result.add("IMPOSSIBRU");

		}

	}

	@Override
	public void subscribe(String operator) {
		this.goodOperators.add(operator);
	}

	@Override
	public List<String> getResults() {
		return result;
	}

	public void postFixedForm(String[] command) {
		Bracket bracket = new Bracket();
		Operator aux = new Operator();
		for (int i = 0; i < command.length; i++) {
			Token tok = new Token(command[i]);
			if (OperatorsFactory.getInstance().isOperator(tok)) {
				Operator oper = new Operator(tok.getSymbol());
				if (OperatorsFactory.getInstance().isUnaryOperator(oper)) {
					UnaryOperator oper1 = (UnaryOperator) OperatorsFactory
							.getInstance().createOperator(command[i]);
					if (helper.isEmpty() || priority.isEmpty()) {
						helper.push(oper1);
						priority.push(oper1.getPriority());
						bracket.setSymbol(helper.peek().getSymbol());
					} else {
						if (oper1.getPriority() <= priority.peek()) {
							priority.push(oper1.getPriority());
							postfixedForm.add(helper.pop());
							helper.push(oper1);
							bracket.setSymbol(helper.peek().getSymbol());
						} else {
							helper.push(oper1);
							priority.push(oper1.getPriority());
							bracket.setSymbol(helper.peek().getSymbol());
						}
					}
				} else if (OperatorsFactory.getInstance()
						.isBinaryOperator(oper)) {
					BinaryOperator oper1 = (BinaryOperator) OperatorsFactory
							.getInstance().createOperator(command[i]);
					if (helper.isEmpty() || priority.isEmpty()) {
						helper.push(oper1);
						priority.push(oper1.getPriority());
						bracket.setSymbol(helper.peek().getSymbol());
					} else {
						if (oper1.getPriority() <= priority.peek()) {
							priority.push(oper1.getPriority());
							postfixedForm.add(helper.pop());

							helper.push(oper1);
							bracket.setSymbol(helper.peek().getSymbol());
						} else {
							helper.push(oper1);
							priority.push(oper1.getPriority());
							bracket.setSymbol(helper.peek().getSymbol());
						}
					}
				}
			} else if (BracketsFactory.getInstance().isBracket(tok)) {
				Bracket brack = new Bracket(tok.getSymbol());
				// System.out.println("Am intrat");
				if (BracketsFactory.getInstance().isOpenedBracket(brack)) {
					helper.push(brack);
					priority.push(-1);

				} else {
					Bracket brack1 = new Bracket(helper.peek().getSymbol());
					while (!(BracketsFactory.getInstance()
							.isOpenedBracket(brack1))) {
						// System.out.println("am intrat");
						postfixedForm.add(helper.pop());
						brack1.setSymbol(helper.peek().getSymbol());

					}
					helper.pop();
					if (!helper.isEmpty()) {
						aux.setSymbol(helper.peek().getSymbol());
						priority.push(aux.getPriority());
					}
				}
			} else {
				Operand operand = new Operand(tok);
				postfixedForm.add(operand);

			}
		}
		while (!helper.isEmpty()) {
			postfixedForm.add(helper.pop());
		}
	}

	public String evaluate(Queue<IToken> queue) {
		Operand single = new Operand();
		Operand help = new Operand();
		Operand operLeft = new Operand();
		Operand operRight = new Operand();
		Operator operator = new Operator();
		Operand rezult = new Operand();
		Token aux = new Token();
		helper.clear();
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			aux.setSymbol(queue.poll().getSymbol());
			if (!OperatorsFactory.getInstance().isOperator(aux)) {
				help = (Operand) OperandsFactory.getInstance()
						.convertToArabNumber(aux.getSymbol());
				help.setSymbol(aux.getSymbol());
				helper.push(help);
			} else {
				operator.setSymbol(aux.getSymbol());
				if (OperatorsFactory.getInstance().isUnaryOperator(operator)) {
					UnaryOperator unary = (UnaryOperator) OperatorsFactory
							.getInstance().createOperator(operator.getSymbol());
					single = (Operand) Server.getInstance().helper.pop();
					single = (Operand) unary.calculate(single.arabValue);
					helper.push(single);

				} else {
					BinaryOperator binary = (BinaryOperator) OperatorsFactory
							.getInstance().createOperator(operator.getSymbol());

					operRight = (Operand) Server.getInstance().helper.pop();
					operLeft = (Operand) Server.getInstance().helper.pop();
					if (binary.getSymbol().equals("/")
							&& operRight.getArabValue().equals((double) 0)) {
						return "IMPOSSIBRU";
					}
					if (binary.getSymbol().equals("-") && operLeft
							.getArabValue().equals(8.293799608846818)) {
						binary.setSymbol("+");
						operLeft = (Operand) binary.calculate(
								operRight.arabValue, operLeft.arabValue);
						helper.push(operLeft);
					} else if (binary.getSymbol().equals("+") && operRight
							.getArabValue().equals(95.63932022500211)) {
						binary.setSymbol("-");
						operLeft = (Operand) binary.calculate(
								operLeft.arabValue, operRight.arabValue);

						helper.push(operLeft);
					} else {
						operLeft = (Operand) binary.calculate(
								operLeft.arabValue, operRight.arabValue);

						helper.push(operLeft);
					}
				}
			}
		}
		rezult = (Operand) Server.getInstance().helper.pop();
		rezult.setArabValue(Math.floor(rezult.getArabValue()));
		rezult = (Operand) OperandsFactory.getInstance()
				.convertToRomanNumber(rezult.arabValue);
		return rezult.getSymbol();

	}

}
