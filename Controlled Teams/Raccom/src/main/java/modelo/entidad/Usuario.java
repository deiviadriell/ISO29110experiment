package modelo.entidad;
import javax.persistence.*;
import java.io.Serializable;

@Entity


public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codUnico")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codUnico;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "correoElectronico")
    private String correoElectronico;

    @Column(name = "salt")
    private String sal;

    public Usuario(){}

    public Usuario(String codUnico, String nombre, String apellido, String contrasenia, String correoElectronico) {
        this.codUnico = codUnico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCodUnico() {
        return codUnico;
    }

    public void setCodUnico(String codUnico) {
        this.codUnico = codUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
        result = prime * result + ((codUnico == null) ? 0 : codUnico.hashCode());
        result = prime * result + ((contrasenia == null) ? 0 : contrasenia.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((correoElectronico == null) ? 0 : correoElectronico.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario usuario = (Usuario) obj;
            return usuario.getCodUnico().equals(this.codUnico);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario [codUnico=" + codUnico + ", nombre=" + nombre + " apellido="
                + apellido + ", correoElectronico=" + correoElectronico+"]";
    }
}
