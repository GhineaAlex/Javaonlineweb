package Crud;

import implementari.Procesor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class CrudProcesor extends Crud {

    public CrudProcesor() throws SQLException, ClassNotFoundException {
        super();
    }
    private final static String SELECT = "SELECT * FROM componentadb.procesor;";
    private final String UPDATE = "UPDATE `componentadb`.`procesor`\n"
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
    private final String INSERT = "INSERT INTO `componentadb`.`procesor`\n"
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
    private final String SELECT_BY_ID = "select * from componentadb.procesor where `codProdus` = ?;";

    private final String DELETE_BY_ID = "delete from `componentadb`.`procesor` where `codProdus` = ?;";

    private final String UPDATE_ADD_STOC = "UPDATE componentadb.procesor \n"
            + "SET stoc = stoc + 1\n"
            + "WHERE codProdus = ?;";

    private final String UPDATE_SCAD_STOC = "UPDATE componentadb.procesor \n"
            + "SET stoc = stoc - 1\n"
            + "WHERE codProdus = ?;";

    public Procesor read(ResultSet rs) throws SQLException {
        Procesor res = new Procesor();
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

    public ArrayList<Procesor> readAllProcesor() throws SQLException {
        ArrayList<Procesor> result = new ArrayList<Procesor>();

        ResultSet rs = stmt.executeQuery(SELECT);
        while (rs.next()) {
            result.add(read(rs));
        }
        return result;
    }

    public void update(Procesor procesor) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE)) {
            preparedStmt.setInt(1, procesor.getCodProdus());
            preparedStmt.setDouble(2, procesor.getPret());
            preparedStmt.setString(3, procesor.getMarca());
            preparedStmt.setInt(4, procesor.getAnFabricatie());
            preparedStmt.setInt(5, procesor.getGarantie());
            preparedStmt.setString(6, procesor.getProducator());
            preparedStmt.setString(7, procesor.getTaraProvenienta());
            preparedStmt.setInt(8, procesor.getCodProdus());
            preparedStmt.setInt(9, procesor.getStoc());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void insert(Procesor procesor) throws SQLException, ClassNotFoundException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(INSERT)) {
            preparedStmt.setDouble(1, procesor.getPret());
            preparedStmt.setString(2, procesor.getMarca());
            preparedStmt.setInt(3, procesor.getAnFabricatie());
            preparedStmt.setInt(4, procesor.getGarantie());
            preparedStmt.setString(5, procesor.getProducator());
            preparedStmt.setString(6, procesor.getTaraProvenienta());
            preparedStmt.setInt(7, procesor.getStoc());
            preparedStmt.executeUpdate();
            //nu se insereaza si o valoare noua pentru codProdus pentru ca 
            //baza de date a fost creata cu codProdus ce se autoincrementeaza
        }
    }

    public Procesor readById(Integer id) throws SQLException, ClassNotFoundException {

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

    public void delete(Procesor hdd) throws SQLException, ClassNotFoundException {
        deleteById(hdd.getCodProdus());

    }
    
    public void updateAddStoc(Procesor proc) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_ADD_STOC)) {
            preparedStmt.setInt(1, proc.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

    public void updateScadStoc(Procesor proc) throws ClassNotFoundException, SQLException {
        try (PreparedStatement preparedStmt = dbConn.getConnection().prepareStatement(UPDATE_SCAD_STOC)) {
            preparedStmt.setInt(1, proc.getCodProdus());

            preparedStmt.executeUpdate();
            preparedStmt.close();
        }
    }

}