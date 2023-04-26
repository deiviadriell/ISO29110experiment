package modelo.dao;

import modelo.entidad.Denuncia;

import java.util.List;

public interface DenunciaDAO extends GenericDAO<Denuncia,Integer> {
    public List<Denuncia> leerById(Integer id);
}
