package straightLinePrograms;

public class StraightLine {
	
	// straight line statements
	/**
	 * statement:
	 * a := 6+4; b:= ( print(a-1,a+1), (a-1)*a+1 ); print(b)
	 */
	// abstract class for every grammar rule:
	
	// statements:
	public abstract class Statement {};
	// expressions:
	public abstract class Expression {};
	// lists:
	public abstract class List {};
	
	public class CompoundStatement extends Statement{
		public Statement stm1, stm2;
		public CompoundStatement (Statement stm1, Statement stm2){
			this.stm1 = stm1;
			this.stm2 = stm2;
		}
	}
	
	public class AssignStatement extends Statement{
		public Expression exp;
		public String subject;
		public AssignStatement (String object, Expression exp){
			subject = object;
			this.exp = exp;
		}	
	}
	
	public class PrintStatement extends Statement{
		public List list;
		public PrintStatement(List list){
			this.list = list;
		}
	}
	
	public class NumberExp extends Expression{
		public int number;
		public NumberExp(int num){
			number = num;
		}
	}
	
	public class OperationExp extends Expression{
		public NumberExp numExp1, numExp2;
		public Operator op;
		int calculate = 0;
		public OperationExp(NumberExp num1, NumberExp num2, Operator operator){
			numExp1 = num1;
			numExp2 = num2;
			op = operator;
			switch(op){
				case PLUS:
					calculate = 1;
					break;
				case MINUS:
					calculate = 2;	
					break;
				case TIMES:
					calculate = 3;
					break;
				case DIVIDE:
					calculate = 4;
					break;
			}
		}
	}
	
	public enum Operator {
		PLUS, MINUS, TIMES, DIVIDE
	}
	
	public class IdExp extends Expression{
		public String id;
		public IdExp(String id){
			this.id = id;
		}
	}
	
	public class EseqExp extends Expression{
		public Statement statement;
		public Expression exp;
		public EseqExp(Statement stm, Expression exp){
			statement = stm;
			this.exp = exp;
		}
	}
	
	public class LastList extends List{
		public Expression exp;
		public LastList(Expression exp){
			this.exp = exp;
		}
	}
	
	public class PairList extends List{
		public Expression exp;
		public List list;
		public PairList(Expression exp, List list){
			this.exp = exp;
			this.list = list;
		}
	}
	
}
