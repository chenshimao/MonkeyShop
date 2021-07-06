package com.lmonkey.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.LMONKEY_PRODUCT;
import entity.LMONKEY_USER;
import service.LMONKEY_PRODUCTDao;
import service.LMONKEY_USERDao;

/**
 * Servlet implementation class DoProductUpdate
 */
@WebServlet("/manage/admin_doproductupdate")
public class DoProductUpdate extends HttpServlet {


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html charset=utf-8");
//
//		String name=request.getParameter("productName");
//		String photo=request.getParameter("photo");
//		int price=Integer.parseInt(request.getParameter("productPrice"));
//		String desc=request.getParameter("productDesc");
//		int stock=Integer.parseInt(request.getParameter("productStock"));
//
//
//	  PrintWriter pw=response.getWriter(); 			//连接数据库
//		//创建用户实体
//		LMONKEY_PRODUCT product=new LMONKEY_PRODUCT(name, photo, price, desc, stock);
//
//
//		int count = LMONKEY_PRODUCTDao.update(product);
//		//System.out.print(u);
//		//成功或失败的去向
//		if(count > 0) {
//			response.sendRedirect("/shop/manage/admin_douserselect?cp="+request.getParameter("cpage"));
//
//		}else {
//			PrintWriter out = response.getWriter();
//			out.write("<script>");
//			out.write("alter('用户登录失败')");
//			out.write("location.href='manage/admin_touserupdate");
//			out.write("</script>");
//
//	}
//
//
//	}
 }
