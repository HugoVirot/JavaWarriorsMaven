package warriors.engine;

import java.sql.*;

public class Connect {

    ResultSet result;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://217.182.141.113/CampusNumerique2020";
            String user = "CampusNumerique2020";
            String passwd = "CampusNumerique2020";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

            Statement state = conn.createStatement();
            //requete sql pour afficher tous les héros
            this.result = state.executeQuery("SELECT * FROM Hero");
            ResultSetMetaData resultMeta = result.getMetaData();
            System.out.println("\n---------------------------------");
            System.out.println("- Il y a " + resultMeta.getColumnCount() + " colonnes dans cette table");
            for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.println("\t *" + resultMeta.getColumnName(i));

            System.out.println("\n---------------------------------");
            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                    System.out.println("\t" + result.getObject(i).toString() + "\t |");
                System.out.println("\n---------------------------------");


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getHeroes() throws SQLException {
        System.out.println("Voici les noms et prénoms : ");
        System.out.println("\n---------------------------------");

        while (this.result.next()) {
            System.out.print("\t" + this.result.getString("Name") + "\t |");
            System.out.println("\n---------------------------------");
        }
    }
}