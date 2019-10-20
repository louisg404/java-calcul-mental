package dal;

import bo.User;
import java.sql.*;

public class UserDAOJDBC extends DataAccessObjectJDBC<User> {

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String UPDATE_QUERY = "UPDATE user SET best = ? where pseudo = ?";


    public UserDAOJDBC( String dbUrl, String dbLogin, String dbPwd ) {
        super( dbUrl, dbLogin, dbPwd );
    }

    //Méthode UPDATE qui ne fonctionne pas
    @Override
    public void update(User object) throws SQLException{
        try (Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd ); PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY) ){
            ps.setInt(1, object.getBest());
            ps.setString(2, object.getPseudo());
            ps.executeUpdate();
        }
    }

    @Override
    public void create( User object ) {}

    public User authenticate( String login, String password ) throws SQLException {

        User user = null;
        try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
              PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY) ) {
            ps.setString( 1, login );
            ps.setString( 2, password );
            try ( ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    user = new User();
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                }
            }
        }
        return user;
    }
}
