package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

@WebServlet(name = "ResponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Content-Type: application/json; charset=utf-8
		response.setContentType("application/json");
		request.setCharacterEncoding("utf-8");

		HelloData helloData = new HelloData();
		helloData.setUsername("Lim");
		helloData.setAge(20);

		//json 형식으로 변환
		String result = objectMapper.writeValueAsString(helloData);
		response.getWriter().write(result);

	}
}
