package hello.servlet.web.frontController.v1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontController.v1.ControllerV1;

public class MemberFormControllerV1 implements ControllerV1 {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPath="/WEB-INF/views/new-form.jsp";
		//컨트롤러에서 뷰로 이동할때 사용
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		// 서블릿에서 jsp를 호출할 수 있다
		dispatcher.forward(request,response);
	}
}
