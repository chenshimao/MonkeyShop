package ervlet.cate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.LMONKEY_CATEGORY;
import service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class DoCateUpdate
 */
@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html charset=utf-8");


        int id=Integer.parseInt(request.getParameter("id"));
        int fid=Integer.parseInt(request.getParameter("parentId"));
        String name=request.getParameter("className");

        LMONKEY_CATEGORY cate= new LMONKEY_CATEGORY(id, name, fid);
        LMONKEY_CATEGORYDao.update(cate);
        response.sendRedirect("admin_cateselect");


    }

}
