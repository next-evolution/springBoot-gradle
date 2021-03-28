package jp.co.next_evolution.sample.api;

import jp.co.next_evolution.sample.api.annotation.AuthExclude;
import jp.co.next_evolution.sample.dto.LoginUser;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

@Component
public class ApiInterceptor implements HandlerInterceptor {

    private static final String X_API_AUTH_CODE = "X-ApiAuthCode";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // skip static resource
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // skip auth exclude annotation
        HandlerMethod hm = (HandlerMethod) handler;
        Method method = hm.getMethod();
        AuthExclude annotation = AnnotationUtils.findAnnotation(method, AuthExclude.class);
        if (Objects.nonNull(annotation)) {
            return true;
        }

        String xCoreAuth = request.getHeader(X_API_AUTH_CODE);
        if (!StringUtils.hasText(xCoreAuth)) {
            response.sendRedirect(request.getContextPath() + "/error/403");
            return false;
        }

        LoginUser loginUser = (LoginUser) request.getSession().getAttribute(LoginUser.class.getName());
        if (Objects.isNull(loginUser)) {
            response.sendRedirect(request.getContextPath() + "/error/auth");
            return false;
        }

        if (!ObjectUtils.nullSafeEquals(xCoreAuth, loginUser.getAuthCode())) {
            response.sendRedirect(request.getContextPath() + "/error/auth");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
