package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Administrador;
import modelo.entidad.Usuario;
import modelo.jpa.JPAFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request,response);
    }
    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recordar= req.getParameter("recordarme");
        String codUnico = req.getParameter("codigoUnico");
        String contrasena = req.getParameter("password");
        DAOFactory fabrica = new JPAFactory();
        Administrador administrador = (Administrador) fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).autorizar(codUnico,contrasena);
        Usuario user= (Usuario) fabrica.crearUsuarioDAO(JPAFactory.USUARIO).autorizar(codUnico,contrasena);
        Cookie codigoUnicoCookie = new Cookie("codigoUnico","");
        Cookie passCookie = new Cookie("password","");
        Cookie banderaCookie = new Cookie("recordar","");

        if(recordar != null && recordar.equals("on")){
            codigoUnicoCookie.setValue(codUnico);
            passCookie.setValue(contrasena);
            banderaCookie.setValue(recordar);
        }else{
            codigoUnicoCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
            banderaCookie.setMaxAge(0);
            resp.addCookie(passCookie);
            resp.addCookie(codigoUnicoCookie);
            resp.addCookie(banderaCookie);
        }

        if(administrador != null){
            //Abriendo la sesión
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",codUnico);
            String tipo = "administrador";
            sesion.setAttribute("tipo",tipo);
            //Redireccionando a la jsp
            resp.addCookie(passCookie);
            resp.addCookie(codigoUnicoCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/ControladorListarDenuncias").forward(req,resp);
        }else if(user != null){
            //Abriendo la sesión
            HttpSession sesion = req.getSession();
            sesion.setAttribute("usuario",codUnico);
            String tipo = "usuario";
            sesion.setAttribute("tipo",tipo);
            //Redireccionando a la jsp
            resp.addCookie(passCookie);
            resp.addCookie(codigoUnicoCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/registroDenuncia.jsp").forward(req,resp);
        }else{
            req.setAttribute("err","Codigo único o contraseña inválidos");
            codigoUnicoCookie.setMaxAge(0);
            passCookie.setMaxAge(0);
            banderaCookie.setMaxAge(0);
            resp.addCookie(passCookie);
            resp.addCookie(codigoUnicoCookie);
            resp.addCookie(banderaCookie);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }


    }
}
