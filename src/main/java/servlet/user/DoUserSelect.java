package servlet.user;

import entity.LMONKEY_USER;
import service.LMONKEY_USERDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DoUserSelect", value = "/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int cpage = 1;//当前页
        int count = 5;//每一页显示个数
        //获取用户指定页面
        String cp = request.getParameter("cp");

        //获取查询关键字
        String keyword = request.getParameter("keyword");

        if(cp!=null){
            cpage = Integer.parseInt(cp);
        }

        //获取总数和总页数
        int[] arr = LMONKEY_USERDao.totalPage(count,keyword);
        ArrayList<LMONKEY_USER> list = LMONKEY_USERDao.selectAll(cpage,count,keyword);

        request.setAttribute("userlist",list);
        request.setAttribute("tsum",arr[0]);
        request.setAttribute("tpage",arr[1]);
        request.setAttribute("cpage",cpage);

        if(keyword!=null){
            request.setAttribute("searchParams","&keyword="+keyword);
        }
        request.getRequestDispatcher("/manage/admin_user.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
