package hello.servlet.web.servletmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String viewPath="/WEB-INF/views/new-form.jsp";
		//컨트롤러에서 뷰로 이동할때 사용
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		// 서블릿에서 jsp를 호출할 수 있다
		dispatcher.forward(request,response);

	}
}
