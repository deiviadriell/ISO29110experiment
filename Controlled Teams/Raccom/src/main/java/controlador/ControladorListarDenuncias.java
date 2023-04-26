package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Denuncia;
import modelo.jpa.JPAFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/ControladorListarDenuncias")
public class ControladorListarDenuncias extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOFactory fabrica = new JPAFactory();

        List<Denuncia> denuncias = fabrica.crearDenuciaDAO().listar();

        req.setAttribute("listaDenuncias",denuncias);
        getServletContext().getRequestDispatcher("/visualizarDenuncia.jsp").forward(req,resp);
    }
}
