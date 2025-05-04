package Jan27_2025;

import java.sql.*;
import java.util.Scanner;

public class JDBCExample {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/Sameer_32216";
    static final String USERNAME = "root";
    static final String PASSWORD = "Root@1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            System.out.println("Connection Successful");

            createTable(conn);

            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Create Table");
                System.out.println("2. Insert Values");
                System.out.println("3. Display Table");
                System.out.println("4. Update Values");
                System.out.println("5. Delete Record");
                System.out.println("6. Search Record");
                System.out.println("7. Exit");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        createTable(conn);
                        break;
                    case 2:
                        insertValues(conn, scanner);
                        break;
                    case 3:
                        displayTable(conn);
                        break;
                    case 4:
                        updateValues(conn, scanner);
                        break;
                    case 5:
                        deleteRecord(conn, scanner);
                        break;
                    case 6:
                        searchRecord(conn, scanner);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                }

                System.out.print("\nDo you want to continue? (yes/no): ");
                String continueOption = scanner.nextLine().toLowerCase();

                if (continueOption.equals("no")) {
                    System.out.println("Exiting...");
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection conn) {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS StudentInformation ("
                                + "RollNo INT PRIMARY KEY, "
                                + "Name VARCHAR(100), "
                                + "Subject VARCHAR(100), "
                                + "Marks INT)";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(createTableQuery);
            System.out.println("Table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    public static void insertValues(Connection conn, Scanner scanner) {
        System.out.print("Enter Roll Number: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        String insertQuery = "INSERT INTO StudentInformation (RollNo, Name, Subject, Marks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setInt(1, rollNo);
            pstmt.setString(2, name);
            pstmt.setString(3, subject);
            pstmt.setInt(4, marks);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting values: " + e.getMessage());
        }
    }

    public static void displayTable(Connection conn) {
        String query = "SELECT * FROM StudentInformation";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            System.out.println("\nRoll Number\tName\tSubject\tMarks");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("RollNo") + "\t"
                  + rs.getString("Name") + "\t"
                  + rs.getString("Subject") + "\t"
                  + rs.getInt("Marks")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error displaying table: " + e.getMessage());
        }
    }

    public static void updateValues(Connection conn, Scanner scanner) {
        System.out.print("Enter Roll Number to update: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter new Marks: ");
        int marks = scanner.nextInt();

        String updateQuery = "UPDATE StudentInformation SET Name = ?, Subject = ?, Marks = ? WHERE RollNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, name);
            pstmt.setString(2, subject);
            pstmt.setInt(3, marks);
            pstmt.setInt(4, rollNo);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
    }

    public static void deleteRecord(Connection conn, Scanner scanner) {
        System.out.print("Enter Roll Number to delete: ");
        int rollNo = scanner.nextInt();

        String deleteQuery = "DELETE FROM StudentInformation WHERE RollNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, rollNo);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Record deleted successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting record: " + e.getMessage());
        }
    }

    public static void searchRecord(Connection conn, Scanner scanner) {
        System.out.print("Enter Roll Number to search: ");
        int rollNo = scanner.nextInt();

        String searchQuery = "SELECT * FROM StudentInformation WHERE RollNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(searchQuery)) {
            pstmt.setInt(1, rollNo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Roll Number\tName\tSubject\tMarks");
                    System.out.println(
                        rs.getInt("RollNo") + "\t"
                      + rs.getString("Name") + "\t"
                      + rs.getString("Subject") + "\t"
                      + rs.getInt("Marks")
                    );
                } else {
                    System.out.println("Record not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching record: " + e.getMessage());
        }
    }
}
