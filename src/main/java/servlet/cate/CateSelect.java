package servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.LMONKEY_CATEGORY;
import service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class CateSelect
 */
@WebServlet("/manage/admin_cateselect")
public class CateSelect extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        ArrayList<LMONKEY_CATEGORY> catelist = LMONKEY_CATEGORYDao.selectAll();

        request.setAttribute("catelist", catelist);
        request.getRequestDispatcher("/manage/admin_cate.jsp").forward(request, response);






    }


}
