package semIV;

import java.sql.*;
import java.sql.*;

public class MusicStore {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/albums_for_rent";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "nirvana@1987";

    public static void main(String[] args) {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to the database");
            
            // Add a new album
            addAlbum(conn, "ALB06", "Other Worlds", "The Pretty Reckless", 80, 3);

            // Update an existing album
            updateAlbum(conn, "ALB02", "Nightmare", "Avenged Sevenfold", 250, 5);

            // Delete an album
            deleteAlbum(conn, "ALB05");

            // Retrieve all albums
            retrieveAlbums(conn);

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }

    private static void addAlbum(Connection conn, String albId, String name, String artistName, int amt, int quantity)
            throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO albums VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, albId);
        stmt.setString(2, name);
        stmt.setString(3, artistName);
        stmt.setInt(4, amt);
        stmt.setInt(5, quantity);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected == 1) {
            System.out.println("Album added successfully");
        } else {
            System.err.println("Error adding album");
        }
    }

    private static void updateAlbum(Connection conn, String albId, String name, String artistName, int amt, int quantity)
            throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE albums SET name = ?, artist_name = ?, amt = ?, quantity = ? WHERE alb_id = ?");
        stmt.setString(1, name);
        stmt.setString(2, artistName);
        stmt.setInt(3, amt);
        stmt.setInt(4, quantity);
        stmt.setString(5, albId);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected == 1) {
            System.out.println("Album updated successfully");
        } else {
            System.err.println("Error updating album");
        }
    }

    private static void deleteAlbum(Connection conn, String albId)
            throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "DELETE FROM albums WHERE alb_id = ?");
        stmt.setString(1, albId);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected == 1) {
            System.out.println("Album deleted successfully");
        } else {
            System.err.println("Error deleting album");
        }
    }

    private static void retrieveAlbums(Connection conn)
            throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM albums");

        while (rs.next()) {
            String albId = rs.getString("alb_id");
            String name = rs.getString("name");
            String artistName = rs.getString("artist_name");
            int amt = rs.getInt("amt");
            int quantity = rs.getInt("quantity");
            System.out.printf("%s, %s, %s, %d, %d%n", albId, name, artistName, amt, quantity);
        }
    }
}
