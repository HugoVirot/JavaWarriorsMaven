package warriors.engine;

import warriors.contracts.Hero;

import javax.naming.Name;
import java.sql.*;
import java.util.ArrayList;
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

    public ArrayList getHeroes() throws SQLException {
        ResultSet result;
        Statement state;
        state = conn.createStatement();
        result = state.executeQuery("SELECT * FROM Hero");

        ArrayList heroes = new ArrayList();
        while (result.next()) {
            result.getString("Name");
            if (("WARRIOR").equals(result.getString("Type"))) {
                heroes.add(new Guerrier(result.getString("Name"), "img", Integer.parseInt(result.getString("Life")), Integer.parseInt(result.getString("Strengh")),999));
            } else {
                heroes.add(new Magicien(result.getString("Name"), "img", Integer.parseInt(result.getString("Life")), Integer.parseInt(result.getString("Strengh")),999));
            }
        }
        return heroes;
    }

    public Hero getHero(int id) throws SQLException {
        ResultSet result;
        Statement state;
        state = conn.createStatement();
        result = state.executeQuery("SELECT * FROM Hero WHERE ID = " + id);

        Hero newhero = null;
        result.next();
        if (("WARRIOR").equals(result.getString("Type"))) {
            newhero = new Guerrier(result.getString("Name"), "img", Integer.parseInt(result.getString("Life")), Integer.parseInt(result.getString("Strengh")),352);
        } else {
            newhero = new Magicien(result.getString("Name"), "img", Integer.parseInt(result.getString("Life")), Integer.parseInt(result.getString("Strengh")),999);
        }
        return newhero;
    }

    public void createHero(Hero h) {
        ResultSet result;
        Statement state;

        try {
            state = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Hero (Id, Name, Type, Life, Strengh, Offense, Defense) VALUES (?,?,?,?,?,?,?)");

            pstmt.setInt(1, h.getId());
            pstmt.setString(2, h.getName());
            pstmt.setString(3, h.getClass().getSimpleName().toUpperCase());
            pstmt.setInt(4, h.getLife());
            pstmt.setInt(5, h.getAttackLevel());
            pstmt.setString(6, "arme");
            pstmt.setString(7, "bouclier");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHero(Hero h) {
        ResultSet result;
        Statement state;
        Scanner sc = new Scanner(System.in);
        String name = h.getName();
        try {
            state = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE Hero SET Name = ? WHERE Id ="+1);
            pstmt.setString(1, sc.nextLine());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHero(Hero h) {
        ResultSet result;
        Statement state;
        Scanner sc = new Scanner(System.in);

        try {
            state = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Hero WHERE Id = ?");
            pstmt.setInt(1, h.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}