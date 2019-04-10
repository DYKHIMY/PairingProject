
import java.io.PrintStream;

public class Command {

	public static void main(String[] args) {
		int n = 0;// 题目数量
		int min = 0;
		;// 题目数值的下界
		int max = 100;// 题目数值的上界
		int o = 1;// 运算符的最多数目
		boolean c = false;// 是否包含乘法
		boolean b = false;// 是否产生括号
		boolean ifn = false;
		boolean ifm = false;
		boolean ifrun = true;
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-n")) {
				ifn = true;
				try {
					n = Integer.parseInt(args[i + 1]);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("题目个数为1-10000的正整数，请正确输入");
				}

				if (n <= 0 || n > 10000) {
					ifrun = false;
					System.out.println("请输入1-10000的正整数作为题目个数的参数");
				}
				if(i < args.length-1){
					i++;
					}else{
						System.out.println("-n后必须要有一个正整数的输入，请重新输入");
					}
			}
			if (args[i].equals("-m")) {
				ifm = true;
				try {
					min = Integer.parseInt(args[i + 1]);
					max = Integer.parseInt(args[i + 2]);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("请输入正确的上下界形式");
				}

				if (min <= 0 || min > 100) {
					ifrun = false;
					System.out.println("题目数值下界的范围应为1-100，请重新输入");
				}
				if (max < 50 || max > 1000) {
					ifrun = false;
					System.out.println("题目数值上界的范围应为50-1000，请重新输入");
				}
				
				if(i < args.length-2){
					i = i + 2;
					}else{
						System.out.println("-m后必须要有两个个正整数的输入，请重新输入");
					}
			}
			if (args[i].equals("-o") ){
				try {
					o = Integer.parseInt(args[i + 1]);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("运算符个数为1-10的正整数，请重新输入");
				}

				if (o < 0 || o > 10) {
					ifrun = false;
					System.out.println("题目运算符数量应为1-10，请重新输入");
				}
				if(i < args.length-1){
				i++;
				}else{
					System.out.println("-o后必须要有一个正整数的输入，请重新输入");
				}
			}
			if (args[i].equals("-c")) {
				c = true;
			}
			if (args[i].equals("-b")) {
				b = true;
			}

		}
		if (ifn == false) {
			System.out.println("输入的参数中必须包含题目数量，请重新输入");
		} else if (ifm == false) {
			System.out.println("输入的参数中必须包含对题目数值上下界的设定，请重新输入");
		} else {
			if (ifrun == true) {
				MakeQuestion question = new MakeQuestion();
				try {
					PrintStream ps = new PrintStream("../result.txt","UTF-8");// 创建一个打印输出流
					System.setOut(ps);// 把创建的打印输出流赋给系统。即系统下次向 ps输出
					question.MakeQuestion3(n, min, max, o, c, b);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("文件出错");
				}

			}
		}
	}

}
