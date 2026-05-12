import java.sql.*;
import java.util.Scanner;

public class JDBCProject {

    static final String URL = "jdbc:mysql://localhost:3306/university";
    static final String USER = "root";
    static final String PASSWORD = "Test123#";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)
        ) {

            System.out.println("Connected to Database Successfully!");

            int choice;

            do {

                System.out.println("\n========== UNIVERSITY MANAGEMENT SYSTEM ==========");
                System.out.println("1. Show Student Records");
                System.out.println("2. Add Student Record");
                System.out.println("3. Delete Student Record");
                System.out.println("4. Update Student Information");
                System.out.println("5. Show Instructor Details");
                System.out.println("6. Show Course Details with Enrolled Students");
                System.out.println("7. Show Course Details Taken by Instructor");
                System.out.println("8. Deposit HRA to Salary");
                System.out.println("9. Deduct TDS from Salary");
                System.out.println("10. Exit");
                System.out.print("Enter Choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        showStudentRecords(conn);
                        break;

                    case 2:
                        addStudentRecord(conn);
                        break;

                    case 3:
                        deleteStudentRecord(conn);
                        break;

                    case 4:
                        updateStudentInformation(conn);
                        break;

                    case 5:
                        showInstructorDetails(conn);
                        break;

                    case 6:
                        showCourseDetails(conn);
                        break;

                    case 7:
                        showCoursesByInstructor(conn);
                        break;

                    case 8:
                        depositHRA(conn);
                        break;

                    case 9:
                        deductTDS(conn);
                        break;

                    case 10:
                        System.out.println("Exiting Program...");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 10);

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    /* --------------------------------------------------------
     1. SHOW STUDENT RECORDS
     --------------------------------------------------------*/

    public static void showStudentRecords(Connection conn) {

        String query = "SELECT * FROM student";

        try (
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {

            System.out.println("\n----- STUDENT RECORDS -----");

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("ID") +
                                " | Name: " + rs.getString("name") +
                                " | Dept: " + rs.getString("dept_name") +
                                " | Total Credits: " + rs.getInt("tot_cred")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     2. ADD STUDENT RECORD
    // --------------------------------------------------------*/

    public static void addStudentRecord(Connection conn) {

        String query = "INSERT INTO student VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department Name: ");
            String dept = sc.nextLine();

            System.out.print("Enter Total Credits: ");
            int cred = sc.nextInt();

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, dept);
            pstmt.setInt(4, cred);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Record Added Successfully!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     3. DELETE STUDENT RECORD
    // --------------------------------------------------------*/

    public static void deleteStudentRecord(Connection conn) {

        String query = "DELETE FROM student WHERE ID = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Record Deleted!");
            } else {
                System.out.println("Student Not Found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     4. UPDATE STUDENT INFORMATION
    // --------------------------------------------------------*/

    public static void updateStudentInformation(Connection conn) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("1. Update Name");
        System.out.println("2. Update Department");
        System.out.println("3. Update Total Credits");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        String query = "";

        try {

            switch (choice) {

                case 1:

                    query = "UPDATE student SET name = ? WHERE ID = ?";

                    PreparedStatement ps1 = conn.prepareStatement(query);

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    ps1.setString(1, newName);
                    ps1.setInt(2, id);

                    ps1.executeUpdate();

                    System.out.println("Name Updated!");
                    break;

                case 2:

                    query = "UPDATE student SET dept_name = ? WHERE ID = ?";

                    PreparedStatement ps2 = conn.prepareStatement(query);

                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();

                    ps2.setString(1, newDept);
                    ps2.setInt(2, id);

                    ps2.executeUpdate();

                    System.out.println("Department Updated!");
                    break;

                case 3:

                    query = "UPDATE student SET tot_cred = ? WHERE ID = ?";

                    PreparedStatement ps3 = conn.prepareStatement(query);

                    System.out.print("Enter New Credits: ");
                    int cred = sc.nextInt();

                    ps3.setInt(1, cred);
                    ps3.setInt(2, id);

                    ps3.executeUpdate();

                    System.out.println("Credits Updated!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     5. SHOW INSTRUCTOR DETAILS
    // --------------------------------------------------------*/

    public static void showInstructorDetails(Connection conn) {

        String query = "SELECT * FROM instructor WHERE ID = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            System.out.print("Enter Instructor ID: ");
            int id = sc.nextInt();

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                System.out.println("\n----- INSTRUCTOR DETAILS -----");

                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("dept_name"));
                System.out.println("Salary: " + rs.getDouble("salary"));

            } else {
                System.out.println("Instructor Not Found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     6. SHOW COURSE DETAILS WITH ENROLLED STUDENTS
    // --------------------------------------------------------*/

    public static void showCourseDetails(Connection conn) {

        String query =
                "SELECT c.course_id, c.title, s.ID, s.name, t.semester, t.year " +
                        "FROM course c " +
                        "JOIN takes t ON c.course_id = t.course_id " +
                        "JOIN student s ON t.ID = s.ID " +
                        "WHERE c.course_id = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            System.out.print("Enter Course ID: ");
            String courseId = sc.next();

            pstmt.setString(1, courseId);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n----- COURSE DETAILS -----");

            while (rs.next()) {

                System.out.println(
                        "Course ID: " + rs.getString("course_id") +
                                " | Title: " + rs.getString("title") +
                                " | Student ID: " + rs.getInt("ID") +
                                " | Student Name: " + rs.getString("name") +
                                " | Semester: " + rs.getString("semester") +
                                " | Year: " + rs.getInt("year")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     7. SHOW COURSES TAKEN BY INSTRUCTOR
    // --------------------------------------------------------*/

    public static void showCoursesByInstructor(Connection conn) {

        String query =
                "SELECT i.ID, i.name, c.course_id, c.title " +
                        "FROM instructor i " +
                        "JOIN teaches t ON i.ID = t.ID " +
                        "JOIN course c ON t.course_id = c.course_id " +
                        "WHERE i.ID = ?";

        try (
                PreparedStatement pstmt = conn.prepareStatement(query)
        ) {

            System.out.print("Enter Instructor ID: ");
            int id = sc.nextInt();

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n----- COURSES TAUGHT -----");

            while (rs.next()) {

                System.out.println(
                        "Instructor ID: " + rs.getInt("ID") +
                                " | Name: " + rs.getString("name") +
                                " | Course ID: " + rs.getString("course_id") +
                                " | Title: " + rs.getString("title")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     8. DEPOSIT HRA TO SALARY
    // --------------------------------------------------------*/

    public static void depositHRA(Connection conn) {

        String getSalary = "SELECT salary FROM instructor WHERE ID = ?";
        String updateSalary = "UPDATE instructor SET salary = ? WHERE ID = ?";

        try {

            System.out.print("Enter Instructor ID: ");
            int id = sc.nextInt();

            PreparedStatement ps1 = conn.prepareStatement(getSalary);
            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                double salary = rs.getDouble("salary");

                double hra = salary * 0.15;

                double updatedSalary = salary + hra;

                PreparedStatement ps2 = conn.prepareStatement(updateSalary);

                ps2.setDouble(1, updatedSalary);
                ps2.setInt(2, id);

                ps2.executeUpdate();

                System.out.println("HRA Added Successfully!");
                System.out.println("Updated Salary: " + updatedSalary);

            } else {
                System.out.println("Instructor Not Found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /* --------------------------------------------------------
     9. DEDUCT TDS FROM SALARY
     --------------------------------------------------------*/

    public static void deductTDS(Connection conn) {

        String getSalary = "SELECT salary FROM instructor WHERE ID = ?";
        String updateSalary = "UPDATE instructor SET salary = ? WHERE ID = ?";

        try {

            System.out.print("Enter Instructor ID: ");
            int id = sc.nextInt();

            PreparedStatement ps1 = conn.prepareStatement(getSalary);

            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                double salary = rs.getDouble("salary");

                double tds = salary * 0.20;

                double updatedSalary = salary - tds;

                PreparedStatement ps2 = conn.prepareStatement(updateSalary);

                ps2.setDouble(1, updatedSalary);
                ps2.setInt(2, id);

                ps2.executeUpdate();

                System.out.println("TDS Deducted Successfully!");
                System.out.println("Updated Salary: " + updatedSalary);

            } else {
                System.out.println("Instructor Not Found!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}