package controlador;

import modelo.dao.DAOFactory;
import modelo.entidad.Administrador;
import modelo.entidad.Usuario;
import modelo.jpa.JPAFactory;
import modelo.security.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/registrarUsuarioController")
public class registrarUsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        procesarSolicitud(request, response);
    }
    private void procesarSolicitud(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String codigoUnico = req.getParameter("codigoUnico");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rol = req.getParameter("rol");
        DAOFactory fabrica = new JPAFactory();

        validar(req);


        if(Validaciones.validadorCodUnico(codigoUnico)
                && Validaciones.validadorCorreo(email)
                && Validaciones.validadorStrings(nombre)
                && Validaciones.validadorStrings(apellido)
                &&password.length()>=4) {
            if (rol.equals("administrador")) {
                Administrador administradorConsutado = (Administrador) fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).leer(codigoUnico);
                Usuario usuarioConsutado = (Usuario) fabrica.crearUsuarioDAO(JPAFactory.USUARIO).leer(codigoUnico);
                if (administradorConsutado == null && usuarioConsutado == null ) {
                    HashPassword hash = new HashPassword();
                    String salt = HashPassword.getSalt();
                    String saltedPasswd = hash.valorHash(password + salt);
                    Administrador administrador = new Administrador(codigoUnico, nombre, apellido, saltedPasswd, email);
                    administrador.setSal(salt);
                    fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).crear(administrador);
                    req.setAttribute("ok", "Administrador registrado con éxito");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {

                    req.setAttribute("mensajeError", "Código Único ya registrado");//mensaje
                    redireccionFallo(req, resp, codigoUnico, nombre, apellido, email, password, rol);
                }

            } else if (rol.equals("usuario")) {
                Administrador administradorConsutado = (Administrador) fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).leer(codigoUnico);
                Usuario usuarioConsutado = (Usuario) fabrica.crearUsuarioDAO(JPAFactory.USUARIO).leer(codigoUnico);
                if (administradorConsutado == null && usuarioConsutado == null) {
                    HashPassword hash = new HashPassword();
                    String salt = HashPassword.getSalt();
                    String saltedPasswd = hash.valorHash(password + salt);
                    Usuario usuario = new Usuario(codigoUnico, nombre, apellido, saltedPasswd, email);
                    usuario.setSal(salt);
                    fabrica.crearUsuarioDAO(JPAFactory.ADMINISTRADOR).crear(usuario);
                    req.setAttribute("ok", "Usuario registrado con éxito");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {

                    req.setAttribute("mensajeError", "Código Único ya registrado");//mensaje
                    redireccionFallo(req, resp, codigoUnico, nombre, apellido, email, password, rol);
                }
            }

        }else{

            redireccionFallo(req, resp, codigoUnico, nombre, apellido, email, password, rol);
        }

    }

    private void validar(HttpServletRequest req) {
        String codigoUnico = req.getParameter("codigoUnico");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rol = req.getParameter("rol");

        if(Validaciones.validadorCodUnico(codigoUnico)==false){
            req.setAttribute("mensajeError", "Código Único no valido ");
        }
        if(Validaciones.validadorStrings(nombre)==false){
            req.setAttribute("mensajeErrorNombre", "El nombre solo puede tener letras");

        }
        if(Validaciones.validadorStrings(apellido)==false){
            req.setAttribute("mensajeErrorApellido", "El apellido solo puede tener letras");

        }
        if(Validaciones.validadorCorreo(email)==false){
            req.setAttribute("mensajeErrorMail", "El correo electrónico no es valido");

        }
        if(password.length()<4){
            req.setAttribute("mensajeErrorPass", "La contraseña debe tener al menos 4 caracteres");

        }
    }

    private void redireccionFallo(HttpServletRequest req, HttpServletResponse resp, String codigoUnico, String nombre, String apellido, String email, String password, String rol) throws ServletException, IOException {
        req.setAttribute("codigoUnico", codigoUnico);
        req.setAttribute("nombre", nombre);
        req.setAttribute("apellido", apellido);
        req.setAttribute("email", email);
        req.setAttribute("password", password);
        req.setAttribute("rol", rol);
        getServletContext().getRequestDispatcher("/registroUsuario.jsp").forward(req, resp);
    }
}
