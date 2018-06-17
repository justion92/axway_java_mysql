package oprea.constantin.service.interceptor;


import oprea.constantin.service.sesion.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class MyRequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SesionService sesionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String requestUrl = request.getRequestURI();
        if(requestUrl.contains("/login")){
            return true;
        }
        if(!sesionService.isLogin()){
            response.setStatus(401);
            System.out.println("The user is not logged in!");
            return false;
        }
        return true;
    }
}
