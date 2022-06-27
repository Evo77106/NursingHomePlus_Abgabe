package datastorage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOimp
 * @param <T> T
 */
public abstract class DAOimp<T> implements DAO<T>{

    protected Connection conn;

    /**
     * DAOimp
     * @param conn the connection
     */
    public DAOimp(Connection conn) {
        this.conn = conn;
    }

    /**
     * create method
     * @param t T
     * @throws SQLException throws a SQL Exception
     */
    @Override
    public void create(T t) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(getCreateStatementString(t));
    }

    /**
     *
     * @param cid the CID
     * @return returns an object instance
     * @throws SQLException throws a SQL Exception
     */
    @Override
    public T read(long cid) throws SQLException {
        T object = null;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(getReadByIDStatementString(cid));
        if (result.next()) {
            object = getInstanceFromResultSet(result);
        }
        return object;
    }

    /**
     * read all
     * @return the result list
     * @throws SQLException throws a SQL Exception
     */
    @Override
    public List<T> readAll() throws SQLException {
        ArrayList<T> list = new ArrayList<T>();
        T object = null;
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(getReadAllStatementString());
        list = getListFromResultSet(result);
        return list;
    }

    /**
     * updates fields
     * @param t t
     * @throws SQLException throws a SQL Exception
     */
    @Override
    public void update(T t) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(getUpdateStatementString(t));
    }

    /**
     * Delete field by CID
     * @param cid the CID
     * @throws SQLException throws a SQL Exception
     */
    @Override
    public void deleteById(long cid) throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate(getDeleteStatementString(cid));
    }

    /**
     * gets the CreateStatementString
     * @param t t
     * @return the create statement string
     */
    protected abstract String getCreateStatementString(T t);

    /**
     * gets the ReadByIDStatementString
     * @param cid the CID
     * @return reads statement strings by ID
     */
    protected abstract String getReadByIDStatementString(long cid);

    /**
     * Gets instance from result set
     * @param set Reuslt Set
     * @return Instance from reultset
     * @throws SQLException throws SQL exception
     */
    protected abstract T getInstanceFromResultSet(ResultSet set) throws SQLException;

    /**
     * reads all Statement Strung
     * @return All statement string
     */
    protected abstract String getReadAllStatementString();

    /**
     * Gets a list from result Set
     * @param set the result Set
     * @return list from result set
     * @throws SQLException throws SQL Exception
     */
    protected abstract ArrayList<T> getListFromResultSet(ResultSet set) throws SQLException;

    /**
     * gets the update statement string
     * @param t T
     * @return updated Statement String
     */
    protected abstract String getUpdateStatementString(T t);

    /**
     * gets the DeleteStatementString
     * @param cid CDI
     * @return Delete Statement String
     */
    protected abstract String getDeleteStatementString(long cid);
}
