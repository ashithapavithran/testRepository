package connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import connection.FetchDistrict;
import connection.User;
/**
 * Servlet implementation class PopulateDistrict
 */
public class PopulateDistrict extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PopulateDistrict() {
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
		user=FetchDistrict.getAllUser(adviseType);
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
