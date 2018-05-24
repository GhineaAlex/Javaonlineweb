package Crud;

import implementari.Sursa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CrudSursa extends Crud {

    public CrudSursa() throws SQLException, ClassNotFoundException {
        super();
    }
    private final static String SELECT = "SELECT * FROM componentadb.sursa;";
    private final String UPDATE = "UPDATE `componentadb`.`sursa`\n"
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
    private final String INSERT = "INSERT INTO `componentadb`.`sursa`\n"
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
    private final String SELECT_BY_ID = "select * from componentadb.sursa where `codProdus` = ?;";

    private final String DELETE_BY_ID = "delete from `componentadb`.`sursa` where `codProdus` = ?;";

    private final String UPDATE_ADD_STOC = "UPDATE componentadb.sursa \n"
            + "SET stoc = stoc + 1\n"
            + "WHERE codProdus = ?;";

    private final String UPDATE_SCAD_STOC = "UPDATE componentadb.sursa \n"
            + "SET stoc = stoc - 1\n"
            + "WHERE codProdus = ?;";

    public Sursa read(ResultSet rs) throws SQLException {
        Sursa res = new Sursa();
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

    public ArrayList<Sursa> readAllSursa() throws SQLException {
        ArrayList<Sursa> result = new ArrayList<Sursa>();

        ResultSet rs = stmt.executeQuery(SELECT);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void update(Sursa sursa) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE)) {
            preparedStmt.setInt(1, sursa.getCodProdus());
            preparedStmt.setDouble(2, sursa.getPret());
            preparedStmt.setString(3, sursa.getMarca());
            preparedStmt.setInt(4, sursa.getAnFabricatie());
            preparedStmt.setInt(5, sursa.getGarantie());
            preparedStmt.setString(6, sursa.getProducator());
            preparedStmt.setString(7, sursa.getTaraProvenienta());
            preparedStmt.setInt(8, sursa.getCodProdus());
            preparedStmt.setInt(9, sursa.getStoc());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void insert(Sursa sursa) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(INSERT)) {
            preparedStmt.setDouble(1, sursa.getPret());
            preparedStmt.setString(2, sursa.getMarca());
            preparedStmt.setInt(3, sursa.getAnFabricatie());
            preparedStmt.setInt(4, sursa.getGarantie());
            preparedStmt.setString(5, sursa.getProducator());
            preparedStmt.setString(6, sursa.getTaraProvenienta());
            preparedStmt.setInt(7, sursa.getStoc());
            preparedStmt.executeUpdate();
            //nu se insereaza si o valoare noua pentru codProdus pentru ca 
            //baza de date a fost creata cu codProdus ce se autoincrementeaza
        }
    }

    public Sursa readById(Integer id) throws SQLException, ClassNotFoundException {

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

    public void delete(Sursa sursa) throws SQLException, ClassNotFoundException {
        deleteById(sursa.getCodProdus());

    }
    
    public void updateAddStoc(Sursa s) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_ADD_STOC)) {
            preparedStmt.setInt(1, s.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void updateScadStoc(Sursa s) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_SCAD_STOC)) {
            preparedStmt.setInt(1, s.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

}