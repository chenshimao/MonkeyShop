package servlet.user;

import dao.Basedao;
import entity.LMONKEY_USER;
import service.LMONKEY_USERDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "ToUserUpdate", value = "/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //获取参数
        String id = request.getParameter("id");
        //查询
        LMONKEY_USER user = LMONKEY_USERDao.selectById(id);


        request.setAttribute("user",user);
        request.setAttribute("cpage",request.getParameter("cpage"));

        request.getRequestDispatcher("admin_usermodify.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
