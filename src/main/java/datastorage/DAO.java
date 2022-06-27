package datastorage;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for DAO methods
 * @param <T> T
 */
public interface DAO<T> {
    /**
     * create
     * @param t T
     * @throws SQLException throws SQL exception
     */
    void create(T t) throws SQLException;

    /**
     * reads one by ID
     * @param key the ID
     * @return the read
     * @throws SQLException throws SQL exception
     */
    T read(long key) throws SQLException;

    /**
     * reads all
     * @return a list of all read
     * @throws SQLException throws SQL exception
     */
    List<T> readAll() throws SQLException;
    /**
     * update
     * @param t T
     * @throws SQLException throws SQL exception
     */
    void update(T t) throws SQLException;

    /**
     * deletes by ID
     * @param key the ID
     * @throws SQLException throws SQL exception
     */
    void deleteById(long key) throws SQLException;
}
