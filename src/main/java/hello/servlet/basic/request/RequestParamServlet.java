package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 */

@WebServlet(name = "requestParamServlet" , urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회 - end");

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        String[] usernames = request.getParameterValues("username");
        for(String name : usernames){
            System.out.println("name = " +  name);
        }
    }
}
