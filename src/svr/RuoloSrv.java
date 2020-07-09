package svr;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RuoloDao;
import model.Ruolo;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String op = request.getParameter("op");
		System.out.println(op);
		switch (op) {
		case "i": {

			boolean temp = insertSrv(request.getParameter("descrizione"));
			request.getRequestDispatcher("/verifica.jsp?verifica=" + temp).forward(request, response);
			break;
		}
		case "l": {
			request.getSession().setAttribute("listRuoli",  getAllSrv());
			System.out.println("arriva l");
			request.getRequestDispatcher("/ruolo/list.jsp").forward(request, response);
			break;
		}
		case "u": {
			
			System.out.println(request.getParameter("id"));
			request.getSession().setAttribute("ruolo",  updateSrv(Integer.parseInt(request.getParameter("id")), request.getParameter("descrizione")));
			
			request.getRequestDispatcher("/RuoloSrv?op=l").forward(request, response);
			break;
		}
		case "d": {

			boolean temp = deleteSrv(Integer.parseInt(request.getParameter("id")));
			request.getRequestDispatcher("/verifica.jsp?verifica=" + temp).forward(request, response);
			break;
		}
		case "g": {

			request.getSession().setAttribute("getRuolo", getByIdSrv(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("/ruolo/update.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public boolean insertSrv(String descrizione) {
		return r.insert(descrizione);
	}
	
	public Optional<Ruolo> getByIdSrv(int id) {
		return r.getbyId(id);
	}
	
	public List<Ruolo> getAllSrv() {
		return r.getAll();
	}
	
	public boolean deleteSrv(int id) {
		return r.delete(id);
	}
	
	public Optional<Ruolo> updateSrv(int id, String desc) {
		return r.update(id, desc);
	}
	
	
}
