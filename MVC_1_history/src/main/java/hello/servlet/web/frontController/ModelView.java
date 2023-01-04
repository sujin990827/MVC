package hello.servlet.web.frontController;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ModelView {

	private String viewName;
	private Map<String, Object> model = new HashMap<>();

	public ModelView(String viewName) {
		this.viewName = viewName;
	}

}
