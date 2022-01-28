package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/main", "/inserir", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The cadastro. */
	JavaBeans cadastro = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			cadastro(request, response);
		} else if (action.equals("/inserir")) {
			adicionarCadastro(request, response);
		} else if (action.equals("/select")) {
			listarCadastro(request, response);
		} else if (action.equals("/update")) {
			editarCadastro(request, response);
		} else if (action.equals("/delete")) {
			removerCadastro(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Cadastro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarCadastros();

		request.setAttribute("cadastro", lista);
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
	}

	/**
	 * Adicionar cadastro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void adicionarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastro.setNome(request.getParameter("nome"));
		cadastro.setCpf(request.getParameter("cpf"));
		cadastro.setAlimento(request.getParameter("alimento"));
		cadastro.setAlimento2(request.getParameter("alimento2"));

		dao.inserirCadastro(cadastro);

		response.sendRedirect("index.html");
	}

	/**
	 * Listar cadastro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastro.setIdcon(request.getParameter("idcon"));

		dao.selecionarCadastro(cadastro);

		request.setAttribute("idcon", cadastro.getIdcon());
		request.setAttribute("nome", cadastro.getNome());
		request.setAttribute("cpf", cadastro.getCpf());
		request.setAttribute("alimento", cadastro.getAlimento());
		request.setAttribute("alimento2", cadastro.getAlimento2());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar cadastro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastro.setIdcon(request.getParameter("idcon"));
		cadastro.setNome(request.getParameter("nome"));
		cadastro.setCpf(request.getParameter("cpf"));
		cadastro.setAlimento(request.getParameter("alimento"));
		cadastro.setAlimento2(request.getParameter("alimento2"));

		dao.alterarCadastro(cadastro);

		response.sendRedirect("main");
	}

	/**
	 * Remover cadastro.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cadastro.setIdcon(request.getParameter("idcon"));

		dao.deletarCadastro(cadastro);

		response.sendRedirect("main");
	}
}
