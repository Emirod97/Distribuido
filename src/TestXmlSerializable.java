import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import javax.xml.bind.*;


public class TestXmlSerializable{

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String nombre, telefono, correoE, photo, lugarNacimiento; // Curriculo

        String calle, no, colonia, ciudad;  // Direccion

        String nombreEmpresa = null; //Empleo
        Date fInicio =null, fTermino=null;

        int ano, mes, dia;  //Calendario



        Curriculo nCurriculo;
        Direccion nDireccion;
        List<Empleo> nEmpleo = new ArrayList<Empleo>();
        Email nEmail;
        GregorianCalendar calendarioI, calendarioT;



        System.out.println("Ingresar Datos para su CV \n");
        System.out.print("Nombre -->");
        nombre = input.nextLine();
        System.out.println("");
        System.out.print("Telefono -->");
        telefono = input.nextLine();
        System.out.println("");
        System.out.print("Correo Electronico -->");
        correoE = input.nextLine();

        nEmail = new Email(correoE, AtibutoEmail.PERSONAL);

        System.out.println("");
        System.out.print("Foto -->");
        photo = input.nextLine();
        System.out.println("");
        System.out.print("Lugar de Nacimiento -->");
        lugarNacimiento = input.nextLine();
        System.out.println("");

        System.out.println("Informcaion de su domicilio");
        System.out.print("Calle -->");
        calle = input.nextLine();
        System.out.println("");
        System.out.print("Numero de casa -->");
        no = input.nextLine();
        System.out.println("");
        System.out.print("Colonia -->");
        colonia = input.nextLine();
        System.out.println("");
        System.out.print("Ciudad -->");
        ciudad = input.nextLine();
        System.out.println("");



        nDireccion = new Direccion(calle, no, colonia, ciudad);



        System.out.println("Informacion Laboral");
        System.out.print("No. de trabajos anteriores -->");
        int n = input.nextInt();



        for(int i=1; i<=n; i++){

            System.out.println("\nEmpleo No. "+i);
            System.out.println("Fecha de inicio:");
            System.out.print("\nDia -->");
            dia= input.nextInt();
            System.out.print("\nMes -->");
            mes= input.nextInt();
            System.out.print("\nAno -->");
            ano= input.nextInt();

            calendarioI = new GregorianCalendar(ano, mes-1, dia);

            fInicio = calendarioI.getTime();

            System.out.println("/nFecha de Termino:");
            System.out.print("\nDia -->");
            dia= input.nextInt();
            System.out.print("\nMes -->");
            mes= input.nextInt();
            System.out.print("\nAño -->");
            ano= input.nextInt();

            calendarioT = new GregorianCalendar(ano, mes-1, dia);

            fTermino = calendarioT.getTime();

            System.out.print("\nNombre de la Emrpesa -->" );
            nombreEmpresa=input.nextLine();
            nombreEmpresa=input.nextLine();


            nEmpleo.add(new Empleo(fInicio, fTermino, nombreEmpresa));




        }

         nCurriculo = new Curriculo(nombre, telefono, nEmail, photo, lugarNacimiento, nDireccion, nEmpleo);


         /*
        try{
            FileOutputStream archivoXML = new FileOutputStream(new File("./archivoXML.xml"));
            XMLEncoder encoder = new XMLEncoder(archivoXML);
            encoder.writeObject(nCurriculo);
            encoder.close();
            archivoXML.close();
        }
        catch(IOException ex){
           //ex.printStackTrace();
        }

                 */





        try {


            JAXBContext jc = JAXBContext.newInstance(Curriculo.class);

            Marshaller ms = jc.createMarshaller();

            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            ms.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
                    "\n<!DOCTYPE Curriculo SYSTEM "+"'DTD_Curriculo.dtd'"+" >");

            ms.marshal(nCurriculo, new File("./XmlData.xml"));



        } catch (Exception e) {
            System.out.println(e);
        }




    }

}
