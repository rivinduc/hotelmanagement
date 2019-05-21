package lk.ijse.cmjd.fx.dao;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {

    T find(ID key) throws Exception;

    List<T> findAll() throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID key) throws Exception;
    boolean delete2(ID key) throws Exception;

}
