package modelo.dao;

public interface UsuarioDAO<T,ID> extends GenericDAO<T, ID> {
    public T autorizar(ID identificacion , String contrasenia);
}
