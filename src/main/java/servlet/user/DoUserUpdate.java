package servlet.user;

import entity.LMONKEY_USER;
import service.LMONKEY_USERDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "DoUserUpdate", value = "/manage/admin_douserupdate")
public class DoUserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //接受参数
        String username=request.getParameter("userName");
        String name=request.getParameter("name");
        String psd=request.getParameter("passWord");
        String sex=request.getParameter("sex");
        String year=request.getParameter("birthday");
        String email=request.getParameter("Email");
        String mobile=request.getParameter("mobile");
        String address=request.getParameter("address");
        String userStatus = request.getParameter("userStatus");
        int status = 1;
        if(userStatus!=null){
            status = Integer.parseInt(userStatus);
        }

        //创建用户实体
        LMONKEY_USER u=new LMONKEY_USER(username, name, psd,sex,year, null, email,mobile,address,status);

        int count = LMONKEY_USERDao.update(u);

        if(count>0){
            response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
        }
        else{
            Writer writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('添加用户失败')");
            writer.write("location.href='/manage/admin_touserupdate?id="+username+"'");
            writer.write("</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
