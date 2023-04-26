package modelo.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQuery(name = "listarDenucias",query = "SELECT e FROM Denuncia e")
public class Denuncia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fecha")
    private Date fecha;



    public Denuncia(){

    }
    public Denuncia(String descripcion,String tipo,Date fecha){
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.estado = "Registrada";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idDenuncia) {
        this.id = idDenuncia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (((descripcion) == null) ? 0 : descripcion.hashCode());
        result = prime * result + (((estado) == null) ? 0 : estado.hashCode());
        result = prime * result + (((tipo) == null) ? 0 : tipo.hashCode());
        result = prime * result + (((fecha) == null) ? 0 : fecha.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Denuncia){
            Denuncia denuncia = (Denuncia) obj;
            return denuncia.getId().equals(this.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Denuncia [id= " + this.id +
                ", denuncia=" + this.descripcion +
                ", estado=" + this.estado +
                ", tipo=" + this.tipo +
                ", fecha=" + this.fecha +
                "]";
    }
}
