package matthias.dao;

import matthias.beans.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    private static final String jdbcHost = "jdbc:mysql://localhost:3306/";
    private static final String jdbcLogin = "root";
    private static final String jdbcPassword = "root";
    private static final String jdbcDatabase = "peopledb";

    private static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(jdbcHost + jdbcDatabase, jdbcLogin, jdbcPassword);

        return conn;
    }

    public static int addPerson(Person person) {
        int status = 0;

        try(Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO people (firstName,lastName,age,sex,country) VALUES (?,?,?,?,?)");
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setInt(3, person.getAge());
            stmt.setString(4, person.getSex());
            stmt.setString(5, person.getCountry());

            status = stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static int removePerson(int id) {
        int status = 0;

        try(Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();

            String sql = "DELETE FROM people WHERE id=" + id;

            status = stmt.executeUpdate(sql);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();

        try(Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();

            String sql  = "SELECT * FROM people";
            ResultSet result = stmt.executeQuery(sql);

            while(result.next()) {
                Person p = new Person();
                p.setId(result.getInt(1));
                p.setFirstName(result.getString(2));
                p.setLastName(result.getString(3));
                p.setAge(result.getInt(4));
                p.setSex(result.getString(5));
                p.setCountry(result.getString(6));
                people.add(p);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return people;
    }

    public static Person getPersonById(int id) {
        Person person = null;

        try(Connection conn = getConnection()) {
            Statement stmt = conn.createStatement();

            String sql  = "SELECT * FROM people WHERE id=" + id;
            ResultSet result = stmt.executeQuery(sql);

            if(result.next()) {
                person = new Person();
                person.setId(result.getInt(1));
                person.setFirstName(result.getString(2));
                person.setLastName(result.getString(3));
                person.setAge(result.getInt(4));
                person.setSex(result.getString(5));
                person.setCountry(result.getString(6));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    public static int updatePerson(int id, Person person) {
        int status = 0;

        try(Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE people SET firstName=?, lastName=?, age=?, sex=?, country=? WHERE id=?");
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setInt(3, person.getAge());
            stmt.setString(4, person.getSex());
            stmt.setString(5, person.getCountry());
            stmt.setInt(6, id);

            status = stmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

}
