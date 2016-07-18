package br.com.ifg.ifeventos.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
@RequestScoped
public class LogInterceptor {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public LogInterceptor(){};
	
	@Inject
	public LogInterceptor(HttpServletRequest request,
			HttpServletResponse response ) {
		this.request = request;
		this.response = response;
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		System.out.println("Interceptando " + request.getRequestURI());
		stack.next();
	}
    
	// Metódo provisório apenas para o desenvolvimento em ambiente local
	@BeforeCall
	public void intercept() throws InterceptionException {

		String origin = request.getHeader("origin") != null ? request.getHeader("origin") : "*";

		response.addHeader("Access-Control-Allow-Origin", origin);
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Expose-Headers", "Content-Type, Location");
	}

}
