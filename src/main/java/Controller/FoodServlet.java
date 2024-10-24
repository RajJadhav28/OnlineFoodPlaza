package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Impl.FoodDaoImpl;
import POJO.Food;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private String foodName;
	private String foodType;
	private String foodCategory;
	private String foodDesc;
	private double foodPrice;
	private String image;
	Food f=null;
	List list=null;
	
	FoodDaoImpl fdimpl=new FoodDaoImpl();
	boolean flag;
	RequestDispatcher rd=null;
	String msg, errmsg;
	HttpSession session=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		String process=request.getParameter("process");
		if(process!=null && process.equals("allFood")) {
			list=fdimpl.getAllFood();
			session.setAttribute("flist", list);
			response.sendRedirect("FoodList.jsp");
			
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String process=request.getParameter("process");
		session=request.getSession();
		if(process!=null && process.equals("addFood")){
			
			foodName=request.getParameter("foodName");
			foodType=request.getParameter("foodType");
			foodCategory=request.getParameter("foodCategory");
			 foodDesc=request.getParameter("foodDesc");
			 foodPrice=Double.parseDouble(request.getParameter("foodPrice"));
			 image=request.getParameter("image");
			 
			 f=new Food();
			 f.setFoodName(foodName);
			 f.setFoodType(foodType);
			 f.setFoodCategory(foodCategory);
			 f.setFoodDesc(foodDesc);
			 f.setFoodPrice(foodPrice);
			 f.setImage(image);
			 
			flag= fdimpl.addFood(f);
			if(flag) {
				msg="Recored added successfully";
				request.setAttribute("msg", msg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
				
				
			}else {
				errmsg="Recored not added";
				request.setAttribute("errmsg", errmsg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
			}
			 
			 
		}
	}

}
