package br.com.ifg.ifeventos.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
@RequestScoped
public class LogInterceptor {

    @Inject
    private HttpServletRequest request;

    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
        System.out.println("Interceptando " + request.getRequestURI());
        stack.next();
    }
}
