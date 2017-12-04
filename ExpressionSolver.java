//package problem_1;

/**
 * This class named ExpressionSolver, allows you to evaluate simple expressions contained in a 
 * text file.
 * Date: 12/03/2017
 * @author Alexander Wong
 * @version 1.0
 */

public class ExpressionSolver{

	private static int index = 0;
	private static String expression = "";
	private static int index_stop = 0;
	private static boolean op1_flag = false;
	private static boolean op2_flag = false;
	private static double o1, o2, o3;
	private static char op1, op2;
	
	/**
	 * This constructs a ExpressionSolver object. Using a string input from the text file, 
	 * constructs a new String expression object.
	 * 
	 * @param input String from user
	 */
	
	public ExpressionSolver(String input) {
		expression = input;
	}
	
	/**
	 * This method iterates through the string input from the text file and obtains the operands in the expression.
	 * @return the operand in an expression.
	 */
	private static double getOperand() throws Exception
	{
		String s="";
		double r = 0;
		boolean negative_flag = false;

		while(index < index_stop &&  expression.charAt(index) != '+' && 
				expression.charAt(index) != '*' &&
				expression.charAt(index) != '/' &&
				expression.charAt(index) != ' ' &&
				expression.charAt(index) != '(' &&
				expression.charAt(index) != ')')

		{
			if(expression.charAt(index) =='-') {
				if((index) == 0) {
					String test="";
					try {
						test += expression.charAt(index+1);
					}catch(Exception e){
						throw new Exception("Error: incomplete expression.");
					}
					System.out.println(test);
					negative_flag = true;
					index++;
			
					
				}else if((expression.charAt(index - 1) == '-' ||
						expression.charAt(index - 1) == '+' ||
						expression.charAt(index - 1) == '*' ||
						expression.charAt(index - 1) == '/') &&(index < expression.length() && expression.charAt(index+1) != '+' &&
						expression.charAt(index+1) != '*' &&
						expression.charAt(index+1) != '/' &&
						expression.charAt(index+1) != ' ' &&
						expression.charAt(index+1) != '(')) {
					negative_flag = true;
					index++;
				}else{
					break;
				}
			}
	
			s += expression.charAt(index);

			index++;
		}

	
		if((index < index_stop) && (expression.charAt(index) == '(')) {
			while((expression.charAt(index) == '(') || 
					(expression.charAt(index) == '+') ||
					(expression.charAt(index)=='-') ||
					(expression.charAt(index)=='*') ||
					(expression.charAt(index)=='/')) {
				index++;
			
			}
			if(expression.charAt(index-1)=='-') {
				negative_flag = true;
			}
			s += expression.charAt(index);
	
			index++;
			while(index < index_stop &&  expression.charAt(index) != '+' && 
					expression.charAt(index) != '*' &&
					expression.charAt(index) != '/' &&
					expression.charAt(index) != ' ' &&
					expression.charAt(index) != '(' &&
					expression.charAt(index) != ')' &&
					expression.charAt(index) != '-') {
				s += expression.charAt(index);
				index++;
			}
		}

		try {
			r = Integer.parseInt(s);
		}catch(Exception e){
			try {
				r = Double.parseDouble(s);
			}catch(Exception a) {
				throw new Exception("Error: incomplete expression.");
			}
		}
		if(negative_flag) {
			r = r / -1.0;
			negative_flag = false;
		}
		return r;
	}
	
	/**
	 * This method iterates through the string input from the text file and obtains the operator in the expression.
	 * @return the operator in an expression.
	 */
	private static char getOperator() throws Exception
	{
		if(expression.charAt(index)==')') {
			throw new Exception("End of paranthesis expression.");
		}
		char o;
		o = expression.charAt(index);
		index++;
		return o;
	}
	
	/**
	 * This method takes two operands and adds them together.
	 * @param two operands
	 * @return the sum of two operands.
	 */
	
	public static double addition(double a, double b) {
		double result = a + b;
		return result;
	}
	
	
	/**
	 * This method takes two operands and subtracts them.
	 * @param two operands
	 * @return the difference of two operands.
	 */
	public static double subtraction(double a, double b) {
		double result = a - b;
		return result;
	}
	
	/**
	 * This method takes two operands and multiplies them.
	 * @param two input operands
	 * @return the product of two operands.
	 */
	public static double multiplication(double a, double b) {
		double result = a * b;
		return result;
	}
	
	/**
	 * This method takes two operands and divides them.
	 * @param two input operands
	 * @return the quotient of two operands.
	 */
	public static double division(double a, double b) throws Exception
	{
		if(b == 0) {
			throw new Exception("Error: Divide by zero. Undefined.");
		}
		double result = a / b;
		return result;
		
	}
	
	/**
	 * This method takes three operands and two operators as parameters and evaluates them.
	 * @param three operands and two operators
	 * @return the result of an expression involving two operators and three operands.
	 */
	public static double evaluate(double a, char a1, double b, char a2, double c) throws Exception
	{
		double result = 0;
		if(a1=='*') {
			result = multiplication(a,b);
			op1_flag = true;
		}else if(a1 == '/') {
			result = division(a,b);
			op1_flag = true;
		}
		if(a2 == '*') {
			result = multiplication(b,c);
			op2_flag = true;
		}else if(a2 == '/') {
			result = division(b,c);
			op2_flag = true;
		}else if(a1=='+') {
			result = addition(a,b);
			op1_flag = true;
		}else if(a1=='-') {
			result = subtraction(a,b);
			op1_flag = true;
		}
		return result;
	}
	
