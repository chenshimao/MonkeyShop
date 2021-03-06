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
 * Servlet implementation class ToCateAdd
 */
@WebServlet("/manage/tocateadd")
public class ToCateAdd extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<LMONKEY_CATEGORY> catelist = LMONKEY_CATEGORYDao.selectAll();

        request.setAttribute("catelist", catelist);
        request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);

    }


}
