package Crud;

import implementari.HDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author Alex
 */
public class CrudHDD extends Crud {

    public CrudHDD() throws SQLException, ClassNotFoundException {
        super();
    }
    private final static String SELECT = "SELECT * FROM componentadb.hdd;";
    private final String UPDATE = "UPDATE `componentadb`.`hdd`\n"
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

    private final String INSERT = "INSERT INTO `componentadb`.`hdd`\n"
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
    private final String SELECT_BY_ID = "select * from componentadb.hdd where `codProdus` = ?;";

    private final String DELETE_BY_ID = "delete from `componentadb`.`hdd` where `codProdus` = ?;";

    private final String UPDATE_ADD_STOC = "UPDATE componentadb.hdd \n"
            + "SET stoc = stoc + 1\n"
            + "WHERE codProdus = ?;";

    private final String UPDATE_SCAD_STOC = "UPDATE componentadb.hdd \n"
            + "SET stoc = stoc - 1\n"
            + "WHERE codProdus = ?;";

    public HDD read(ResultSet rs) throws SQLException {
        HDD res = new HDD();
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

    public ArrayList<HDD> readAllHDD() throws SQLException {
        ArrayList<HDD> result = new ArrayList<HDD>();

        ResultSet rs = stmt.executeQuery(SELECT);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void update(HDD hdd) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE)) {
            preparedStmt.setInt(1, hdd.getCodProdus());
            preparedStmt.setDouble(2, hdd.getPret());
            preparedStmt.setString(3, hdd.getMarca());
            preparedStmt.setInt(4, hdd.getAnFabricatie());
            preparedStmt.setInt(5, hdd.getGarantie());
            preparedStmt.setString(6, hdd.getProducator());
            preparedStmt.setString(7, hdd.getTaraProvenienta());
            preparedStmt.setInt(8, hdd.getStoc());
            preparedStmt.setInt(9, hdd.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void updateAddStoc(HDD hdd) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_ADD_STOC)) {
            preparedStmt.setInt(1, hdd.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void updateScadStoc(HDD hdd) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_SCAD_STOC)) {
            preparedStmt.setInt(1, hdd.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void insert(HDD hdd) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(INSERT)) {
            preparedStmt.setDouble(1, hdd.getPret());
            preparedStmt.setString(2, hdd.getMarca());
            preparedStmt.setInt(3, hdd.getAnFabricatie());
            preparedStmt.setInt(4, hdd.getGarantie());
            preparedStmt.setString(5, hdd.getProducator());
            preparedStmt.setString(6, hdd.getTaraProvenienta());
            preparedStmt.setInt(7, hdd.getStoc());
            preparedStmt.executeUpdate();
            //nu se insereaza si o valoare noua pentru codProdus pentru ca 
            //baza de date a fost creata cu codProdus ce se autoincrementeaza
        }
    }

    public HDD readById(Integer id) throws SQLException, ClassNotFoundException {

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

    public void delete(HDD hdd) throws SQLException, ClassNotFoundException {
        deleteById(hdd.getCodProdus());

    }

}