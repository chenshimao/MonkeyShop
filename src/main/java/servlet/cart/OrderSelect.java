package servlet.cart;

import entity.LMONKEY_CART;
import entity.LMONKEY_USER;
import service.LMONKEY_CARTDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "OrderSelect", value = "/orderselect")
public class OrderSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String isLogin = (String) session.getAttribute("isLogin");
        LMONKEY_USER user = (LMONKEY_USER) session.getAttribute("user");
        String eids = request.getParameter("eids");
        System.out.println(eids);

        if(user!=null && isLogin.equals("1")){
            String ids[] = eids.split(",");
            ArrayList<LMONKEY_CART> list= new ArrayList<>();
            int totalprice = 0;

            for (int i = 0; i < ids.length; i++) {
                LMONKEY_CART es = LMONKEY_CARTDao.getCartShop(ids[i]);
                list.add(es);
                int dprice = es.getCart_p_price() * es.getCart_quantity();
                totalprice += dprice;
            }
            request.setAttribute("shoplist",list);
            request.setAttribute("totalprice",totalprice);
            request.getRequestDispatcher("order.jsp").forward(request,response);
        }
        else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alter('请登入后再买')");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