	/**
	 * This method takes two operands and an operator as parameters and evaluates them.
	 * @param two operands and an operator
	 * @return the result of an expression involving two operands and an operator.
	 */
	public static double evaluate(double a, char a1, double b) throws Exception{
		double result = 0;
		switch(a1) {
		case '*':
			result = multiplication(a,b);
			break;
		case '/':
			result = division(a,b);
			break;
		}
		switch(a1) {
		case '+':
			result = addition(a,b);
		
			break;
		case '-':
			result = subtraction(a,b);
			break;
		}
		return result;
	}
	
	/**
	 * This method takes two operands and an operator as parameters and evaluates them based on precedences
	 * of the operators.
	 * @param three operands and two operators
	 * @return the result of an expression involving two operators and three operands.
	 */
	
	public static double evaluate2(double a, char a1, double b, char a2, double c) throws Exception{
		double result = 0;
	
		if(a1=='*') {
			result = multiplication(a,b);
			if(a2 == '*') {
				result = multiplication(result,c);
				return(result);
			}else if(a2 == '/') {
				result = division(result,c);
				return(result);
			}else if(a2 == '+') {
				result = addition(result,c);
				return(result);
			}else if(a2 == '-') {
				result = subtraction(result,c);
				return(result);
			}
		
		}else if(a1 == '/') {
			result = division(a,b);
			if(a2 == '*') {
				result = multiplication(result,c);
				return(result);
			}else if(a2 == '/') {
				result = division(result,c);
				return(result);
			}else if(a2 == '+') {
				result = addition(result,c);
				return(result);
			}else if(a2 == '-') {
				result = subtraction(result,c);
				return(result);
			}
		}
		
		if(a2 == '*') {
			result = multiplication(b,c);

			if(a1 == '+') {
				result = addition(a,result);
		
				return(result);
			
			}else if(a1 == '-') {
				result = subtraction(a,result);
				return(result);
			}
		}
		
		if(a2 == '/') {
			result = division(b,c);
			if(a1 == '+') {
				result = addition(a,result);
				return(result);
			}else if(a1 == '-') {
				result = subtraction(a,result);
				return(result);
			}
		}
	
		if(a1 == '+') {
			result = addition(a,b);

			if(a2=='+') {
				result = addition(result,c);
	
				return(result);
			}else if(a2=='-') {
				result = subtraction(result,c);
				return(result);
			}
			
		}else if(a1=='-') {
			result = subtraction(a,b);
			if(a2=='+') {
				result = addition(result,c);
				return(result);
			}else if(a2=='-') {
				result = subtraction(result,c);
				return(result);
			}
		}
		return result;
	}
	
	
	/**
	 * This method takes three operands and two operators and saves them into 5 tokens variables. Evaluates
	 * an expression using these 5 token variables.
	 * @return the result of an expression involving two operators and three operands as 5 token variables.
	 */
	public static double solve() throws Exception

	{
		double result = 0;
		o1 = getOperand();
		try {
		op1 = getOperator();
		}catch(Exception e) {
			result = o1;
			return(result);
		}
		o2 = getOperand();
		try {
		op2 = getOperator();
		}catch(Exception e) {
			result = evaluate(o1,op1,o2);
			return(result);
		}
		
		o3 = getOperand();
		while(index < index_stop) {
			
			result = evaluate(o1,op1,o2,op2,o3);
			if(op1_flag) {
				o1 = result;
				op1 = op2;
				o2 = o3; 
				try {
					op2 = getOperator();
					o3 = getOperand();
				}catch(Exception e){
					result = evaluate(o1,op1,o2);
				}
				op1_flag = false;
		
			}else if(op2_flag) {
				o2 = result;
				try {
					op2 = getOperator();
					o3 = getOperand();
				}catch(Exception e) {
					result = evaluate(o1,op1,o2);
				}
				op2_flag = false;
			}
		}

		result = evaluate2(o1,op1,o2,op2,o3);
		return(result);
		}

	/**
	 * This method takes three operands and two operators and saves them into 5 tokens variables. Evaluates
	 * an expression that includes parenthesis grouping, using these 5 token variables.
	 * @return the result of an expression including parenthesis, involving two operators and three operands 
	 * as 5 token variables.
	 */
	
	public static double paranthesis() throws Exception {
		double result = 0;
		int paranthesis_count = 0;
		for(int i = 0;i < expression.length();i++) {
			if((expression.charAt(i) ==')') || (expression.charAt(i) == '(')) {
				paranthesis_count++;
			}
		}
		
		for(int i = 0;i < expression.length();i++) {
			if((expression.charAt(i) == '(')) {
				if((i > 0) &&
					(expression.charAt(i - 1) != '+') &&
					(expression.charAt(i - 1) !='-') &&
					(expression.charAt(i - 1) != '*') &&
					(expression.charAt(i - 1) != '/') &&
					(expression.charAt(i - 1) != '(')
						) {
					
					expression = expression.substring(0,i) + "*" + expression.substring(i,expression.length());
				}
			}
		}

		int opening_index = 0;
		int closing_index = 0;
	
		while(paranthesis_count > 1) {
			for(int i = (expression.length() - 1);i >= 0 ;i--) {
				if(expression.charAt(i) =='(') {
					opening_index = i;
				for(int y = opening_index; y < expression.length(); y++) {
					if(expression.charAt(y) == ')') {
						closing_index = y;

						break;
					}
				}
				break;
				}
			}
			
			index = opening_index;
			index_stop = closing_index;
			String replacement = "";
			replacement = expression.substring(opening_index, (closing_index + 1));
			expression = expression.replace(replacement,String.valueOf(solve()));
			paranthesis_count = paranthesis_count - 2;
		}
			index = 0;
			index_stop = expression.length();
			result = solve();
		
		return result;
	}
}
