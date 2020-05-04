package servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Post;
import model.User;

@WebServlet("/FriendOperation")
public class FriendOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FriendOperation() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		ArrayList<User> allFriends = new ArrayList<>();
		
//		try {
//			 allFriends = userdb.getUserFriends();
//			 request.setAttribute("allPosts", allPosts);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
