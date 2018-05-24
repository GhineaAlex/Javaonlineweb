package implementari;

import Crud.CrudHDD;
import Crud.CrudMemorie;
import Crud.CrudPlacadebaza;
import Crud.CrudProcesor;
import Crud.CrudSursa;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Iuliana
 */
public class IOUtils {

    public static ArrayList<HDD> readHDD() throws SQLException, ClassNotFoundException { //serializez liste
        ArrayList<HDD> hdd = new ArrayList<>();
        CrudHDD crudHDD = new CrudHDD();
        hdd = crudHDD.readAllHDD();
        return hdd;
    }

    public static void addHDD(HDD hdd) throws IOException, SQLException, ClassNotFoundException {
        CrudHDD crudHDD = new CrudHDD();
        crudHDD.insert(hdd);
    }

    public static void deleteHDD(HDD hdd) throws SQLException, ClassNotFoundException {
        CrudHDD crudHDD = new CrudHDD();
        crudHDD.deleteById(hdd.getCodProdus());
    }

    public static void updateAddStocHDD(HDD hdd) throws SQLException, ClassNotFoundException {
        CrudHDD crudHDD = new CrudHDD();
        crudHDD.updateAddStoc(hdd);
    }

    public static void updateScadStocHDD(HDD hdd) throws SQLException, ClassNotFoundException {
        CrudHDD crudHDD = new CrudHDD();
        crudHDD.updateScadStoc(hdd);
    }

    public static ArrayList<Memorie> readMemorie() throws SQLException, ClassNotFoundException { //serializez liste
        ArrayList<Memorie> mem = new ArrayList<>();
        CrudMemorie crudMemorie = new CrudMemorie();
        mem = crudMemorie.readAllMemorie();
        return mem;
    }

    public static void addMemorie(Memorie mem) throws IOException, SQLException, ClassNotFoundException {
        ArrayList<Memorie> m = readMemorie();
        CrudMemorie crudMemorie = new CrudMemorie();
        crudMemorie.insert(mem);
    }

    public static void deleteMemorie(Memorie mem) throws SQLException, ClassNotFoundException {
        CrudMemorie crudMemorie = new CrudMemorie();
        crudMemorie.deleteById(mem.getCodProdus());
    }

    public static void updateAddStocMemorie(Memorie mem) throws SQLException, ClassNotFoundException {
        CrudMemorie crudMemorie = new CrudMemorie();
        crudMemorie.updateAddStoc(mem);
    }

    public static void updateScadStocMemorie(Memorie mem) throws SQLException, ClassNotFoundException {
        CrudMemorie crudMemorie = new CrudMemorie();
        crudMemorie.updateScadStoc(mem);
    }
    

    public static ArrayList<Placadebaza> readPlacadebaza() throws SQLException, ClassNotFoundException { //serializez liste
        ArrayList<Placadebaza> pb = new ArrayList<>();
        CrudPlacadebaza crudPlacadebaza = new CrudPlacadebaza();
        pb = crudPlacadebaza.readAllPlacadebaza();
        return pb;
    }

    public static void addPlacadebaza(Placadebaza pb) throws IOException, SQLException, ClassNotFoundException {
        ArrayList<Placadebaza> p = readPlacadebaza();
        CrudPlacadebaza crudPlacadebaza = new CrudPlacadebaza();
        crudPlacadebaza.insert(pb);
    }

    public static void deletePlacadebaza(Placadebaza pb) throws SQLException, ClassNotFoundException {
        CrudPlacadebaza crudPlacadebaza = new CrudPlacadebaza();
        crudPlacadebaza.deleteById(pb.getCodProdus());
    }

    public static void updateAddStocPlacadebaza(Placadebaza pb) throws SQLException, ClassNotFoundException {
        CrudPlacadebaza crudPlacadebaza = new CrudPlacadebaza();
        crudPlacadebaza.updateAddStoc(pb);
    }

    public static void updateScadStocPlacadebaza(Placadebaza pb) throws SQLException, ClassNotFoundException {
        CrudPlacadebaza crudPlacadebaza = new CrudPlacadebaza();
        crudPlacadebaza.updateScadStoc(pb);
    }
    

    public static ArrayList<Procesor> readProcesor() throws SQLException, ClassNotFoundException { //serializez liste
        ArrayList<Procesor> proc = new ArrayList<>();
        CrudProcesor crudProcesor = new CrudProcesor();
        proc = crudProcesor.readAllProcesor();
        return proc;
    }

    public static void addProcesor(Procesor proc) throws IOException, SQLException, ClassNotFoundException {
        ArrayList<Procesor> p = readProcesor();
        CrudProcesor crudProcesor = new CrudProcesor();
        crudProcesor.insert(proc);
    }

    public static void deleteProcesor(Procesor proc) throws SQLException, ClassNotFoundException {
        CrudProcesor crudProcesor = new CrudProcesor();
        crudProcesor.deleteById(proc.getCodProdus());
    }

    public static void updateAddStocProcesor(Procesor proc) throws SQLException, ClassNotFoundException {
        CrudProcesor crudProcesor = new CrudProcesor();
        crudProcesor.updateAddStoc(proc);
    }

    public static void updateScadStocProcesor(Procesor proc) throws SQLException, ClassNotFoundException {
        CrudProcesor crudProcesor = new CrudProcesor();
        crudProcesor.updateScadStoc(proc);
    
    }

    public static ArrayList<Sursa> readSursa() throws SQLException, ClassNotFoundException { //serializez liste
        ArrayList<Sursa> sursa = new ArrayList<>();
        CrudSursa crudSursa = new CrudSursa();
        sursa = crudSursa.readAllSursa();
        return sursa;
    }

    public static void addSursa(Sursa mem) throws IOException, SQLException, ClassNotFoundException {
        ArrayList<Sursa> m = readSursa();
        CrudSursa crudSursa = new CrudSursa();
        crudSursa.insert(mem);
    }

    public static void deleteSursa(Sursa sursa) throws SQLException, ClassNotFoundException {
        CrudSursa crudSursa = new CrudSursa();
        crudSursa.deleteById(sursa.getCodProdus());
    }

    public static void updateAddStocSursa(Sursa s) throws SQLException, ClassNotFoundException {
        CrudSursa crudSursa = new CrudSursa();
        crudSursa.updateAddStoc(s);
    }

    public static void updateScadStocSursa(Sursa s) throws SQLException, ClassNotFoundException {
        CrudSursa crudSursa = new CrudSursa();
        crudSursa.updateScadStoc(s);
    }
}