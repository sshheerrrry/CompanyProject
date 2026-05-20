package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Chat;

import java.io.IOException;

import dao.impl.ChatDaoImpl;


@WebServlet("/AddChatController")
public class AddChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddChatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("name");
		String Subject=request.getParameter("subject");
		String Content=request.getParameter("content");
		
		Chat chat=new Chat(Name,Subject,Content);
		
		
		new ChatDaoImpl().addChat(chat);
		
		
		response.sendRedirect("index.jsp");
	}

}
