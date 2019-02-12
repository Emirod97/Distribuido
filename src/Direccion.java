import javax.xml.bind.annotation.*;

@XmlRootElement (name="Direccion")
public class Direccion
{
    private String calle, no, colonia, ciudad;

    public Direccion() {
    }

    
    
    public Direccion(String calle, String no, String colonia, String ciudad) {
        this.calle = calle;
        this.no = no;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    @XmlElement (name="Calle")
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    @XmlElement (name="Numero")
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    @XmlElement (name="Colonia")
    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    @XmlElement (name="Ciudad")
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    

}
