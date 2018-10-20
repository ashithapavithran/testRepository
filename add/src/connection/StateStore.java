package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StateStore
 */
public class StateStore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateStore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PrintWriter out = response.getWriter();  
		response.setContentType("text/html");
	
		String scode= request.getParameter("state_name");
		
		String add_state= request.getParameter("add_state");
	
		java.util.Date date= new java.util.Date();
Timestamp timestamp = new Timestamp(date.getTime());
Calendar calendar = Calendar.getInstance();
java.sql.Date o = new java.sql.Date(calendar.getTime().getTime());
		try {
			 Database db = new Database();
		   conn = db.getConnection();
		Statement st = conn.createStatement();
		String sql = "INSERT INTO mas_state VALUES ((SELECT max(scode)+1 as scode FROM mas_state),'"+add_state+"')";
		
		st.executeUpdate(sql);
		conn.close();
		 
	     }catch(Exception ex){
	       
	    	 out.println("<script type=\"text/javascript\">");
	         out.println("if(confirm('Please enter valid data')){location='main.jsp'}");
	         out.println("</script>");
	        
	     }finally{
	          
	          out.println("<script type=\"text/javascript\">");
	          out.println("if(confirm('Data inserted successfully')){location='main.jsp'}");
	          out.println("</script>");
	      
	     }
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	}
		