package com.javaex.guestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestDao;

import com.javaex.vo.GuestVo;


@WebServlet("/gcr")
public class GuestController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String action = request.getParameter("action");
				System.out.println(action);
				
				if("list".equals(action)){
					System.out.println("리스트 처리");
					GuestDao gDao = new GuestDao();
					List<GuestVo> gList= gDao.getList();

					request.setAttribute("gList",gList);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addList.jsp"); //jsp파일 위치를 알려줌
					rd.forward(request, response);
				}else if ("add".equals(action)) {
					System.out.println("등록폼 처리");
					request.setCharacterEncoding("utf-8");
					String name = request.getParameter("name");
					String password = request.getParameter("password");
					String content = request.getParameter("content");
						
					GuestVo guVo =new GuestVo(name,password,content);

					GuestDao guDao = new GuestDao();
					guDao.guestinsert(guVo);
					response.sendRedirect("/guestbook2/gcr?action=list");
				}else if ("delete".equals(action)) {
					RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/deleteForm.jsp");
					rd.forward(request, response);
				}else if ("delete1".equals(action)) {
					int Id=Integer.parseInt(request.getParameter("Id"));
					String password = request.getParameter("password");
					GuestVo guestVo = new GuestVo(Id,password);
					GuestDao guestDao = new GuestDao();		
					guestDao.guestdelete(guestVo);
					response.sendRedirect("/guestbook2/gcr?action=list");
				}
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
