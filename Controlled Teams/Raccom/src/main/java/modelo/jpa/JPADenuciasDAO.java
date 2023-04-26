package modelo.jpa;

import modelo.dao.DenunciaDAO;
import modelo.entidad.Denuncia;


import javax.persistence.Query;
import java.util.List;


public class JPADenuciasDAO extends JPAGenericDAO<Denuncia, Integer> implements DenunciaDAO {
    public JPADenuciasDAO() {
        super(Denuncia.class);

    }
    @Override
    public List<Denuncia> leerById(Integer id) {
        return null;
    }

    @Override
    public List<Denuncia> listar() {
        Query query= em.createNamedQuery("listarDenucias",Denuncia.class);
        List<Denuncia> denucias =(List<Denuncia>) query.getResultList();
        if (denucias.size() != 0) {
            return denucias;
        }
        return null;
    }
}
