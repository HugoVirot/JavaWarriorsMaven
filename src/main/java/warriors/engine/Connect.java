package warriors.engine;

import javax.naming.Name;
import java.sql.*;

public class Connect {

    ResultSet result;

    public Connect() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://217.182.141.113/CampusNumerique2020";
            String user = "CampusNumerique2020";
            String passwd = "CampusNumerique2020";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            Statement state = conn.createStatement();

            this.result = state.executeQuery("SELECT * FROM Hero");
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.println("\t *" + resultMeta.getColumnName(i));

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");

                System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------");


                String sql = "INSERT INTO Hero (ID, Name, Life, Strengh, Type, Offense, Defense) VALUES (?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "4507");
                statement.setString(2, "benjinnnnnnx");
                statement.setString(3, "10");
                statement.setString(4, "10");
                statement.setString(5, "warrior");
                statement.setString(6, "arme");
                statement.setString(7, "bouclier");

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws SQLException
     */

    public void getHeroes() throws SQLException {
        System.out.println("Voici les noms et prénoms : ");
        System.out.println("\n---------------------------------");
        while (this.result.next()) {
            System.out.print("\t" + this.result.getString("Name") + "\t |");
            System.out.println("\n---------------------------------");
        }
    }
}