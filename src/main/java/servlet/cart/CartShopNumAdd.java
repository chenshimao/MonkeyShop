package servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LMONKEY_CARTDao;

/**
 * Servlet implementation class CartShopNumAdd
 */
@WebServlet("/cartshopnumadd")
public class CartShopNumAdd extends HttpServlet {
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aaaaaaa");
        String count = request.getParameter("count");

        String esid = request.getParameter("esid");
        System.out.println(count +" "+esid);

        LMONKEY_CARTDao.updatenum(Integer.parseInt(esid), Integer.parseInt(count));


    }

}
