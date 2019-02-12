import java.util.*;

public class Empleo 
{
    private Date fInicio = null, fTermino = null;
    private String nombreEmpresa = null;

    public Empleo() {
    }
    
    
    public Empleo(Date fInicio, Date fTermino, String nombreEmpresa) {
        
        this.fInicio = fInicio;
        this.fTermino = fTermino;
        this.nombreEmpresa = nombreEmpresa;

        
        
    }
    
    public Date getfInicio() {
        return fInicio;
    }

    public void setfInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public Date getfTermino() {
        return fTermino;
    }

    public void setfTermino(Date fTermino) {
        this.fTermino = fTermino;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }


    


}
