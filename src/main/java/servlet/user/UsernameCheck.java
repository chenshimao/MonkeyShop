package servlet.user;

import service.LMONKEY_USERDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UsernameCheck", value = "/usernamecheck")
public class UsernameCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            String name = request.getParameter("name");

            int count = LMONKEY_USERDao.selectByName(name);

            PrintWriter out = response.getWriter();
            if(count > 0) {
                out.print("false");
            }else {
                out.print("true");
            }

            out.close();

        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
