package hello.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet.service");
		System.out.println("req = " + req);
		System.out.println("resp = " + resp);

		String username = req.getParameter("username");
		System.out.println("username = " + username);

		//응답 메시지 보내기
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("utf-8"); //위에 두개는 헤더에 들어간다
		resp.getWriter().write("hello"+username); // 바디에 담긴다
	}
}
