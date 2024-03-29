package org.websparrow;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HelloController implements Controller, InitializingBean, DisposableBean {

	private StringService stringService;

	private IUserDatabase userDatabase;

	public HelloController(StringService stringService, IUserDatabase userDatabase) {
		this.stringService = stringService;
		this.userDatabase = userDatabase;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");

		Optional<User> userOptional = userDatabase.getByName(name);

		Map<String, String> map = new HashMap<>();
		if(userOptional.isPresent()) {
			User user = userOptional.get();

			map.put("name", this.stringService.uppercase(user.getName()));
			map.put("surname", user.getSurname());
			map.put("age", String.valueOf(user.getAge()));
		}

		return new ModelAndView("welcome", map);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean zainicjowany " + this.getClass().getSimpleName());
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean prawie zniszczony " + this.getClass().getSimpleName());
	}

}
