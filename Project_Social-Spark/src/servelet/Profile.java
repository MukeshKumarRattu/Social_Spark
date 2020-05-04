package servelet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.FriendDBUtil;
import db.PostDBUtil;
import model.Post;
import model.User;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Profile() {
      
    }
    
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private PostDBUtil postdb;
    private FriendDBUtil friendb;
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try{
			postdb = new PostDBUtil(datasource);
			friendb = new FriendDBUtil(datasource);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		ArrayList<Post> alluserPosts = new ArrayList<>();
		
		try {
			 alluserPosts = postdb.getAllUserPosts(user.getEmail());
			 request.setAttribute("allUserPosts", alluserPosts);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		ArrayList<User> allUserFriends = new ArrayList<>();
		
		try {
			allUserFriends = friendb.getAllUserFriends(user.getEmail());
			 request.setAttribute("allUserFriends", allUserFriends);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}