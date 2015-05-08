import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anton_Shkliarov on 5/7/2015.
 */
public class AbonentDAO extends AbstractDAO<Integer, Abonent> {

    public static final String SQL_SELECT_ALL_ABONENTS = "SELECT * FROM phonebook";

    public static final String SQL_SELECT_ABONENTS_BY_LASTNAME =
            "SELECT idphonebook, phone FROM phonebook WHERE lastname=?";

    @Override
    public List<Abonent> findAll() throws SQLException {
        List<Abonent> abonents = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ABONENTS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int phone = rs.getInt(3);
                abonents.add(new Abonent(id, phone, name));
            }

        } catch (SQLException e) {
            System.err.println("SQL Exeption (request or table failed):" + e);
        }

        return null;
    }

    @Override
    public Abonent findEntityById(Integer Id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer Id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Abonent entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Abonent entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Abonent update(Abonent entity) {
        return null;
    }

    public Abonent findAbonentByLastName(String name) {
        Abonent abonent = new Abonent();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectorDB.getConnection();
            st = cn.prepareStatement(SQL_SELECT_ABONENTS_BY_LASTNAME);
            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            abonent.setId(resultSet.getInt("idphonebook"));
            abonent.setPhone(resultSet.getInt("phone"));
            abonent.setLastname(name);
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed):" + e);
        }
        return abonent;
    }

}
