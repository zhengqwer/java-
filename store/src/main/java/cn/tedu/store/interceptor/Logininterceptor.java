package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 登录拦截器
 * @author soft01
 *
 */
public class Logininterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取session对象
		HttpSession session = request.getSession();
		//尝试从session中获取用户的uid(因为登录后的session中保存的有usernaem和uid)
		Object uid = session.getAttribute("uid");
		//判断是否正确的获取到了uid
		if(uid == null) {
			//尝试获取uid失败,用户没有登录，或登录超时
			response.sendRedirect("/web/login.html");
			return false;
		}
		//放行,登录成功
		return true;
	}
	
	
}
