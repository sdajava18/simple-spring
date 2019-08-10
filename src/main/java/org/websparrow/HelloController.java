package org.websparrow;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class HelloController implements Controller {

	private StringService stringService;

	public HelloController(StringService stringService) {
		this.stringService = stringService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");

		Map<String, String> map = new HashMap<>();
		map.put("name", this.stringService.uppercase(name));

		return new ModelAndView("welcome", map);
	}

}
