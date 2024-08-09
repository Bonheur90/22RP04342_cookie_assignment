

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StoreCookieServlet
 */
@WebServlet("/StoreCookieServlet")
public class StoreCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 // Check for existing cookies
		  String username = "";  
		    Cookie[] cookies = request.getCookies();  
		    
		    if (cookies != null) {  
		        for (Cookie cookie : cookies) {  
		            if ("username".equals(cookie.getName())) {  
		                username = cookie.getValue();  
		                break;  
		            }  
            }
        }

        // Set the username attribute for the JSP page
        request.setAttribute("username", username);
        request.getRequestDispatcher("INDEX.jsp").forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
        String username = request.getParameter("username");

        // Create a cookie to store the username or email
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(cookie);

        // Redirect back to the main page
        response.sendRedirect("INDEX.html");
    }
	}


