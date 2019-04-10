package Solution;

import java.util.Stack;

public class Answer {
	int ifsame=0;//判断是不是符号都相同
    int answer=0;//判断结果是否为负数
	public String solution(String question) {//运算混合四则运算方法，利用栈实现
		Stack<String> number = new Stack<String>();//创建一个存储数字或符号的栈
		Stack<Character> operate = new Stack<Character>();//创建一个存储操作符的栈
		int p = (int) (Math.random() * 2) + 2;// p则是产生简单等式的次数，这里取2或3，以保证运算符为3个或5个
		int len = question.length();
		int k = 0;//k是遍历字符串的一个参数
		int same=0;
		for (int j = -1; j < len - 1; j++) {//把题目字符串进行拆分，拆分出数字和运算符，分别进行存储
			if (question.charAt(j + 1) == '+' || question.charAt(j + 1) == '-' || question.charAt(j + 1) == '*'
					|| question.charAt(j + 1) == '÷' || question.charAt(j + 1) == '(' || question.charAt(j + 1) == ')'
					|| j == len - 2) {

				if (j == -1) {//如果第一个就是运算符，即左括号，存储在操作符栈中
					operate.push(question.charAt(0));

				} else if (j == len - 2) {//如果到字符串的最后了，直接存储到数字栈中
                    if(question.charAt(len-1) == ')'){
                    	number.push(question.substring(k,len-1));
                    	number.push(String.valueOf(operate.pop()));
						if (!operate.empty()) {
							operate.pop();
						}
                    }else{
					number.push(question.substring(k));
                    }
					break;
				} else {
                    if(question.charAt(j+1)=='-'&&(question.charAt(j) == '+' || question.charAt(j) == '-' || question.charAt(j) == '*'
        					|| question.charAt(j) == '÷' || question.charAt(j) == '(' )){
                    	j=j+2;
                    }
					if (k <= j) {
						number.push(question.substring(k, j + 1));//是数字的话存储到数字这个栈中
					}
					if (operate.empty() || question.charAt(j + 1) == '(') {//操作符栈为空或者接下来的符号是左括号的话都直接存储到操作符栈中
						operate.push(question.charAt(j + 1));
					} else if ((operate.peek() == '+' || operate.peek() == '-')
							&& (question.charAt(j + 1) == '*' || question.charAt(j + 1) == '÷')) {
						operate.push(question.charAt(j + 1));//如果将要放入栈中的运算符优先级比栈顶元素高，直接入栈
					} else if (operate.peek() == '(') {//栈顶是左括号的话，下一个操作符也直接入栈
						operate.push(question.charAt(j + 1));
					} else if (question.charAt(j + 1) == ')') {//下一个操作符是右括号的话，弹出操作符栈顶元素并压入数字栈中
						number.push(String.valueOf(operate.pop()));
						if (!operate.empty()) {
							operate.pop();
						}
					} else {//操作符是同等优先级的时候，把栈顶元素弹出压入数字栈中，并把下一个操作符压入操作符栈中
						if(operate.peek()==question.charAt(j + 1)){
							same++;
						}
						number.push(String.valueOf(operate.pop()));
						operate.push(question.charAt(j + 1));
					}
				}
				k = j + 2;
			}
		}
		if(same==p+2){//判断题目的符号是否都相同
			ifsame=1;
		}
		while (!operate.empty()) {//最后把操作符栈中剩余的元素都压入数字栈中
			number.push(String.valueOf(operate.pop()));
		}
		String[] result = new String[20];
		int k1 = 0;
		while (!number.empty()) {//把数字栈中的元素也就是形成的后缀表达式存储在数组中
			result[k1] = number.pop();
			k1++;
		}
		for (k1 = k1 - 1; k1 >= 0; k1--) {//逆序遍历数组，运算得到的后缀表达式

			if (!result[k1].equals("+") && !result[k1].equals("-") && !result[k1].equals("*")
					&& !result[k1].equals("÷")) {//是数字的话，先压入栈中
				number.push(result[k1]);
			} else {
				int a1 = 0;
				int b1 = 0;
				if (!number.empty()) {//弹出两个数进行相应运算
					b1 = Integer.parseInt(number.pop());
				}
				if (!number.empty()) {
					a1 = Integer.parseInt(number.pop());
				}
				if (result[k1].equals("+")) {//如果是加号的话，弹出两个数相加
					int c1 = a1 + b1;
					number.push(String.valueOf(c1));
				} else if (result[k1].equals("-")) {
					int c1 = a1 - b1;
					number.push(String.valueOf(c1));
				} else if (result[k1].equals("*")) {
					int c1 = a1 * b1;
					number.push(String.valueOf(c1));
				} else {
					int c1 = a1 / b1;
					number.push(String.valueOf(c1));
				}
			}
		}
		if(Integer.parseInt(number.peek())<0){
			answer=1;
		}
        if(ifsame==1){//如果全部符号都相等或结果小于0话，不输出题目
        	;
        }else{
        	return number.pop();
        }
        return null;
	}

}