package servelet;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import db.PostDBUtil;
import model.User;


@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	
    public CreatePost() {
       
    }

    @Resource(name="jdbc/social")
    private DataSource datasource;
    private PostDBUtil postdb;
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			postdb = new PostDBUtil(datasource);			
		
		}catch(Exception ex) {
			
			throw new ServletException(ex);
		
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		String content = request.getParameter("content");
		String image = request.getParameter("image");
		
		Boolean created =  user.createPost(content,image,postdb);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		
		if(created) {
			
			request.setAttribute("created", true);
			//request.removeAttribute(image);
			//request.removeAttribute(content);
			
			
		}else {
			request.setAttribute("notcreated", true);
			//request.removeAttribute(image);
			//request.removeAttribute(content);
		}
		
		dispatcher.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
