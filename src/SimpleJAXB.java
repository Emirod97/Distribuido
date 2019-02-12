import javax.xml.bind.*;
import java.io.*;

public class SimpleJAXB {

    public void marshall(){
        try{
            Direccion dir= new Direccion("Roma","585","Moderna","Ensenada");

            JAXBContext jc = JAXBContext.newInstance(Direccion.class);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
