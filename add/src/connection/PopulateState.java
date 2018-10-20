package connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.FetchState;
import connection.User;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class PopulateState
 */
public class PopulateState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateState() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adviseType = request.getParameter("adviseType");
		String adviseType1 = request.getParameter("adviseType1");
		
		ArrayList<User> user=new ArrayList<User>();
		user=FetchState.getAllUser(adviseType,adviseType1);
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(user, new TypeToken<List<User>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
