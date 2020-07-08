package svr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RuoloDao;

/**
 * Servlet implementation class RuoloSrv
 */
@WebServlet("/RuoloSrv")
public class RuoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
      RuoloDao r = new RuoloDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RuoloSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op=request.getParameter("op");
		switch (op) {
		case "i": {
			
			boolean temp =insert(request.getParameter("descrizione"));
			request.getRequestDispatcher("./ruolo/insertRuoloV.jsp?verifica="+temp).forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public boolean insert(String descrizione) {
		return r.insert(descrizione);
	}
}
