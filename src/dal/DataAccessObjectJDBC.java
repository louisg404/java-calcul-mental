package dal;

import bo.User;

import java.sql.SQLException;

public abstract class DataAccessObjectJDBC<E> implements IDAO<E> {

    protected String dbUrl = "";
    protected String dbLogin = "";
    protected String dbPwd = "";

    public DataAccessObjectJDBC( String dbUrl, String dbLogin, String dbPwd ) {

        this.dbUrl = dbUrl;
        this.dbLogin = dbLogin;
        this.dbPwd = dbPwd;
    }

    public abstract void update(User user) throws SQLException;
}
