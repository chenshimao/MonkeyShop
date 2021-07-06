package servlet.user;

import entity.LMONKEY_USER;
import service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DoUserAdd", value = "/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {
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

        //创建用户实体
        LMONKEY_USER u=new LMONKEY_USER(username, name, psd,sex,year, null, email,mobile,address,1);

        int count = LMONKEY_USERDao.insert(u);

        if(count>0){
            response.sendRedirect("admin_douserselect");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
