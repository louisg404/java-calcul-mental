package dal;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<E> {

    public void create(E objet) throws SQLException;
    public void update(E object) throws SQLException;
}
