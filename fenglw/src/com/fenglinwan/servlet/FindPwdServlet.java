package com.fenglinwan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fenglinwan.service.UserService;
/*
 * 
 * .......................我佛慈悲...................... 
 *                       _oo0oo_ 
 *                      o8888888o 
 *                      88" . "88 
 *                      (| -_- |) 
 *                      0\  =  /0 
 *                    ___/‘---'\___ 
 *                  .' \\|     |// '. 
 *                 / \\|||  :  |||// \ 
 *                / _||||| -卍-|||||- \ 
 *               |   | \\\  -  /// |   | 
 *               | \_|  ''\---/''  |_/ | 
 *               \  .-\__  '-'  ___/-. / 
 *             ___'. .'  /--.--\  `. .'___ 
 *          ."" '<  `.___\_<|>_/___.' >' "". 
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | | 
 *         \  \ `_.   \_ __\ /__ _/   .-` /  / 
 *     =====‘-.____`.___ \_____/___.-`___.-'===== 
 *                       “=---=” 
 *                        
 *.....................佛祖开光 ,永无BUG................... 
 *  
 */
@WebServlet("/FindPwdServlet")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FindPwdServlet() {
        super();
    }
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String userphone=request.getParameter("user_phone");
	
	
//	String userid=request.getParameter("user_id");
//	String base64_user_id=Base64.getBase64(userid);
	
//	String question=request.getParameter("question");
//	String base64_ques=Base64.getBase64(question);
//	
//	String answer=request.getParameter("answer");
//	String base64_answer=Base64.getBase64(answer);
	
//	String user = Until.findPwd(base64_user_phone, base64_user_id,base64_ques,base64_answer);
//	String user =Until.findPwd(base64_user_id);

	String a=new UserService().Findpwd(userphone);
	System.out.println(a);
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out=response.getWriter();
    out.println("<html>");
    out.println("<head><title>密码找回</title></head>");
    out.println("<body>");
    out.println("<h1 align='center'>"+a+"</h1>");
    out.println("<a href='Login.jsp'>返回登录</a>");
    out.println("</body></html>");
    out.flush();
    out.close();
}
}

