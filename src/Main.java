import config.Connexion;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Connection connexion = Connexion.getInstance().getConnection();
            Statement stst = connexion.createStatement();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}