package Crud;

import implementari.HDD;
import implementari.Memorie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CrudMemorie extends Crud {

    public CrudMemorie() throws SQLException, ClassNotFoundException {
        super();
    }
    private final static String SELECT = "SELECT * FROM componentadb.memorie;";
    private final String UPDATE = "UPDATE `componentadb`.`memorie`\n"
            + "SET\n"
            + "codProdus = ?,\n"
            + "pret = ?,\n"
            + "marca = ?,\n"
            + "anFabricatie = ?,\n"
            + "garantie = ?,\n"
            + "producator = ?,\n"
            + "taraProvenienta = ?\n"
            + "stoc = ?\n"
            + "WHERE codProdus = ?;";
    private final String INSERT = "INSERT INTO `componentadb`.`memorie`\n"
            + "(`pret`,\n"
            + "`marca`,\n"
            + "`anFabricatie`,\n"
            + "`garantie`,\n"
            + "`producator`,\n"
            + "`taraProvenienta`, \n"
            + "`stoc`) \n"
            + "VALUES\n"
            + "(?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?,\n"
            + "?);";
    private final String SELECT_BY_ID = "select * from componentadb.memorie where `codProdus` = ?;";

    private final String DELETE_BY_ID = "delete from `componentadb`.`memorie` where `codProdus` = ?;";

    private final String UPDATE_ADD_STOC = "UPDATE componentadb.memorie \n"
            + "SET stoc = stoc + 1\n"
            + "WHERE codProdus = ?;";

    private final String UPDATE_SCAD_STOC = "UPDATE componentadb.memorie \n"
            + "SET stoc = stoc - 1\n"
            + "WHERE codProdus = ?;";
    
    public Memorie read(ResultSet rs) throws SQLException {
        Memorie res = new Memorie();
        res.setCodProdus(rs.getInt(1));
        res.setPret(rs.getInt(2));
        res.setMarca(rs.getString(3));
        res.setAnFabricatie(rs.getInt(4));
        res.setGarantie(rs.getInt(5));
        res.setProducator(rs.getString(6));
        res.setTaraProvenienta(rs.getString(7));
        res.setStoc(rs.getInt(8));
        return res;
    }

    public ArrayList<Memorie> readAllMemorie() throws SQLException {
        ArrayList<Memorie> result = new ArrayList<Memorie>();

        ResultSet rs = stmt.executeQuery(SELECT);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void update(Memorie memorie) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE)) {
            preparedStmt.setInt(1, memorie.getCodProdus());
            preparedStmt.setDouble(2, memorie.getPret());
            preparedStmt.setString(3, memorie.getMarca());
            preparedStmt.setInt(4, memorie.getAnFabricatie());
            preparedStmt.setInt(5, memorie.getGarantie());
            preparedStmt.setString(6, memorie.getProducator());
            preparedStmt.setString(7, memorie.getTaraProvenienta());
            
            preparedStmt.setInt(8, memorie.getStoc());
            preparedStmt.setInt(9, memorie.getCodProdus());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void insert(Memorie memorie) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(INSERT)) {
            preparedStmt.setDouble(1, memorie.getPret());
            preparedStmt.setString(2, memorie.getMarca());
            preparedStmt.setInt(3, memorie.getAnFabricatie());
            preparedStmt.setInt(4, memorie.getGarantie());
            preparedStmt.setString(5, memorie.getProducator());
            preparedStmt.setString(6, memorie.getTaraProvenienta());
            preparedStmt.setInt(7, memorie.getStoc());
            preparedStmt.executeUpdate();
            //nu se insereaza si o valoare noua pentru codProdus pentru ca 
            //baza de date a fost creata cu codProdus ce se autoincrementeaza
        }
    }
    
    public void updateAddStoc(Memorie mem) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_ADD_STOC)) {
            preparedStmt.setInt(1, mem.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void updateScadStoc(Memorie mem) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_SCAD_STOC)) {
            preparedStmt.setInt(1, mem.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public Memorie readById(Integer id) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(SELECT_BY_ID);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next()) {
            return read(rs);
        } else {
            return null;
        }
    }

    public void deleteById(Integer id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(DELETE_BY_ID);
        preparedStmt.setInt(1, id);
        preparedStmt.execute();
    }

    public void delete(Memorie memorie) throws SQLException, ClassNotFoundException {
        deleteById(memorie.getCodProdus());

    }
}