package warriors.engine;

import warriors.contracts.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connect {

    private Connection conn;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver O.K.");
            String url = "jdbc:mysql://217.182.141.113/CampusNumerique2020";
            String user = "CampusNumerique2020";
            String passwd = "CampusNumerique2020";
            this.conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Hero> getHeroes() throws Exception {
        List<Hero> results = new ArrayList<>();
        Statement state = this.conn.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM Hero ");
        ResultSetMetaData resultMeta = result.getMetaData();

       /*System.out.println("\n**********************************");

        for (int i = 1; i <= resultMeta.getColumnCount(); i++)
            System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

        System.out.println("\n**********************************");*/

        while (result.next()) {
           /* for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + result.getObject(i).toString() + "\t |");

            System.out.println("\n---------------------------------");*/
            results.add(new Guerrier (result.getString("Name"), "aaa", result.getInt("Life"), result.getInt("Strengh")));
        }

        return results;
    }

    public Guerrier getHero(int id) throws Exception {

        Statement state = this.conn.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM Hero WHERE id = " + id);
        ResultSetMetaData resultMeta = result.getMetaData();

        System.out.println("\n**********************************");
        result.next();
            /*for (int i = 1; i <= resultMeta.getColumnCount(); i++)
                System.out.print("\t" + result.getObject(i).toString() + "\t |");

            System.out.println("\n---------------------------------");*/
        return new Guerrier (result.getString("Name"), "aaa", result.getInt("Life"), result.getInt("Strengh"));
    }

    public void createHero(Guerrier g) throws Exception {

        Statement state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "INSERT INTO Hero (TYPE, NAME, LIFE, STRENGH, OFFENSE, DEFENSE, ID) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement prepare = this.conn.prepareStatement(query);
        prepare.setString(1, g.type);
        prepare.setString(2, g.nom);
        prepare.setInt(3, g.niveauVie);
        prepare.setInt(4, g.niveauAttaque);
        prepare.setString(5, g.moyenAttaque);
        prepare.setString(6, g.moyenDefense);
        prepare.setInt(7, g.id);

        int colonnesInserees = prepare.executeUpdate();
        if (colonnesInserees > 0) {
            System.out.println("ajout du héros réussi !");
        }

        prepare.close();
        state.close();
    }

    public void updateHero(Guerrier h) throws Exception {

        Statement state = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String query = "UPDATE Hero SET Name = ? WHERE Id = ?";
        PreparedStatement prepare = this.conn.prepareStatement(query);
        prepare.setString(1, h.getName());
        prepare.setInt(2, h.getId());

        int rowsUpdated = prepare.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Mise à jour héros réussie");
        }

        prepare.close();
        state.close();
    }

    public void deleteHero(Guerrier g) throws Exception {

        String query = "DELETE FROM Hero WHERE ID = ?";
        PreparedStatement prepare = this.conn.prepareStatement(query);
        prepare.setInt(1, g.getId());

        int rowsDeleted = prepare.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Le héros a bien été supprimé !");
        }
    }
}
