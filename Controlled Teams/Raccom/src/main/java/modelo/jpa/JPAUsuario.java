package modelo.jpa;

import modelo.dao.UsuarioDAO;
import modelo.entidad.Usuario;
import modelo.security.HashPassword;

import javax.persistence.Query;
import java.util.List;

public class JPAUsuario extends JPAGenericDAO<Usuario, String> implements UsuarioDAO<Usuario, String> {
    public JPAUsuario() {
        super(Usuario.class);

    }
    @Override
    public Usuario autorizar(String codUnico, String contraseña ) {
        Usuario usuarioEntidad = this.leer(codUnico);
        if (usuarioEntidad != null) {
            HashPassword hash = new HashPassword();
            String saltedPassword = hash.valorHash(contraseña+usuarioEntidad.getSal());
            if (usuarioEntidad.getContrasenia().equals(saltedPassword))
                return usuarioEntidad;
        }
        return null;

    }

    @Override
    public List<Usuario> listar() {
        return null;
    }
}
