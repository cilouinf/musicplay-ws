import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private DAOFactory daoFactory;

    UserDAOImpl(DAOFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public void AddUser(User user){
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try{
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO User(UserLogin, UserPassword, UserSalt) VALUES (?,?,?);");
            preparedStatement.setString(1, user.getUserLogin());
            preparedStatement.setString(1, user.getUserPassword());
            preparedStatement.setString(1, user.getUserSalt());

            preparedStatement.executeUpdate();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
