package frame;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 2016/12/16.
 *  preHandler ：在进入Handler方法之前执行了，使用于身份认证，身份授权，登陆校验等，比如身份认证，用户没有登陆，拦截不再向下执行，返回值为 false ，即可实现拦截；否则，返回true时，拦截不进行执行；
 postHandler : 进入Handler方法之后，返回ModelAndView之前执行，使用场景从ModelAndView参数出发，比如，将公用的模型数据在这里传入到视图，也可以统一指定显示的视图等；
 afterHandler : 在执行Handler完成后执行此方法，使用于统一的异常处理，统一的日志处理等；
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
    private List<String> excludedUrls;
    public void setExcludeUrls(List<String> excludeUrls) {
          this.excludedUrls = excludeUrls;
    }
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
            String requestURI = httpServletRequest.getRequestURI();
            for (String url : excludedUrls) {  //例外的路径  访问页面的时候是没有提交操作的，所以没有走这个逻辑
                if (requestURI.endsWith(url)) {
                    return true;
                }
            }
            //一下内容判断session的内容，如果session内容为空，则跳转到登录页面
            HttpSession session = httpServletRequest.getSession();
            String username = (String) session.getAttribute("username");
            if(username!=null){
                //登陆成功的用户
                return true;
            }else{
                //没有登陆，转向登陆界面
                httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest,httpServletResponse);
                return false;
            }


    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
