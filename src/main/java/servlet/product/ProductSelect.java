package servlet.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.LMONKEY_CATEGORY;
import entity.LMONKEY_PRODUCT;
import service.LMONKEY_CATEGORYDao;
import service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class ProDuctSelect
 */
@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<LMONKEY_PRODUCT> plist= LMONKEY_PRODUCTDao.selectAll();

        request.setAttribute("plist", plist);


        request.getRequestDispatcher("admin_product.jsp").forward(request, response);

    }



}

