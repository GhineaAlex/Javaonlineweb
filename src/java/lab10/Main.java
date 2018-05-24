
package lab10;

import Crud.CrudHDD;
import Crud.CrudMemorie;
import Crud.CrudPlacadebaza;
import Crud.CrudProcesor;
import Crud.CrudSursa;
import implementari.HDD;
import implementari.Memorie;
import implementari.Placadebaza;
import implementari.Procesor;
import implementari.Sursa;
import java.sql.*;
import servlets.AddComponenta;
import servlets.ComponentaServlet;


/**
 *
 * @author Iulian Tofan
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        CrudSursa CrudSursa = new CrudSursa();
//        CrudSursa.readAllSursa().forEach(e -> System.out.println(e));
//        Sursa h = CrudSursa.readAllSursa().get(0);
//        CrudSursa.readAllSursa().forEach(e -> System.out.println(e));
//        CrudSursa.readAllSursa().forEach(e -> System.out.println(e));
//        h.setPret(4055);
//        h.setMarca("HASHAHASHSA");
//        CrudSursa.update(h);
//        CrudSursa.readAllSursa().forEach(e -> System.out.println(e));
//                h.setPret(1225.0);
//        CrudSursa.insert(h);
//        CrudSursa.readAllSursa().forEach(e -> System.out.println(e));
//        System.out.println(CrudSursa.readById(1));
//        CrudSursa.deleteById(3);
//        CrudSursa.readAllSursa().forEach(e -> System.out.println(e));

//        Memorie h = new Memorie();
//       h.setCodProdus(20);
//       CrudMemorie hdd = new CrudMemorie();
//       //crudMemorie.updateScadStoc(h);
//       hdd.updateAddStoc(h);
//       
//       Placadebaza h = new Placadebaza();
//       h.setCodProdus(30);
//       CrudPlacadebaza hdd = new CrudPlacadebaza();
//       //crudMemorie.updateScadStoc(h);
//       hdd.updateAddStoc(h);
       
        Sursa h = new Sursa();
       h.setCodProdus(423);
       CrudSursa hdd = new CrudSursa();
       hdd.updateScadStoc(h);
       //hdd.updateAddStoc(h);

          //      Procesor h = new Procesor();
//       h.setCodProdus(20);
//       CrudProcesor hdd = new CrudProcesor();
//       //hdd.updateScadStoc(h);
//       hdd.updateAddStoc(h);

       System.out.println(ComponentaServlet.selectOption);
        
        
        //am facut teste pentru fiecare crud in parte, toate functiile merg
        //
    }
}