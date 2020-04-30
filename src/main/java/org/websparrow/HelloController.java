package org.websparrow;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HelloController implements Controller {

	private MyTestBean myTestBean;

	private UserDatabase userDatabase;

	public HelloController(MyTestBean myTestBean, UserDatabase userDatabase) {
		this.myTestBean = myTestBean;
		this.userDatabase = userDatabase;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");

		Map<String, Object> map = new HashMap<>();

		Optional<User> userOptional = userDatabase.getUserByName(name);

		map.put("name", this.myTestBean.toUpperCase(name));
		userOptional.ifPresent(user -> map.put("user", user));

		return new ModelAndView("welcome", map);
	}

}
