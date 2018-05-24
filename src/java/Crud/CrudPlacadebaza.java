package Crud;

import implementari.Placadebaza;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CrudPlacadebaza extends Crud {

    public CrudPlacadebaza() throws SQLException, ClassNotFoundException {
        super();
    }
    private final static String SELECT = "SELECT * FROM componentadb.placadebaza;";
    private final String UPDATE = "UPDATE `componentadb`.`placadebaza`\n"
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
    private final String INSERT = "INSERT INTO `componentadb`.`placadebaza`\n"
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
    private final String SELECT_BY_ID = "select * from componentadb.placadebaza where `codProdus` = ?;";

    private final String DELETE_BY_ID = "delete from `componentadb`.`placadebaza` where `codProdus` = ?;";

    private final String UPDATE_ADD_STOC = "UPDATE componentadb.placadebaza \n"
            + "SET stoc = stoc + 1\n"
            + "WHERE codProdus = ?;";

    private final String UPDATE_SCAD_STOC = "UPDATE componentadb.placadebaza \n"
            + "SET stoc = stoc - 1\n"
            + "WHERE codProdus = ?;";

    public Placadebaza read(ResultSet rs) throws SQLException {
        Placadebaza res = new Placadebaza();
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

    public ArrayList<Placadebaza> readAllPlacadebaza() throws SQLException {
        ArrayList<Placadebaza> result = new ArrayList<Placadebaza>();

        ResultSet rs = stmt.executeQuery(SELECT);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void update(Placadebaza Placadebaza) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE)) {
            preparedStmt.setInt(1, Placadebaza.getCodProdus());
            preparedStmt.setDouble(2, Placadebaza.getPret());
            preparedStmt.setString(3, Placadebaza.getMarca());
            preparedStmt.setInt(4, Placadebaza.getAnFabricatie());
            preparedStmt.setInt(5, Placadebaza.getGarantie());
            preparedStmt.setString(6, Placadebaza.getProducator());
            preparedStmt.setString(7, Placadebaza.getTaraProvenienta());
            preparedStmt.setInt(8, Placadebaza.getCodProdus());
            preparedStmt.setInt(9, Placadebaza.getStoc());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void insert(Placadebaza Placadebaza) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(INSERT)) {
            preparedStmt.setDouble(1, Placadebaza.getPret());
            preparedStmt.setString(2, Placadebaza.getMarca());
            preparedStmt.setInt(3, Placadebaza.getAnFabricatie());
            preparedStmt.setInt(4, Placadebaza.getGarantie());
            preparedStmt.setString(5, Placadebaza.getProducator());
            preparedStmt.setString(6, Placadebaza.getTaraProvenienta());
            preparedStmt.setInt(7, Placadebaza.getStoc());
            preparedStmt.executeUpdate();
            //nu se insereaza si o valoare noua pentru codProdus pentru ca 
            //baza de date a fost creata cu codProdus ce se autoincrementeaza
        }
    }

    public Placadebaza readById(Integer id) throws SQLException, ClassNotFoundException {

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

    public void delete(Placadebaza Placadebaza) throws SQLException, ClassNotFoundException {
        deleteById(Placadebaza.getCodProdus());

    }
    
    public void updateAddStoc(Placadebaza pb) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_ADD_STOC)) {
            preparedStmt.setInt(1, pb.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void updateScadStoc(Placadebaza pb) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_SCAD_STOC)) {
            preparedStmt.setInt(1, pb.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

}