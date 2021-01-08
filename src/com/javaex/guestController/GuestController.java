package com.javaex.guestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.IBinaryNestedType;

import com.javaex.dao.GuestDao;

import com.javaex.vo.GuestVo;


@WebServlet("/gcr")
public class GuestController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String action = request.getParameter("action");
				System.out.println(action);
				
				if("list".equals(action)){
					//System.out.println("리스트 처리");
					GuestDao gDao = new GuestDao();
					List<GuestVo> gList= gDao.getList();

					request.setAttribute("gList",gList);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/addList.jsp"); //jsp파일 위치를 알려줌
					rd.forward(request, response);
				}else if ("add".equals(action)) {
					//System.out.println("등록폼 처리");
					request.setCharacterEncoding("utf-8");
					String name = request.getParameter("name");
					String password = request.getParameter("password");
					String content = request.getParameter("content");
						
					GuestVo guVo =new GuestVo(name,password,content);

					GuestDao guDao = new GuestDao();
					guDao.guestinsert(guVo);
					response.sendRedirect("/guestbook2/gcr?action=list");
				}else if ("delete".equals(action)) {
					//System.out.println("삭제");
					RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/deleteForm.jsp");
					rd.forward(request, response);
				}else if ("delete1".equals(action)) {
					response.setContentType("text/html;charset=utf-8");
					int no=Integer.parseInt(request.getParameter("no"));
					String password = request.getParameter("password");
					GuestVo guestVo = new GuestVo(no,password);
					GuestDao guestDao = new GuestDao();		
					int er=guestDao.guestdelete(guestVo);
					if(er==1) {
					response.sendRedirect("/guestbook2/gcr?action=list");
					}else if (er==0){
						RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/passerror.jsp");
						rd.forward(request, response);
					}
				}
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
