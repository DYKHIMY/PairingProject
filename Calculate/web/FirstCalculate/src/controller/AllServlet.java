package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.search.StringTerm;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import MakeQuestion.MakeQuestion;
import Solution.Answer;
import entity.Student;
import java.util.Comparator;

/**
 * Servlet implementation class AllServlet
 */
@WebServlet("/AllServlet")
public class AllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String studentId = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String flag = request.getParameter("flag");
		switch (flag) {
		case "MakeAnswer":
			upload(request, response);
			break;
		case "score":
			score(request, response);
			break;
		case "record":
			record(request, response);
			break;
		case "MakeQuestion":
			MakeQ(request, response);
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/");
		System.out.println(path);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		// 新建一个jsmartUpLoad对象
		SmartUpload smartUpload = new SmartUpload();
		// 上传初始化
		smartUpload.initialize(this.getServletConfig(), request, response);

		try {
			// 上传文件
			smartUpload.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		com.jspsmart.upload.File myFile = smartUpload.getFiles().getFile(0);
		String ext = myFile.getFileExt();
		if (!ext.equals("txt")) {
			response.getWriter().print("<script language='javascript'>alert('文件格式错误')</script>");
			response.setHeader("refresh", "1;URL=index.jsp");
		} else {
			String newName = "question" + sdf.format(new Date()) + "." + ext;
			String filePath1 = path + "document/" + newName;// 最终文件的保存路径
			System.out.println(filePath1);
			String encoding = "GBK";
			try {
				myFile.saveAs(filePath1);
				studentId = smartUpload.getRequest().getParameter("xh");

				File file = new File(filePath1);
				try {
					InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
					BufferedReader br = new BufferedReader(read);// 构造一个BufferedReader类来读取文件
					String s = null;
					List<String> questionList = new ArrayList<String>();
					List<String> answerList = new ArrayList<String>();
					while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
						Answer answer = new Answer();
						// String s1=new String(s.getBytes("iso-8859-1"),"GBK");
						// System.out.println(s1);
						questionList.add(s);
						answerList.add(answer.solution(s));
					}
					br.close();

					request.setAttribute("questionList", questionList);
					request.setAttribute("answerList", answerList);
					request.getRequestDispatcher("/answer.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return filePath1;
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public void score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questionNum = request.getParameter("questionNum");
		String correctNum = request.getParameter("correctNum");
		String time1 = request.getParameter("time");
		double correct = Double.valueOf(correctNum) / Double.valueOf(questionNum) * 100.0;
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			System.out.println(this.getServletContext().getRealPath("/") + "document/score.txt");
			String content = studentId + "+" + correct + "+" + time1 + "+" + dateFormat.format(date) + "\r\n";
			FileOutputStream fos = new FileOutputStream(
					new File(this.getServletContext().getRealPath("/") + "document/score.txt"), true);// 建立文件流,用以输出计算式
			fos.write(content.getBytes());
			fos.flush();
			fos.close();
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void record(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(this.getServletContext().getRealPath("/") + "document/score.txt");
		String encoding = "GBK";
		try {
			InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
			BufferedReader br = new BufferedReader(read);// 构造一个BufferedReader类来读取文件
			String s = null;
			List<Student> studentInf = new ArrayList<Student>();
			String[] a;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				Student student = new Student();
				a = s.split("\\+");
				student.setStudentId(a[0]);
				student.setPerscore(a[1]);
				student.setAvgtime(a[2]);
				student.setZttime(a[3]);
				studentInf.add(student);
			}
			br.close();
			int k = Integer.parseInt(request.getParameter("k"));
			if (k == 0) {
				request.setAttribute("studentInf", studentInf);
				request.setAttribute("k", 0);
				request.getRequestDispatcher("/rank.jsp").forward(request, response);
			} else {
				Collections.sort(studentInf, new Comparator<Student>() {

					public int compare(Student o1, Student o2) {
						if (Double.valueOf(o1.getPerscore()) < Double.valueOf(o2.getPerscore())) {
							return 1;
						}
						if (o1.getPerscore() == o2.getPerscore()) {
							return 0;
						}
						return -1;
					}
				});
				for (int i = 0; i < studentInf.size(); i++) {
					for (int j = i + 1; j < studentInf.size(); j++) {
						if (studentInf.get(j).getStudentId().equals(studentInf.get(i).getStudentId())) {
							studentInf.remove(j);
							j--;
						}
					}
				}
				for (int i = 0; i < studentInf.size(); i++) {
					System.out.println(studentInf.get(i).getStudentId());
				}
				request.setAttribute("studentInf1", studentInf);
				request.setAttribute("k", 1);
				request.getRequestDispatcher("/rank.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void MakeQ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		int min = Integer.parseInt(request.getParameter("mmin"));
		int max = Integer.parseInt(request.getParameter("mmax"));
		int o = Integer.parseInt(request.getParameter("o"));
		boolean c = false;
		boolean b = false;
		if (request.getParameter("c").equals("有")) {
			c = true;
		}
		if (request.getParameter("b").equals("有")) {
			b = true;
		}
		MakeQuestion question = new MakeQuestion();
		try {
			String path = this.getServletContext().getRealPath("/");
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
			// String newName = "Makequestion"+sdf.format(new Date())+".txt";
			// String ResultName=path +"document/"+newName;
			PrintStream ps = new PrintStream(path + "document/result.txt", "GBK");// 创建一个打印输出流
			System.setOut(ps);// 把创建的打印输出流赋给系统。即系统下次向 ps输出
			question.MakeQuestion3(n, min, max, o, c, b);
			// 下载
			SmartUpload smartUpload1 = new SmartUpload();
			smartUpload1.initialize(getServletConfig(), request, response);
			smartUpload1.setContentDisposition(null);// 取消默认打开方式
			try {
				smartUpload1.downloadFile(path + "document/result.txt");
			} catch (Exception e) {
				response.getWriter().print("<script language='javascript'>alert('出题文件下载失败')</script>");
				if (e.getMessage().indexOf("系统找不到指定的路径。") != -1) {
					response.getWriter().print("<script language='javascript'>alert('出题文件下载失败:文件不存在！')</script>");
				}
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
