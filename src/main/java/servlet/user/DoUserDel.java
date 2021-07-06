package servlet.user;

import entity.LMONKEY_USER;
import service.LMONKEY_USERDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "DoUserDel", value = "/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");

        String id=request.getParameter("id");



        //加入到数据库的用户表中
        int count = LMONKEY_USERDao.delete(id);
        //成功或失败的去向
        if(count > 0) {
            response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));//一开始地址没写全

        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alter('用户删除失败')");
            out.write("location.href='manger/admin_douserselect?cp="+request.getParameter("cpage")+"'");
            out.write("</script>");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");

        String ids[]=request.getParameterValues("id[]");


        for(int i=0; i<ids.length; i++) {

            LMONKEY_USERDao.delete(ids[i]);
        }
        response.sendRedirect("admin_douserselect");
    }
}
