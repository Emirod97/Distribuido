import javax.xml.bind.Element;
import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "Curriculo")
public class Curriculo
{


    private String nombre;


    private String telefono;


    private String correoE;


    private String photo;


    private String lugarNacimiento;


    private Direccion Direccion;


    private List<Empleo> Empleos;

    private Email Email;

    public Curriculo() {

    }

    
    
    public Curriculo(String n, String t, Email c, String p, String l, Direccion Direccion, List<Empleo> Empleos) {
        this.nombre = n;
        this.telefono = t;
        this.Email = c;
        this.photo = p;
        this.lugarNacimiento = l;
        this.Direccion = Direccion;
        this.Empleos = Empleos;
    }

    @XmlElement(name = "Nombre", required = true)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "Telefono", required = true)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlElement(name = "Email", required = true)
    public Email getEmail() {
        return Email;
    }

    public void setEmail(Email email) {
        Email = email;
    }



    @XmlElement(name = "Foto")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlElement(name = "Nacimiento", required = true)
    public String getLugarNacimiento() {
        return lugarNacimiento;
    }


    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    @XmlElement(name = "Direccion", required = true)
    public Direccion getDireccion() {
        return Direccion;
    }

    public void setDireccion(Direccion Direccion) {
        this.Direccion = Direccion;
    }

    @XmlElementWrapper(name = "Empleos")
    @XmlElement(name = "Empleo")
    public List<Empleo> getEmpleos() {
        return Empleos;
    }

    public void setEmpleos(List<Empleo> Empleos) {
        this.Empleos = Empleos;
    }

}
