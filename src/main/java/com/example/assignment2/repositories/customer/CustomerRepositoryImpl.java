package com.example.assignment2.repositories.customer;

import com.example.assignment2.models.Customer;
import com.example.assignment2.models.CustomerCountry;
import com.example.assignment2.models.CustomerGenre;
import com.example.assignment2.models.CustomerSpender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private final String url;
    private final String username;
    private final String password;

    public CustomerRepositoryImpl(
            @Value("${spring.datasource.url}") String url,
            @Value("${spring.datasource.username}") String username,
            @Value("${spring.datasource.password}") String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    //Finds all Customers
    @Override
    public List<Customer> findAll() {

        String sql = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Finds customer by name
    @Override
    public List<Customer> findByName(String name) {
        String sql = "SELECT * FROM customer WHERE first_name LIKE ?";
        List<Customer> customers = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"%" + name + "%");
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Finds customer by id
    @Override
    public List <Customer> findById(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Order by limit and offset
    @Override
    public List <Customer> limitAndOffset(int limit, int offset) {
        String sql = "SELECT * FROM customer LIMIT ? OFFSET ?";
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Customer customer = new Customer(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("country"),
                        result.getString("postal_code"),
                        result.getString("phone"),
                        result.getString("email")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    //Orders country by most visited
    @Override
    public List<CustomerCountry> findCountry() {
        String sql = "SELECT country, COUNT(country)\n" +
                "AS country_occurrence\n" +
                "FROM customer\n" +
                "GROUP BY country\n" +
                "ORDER BY country_occurrence DESC\n" +
                "LIMIT 1;";
        List<CustomerCountry> customerCountries = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()){
                CustomerCountry customerCountry = new CustomerCountry(
                        result.getString("country"),
                        result.getInt("country_occurrence")
                );
                customerCountries.add(customerCountry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerCountries;
    }

    // Insert a new customer
    @Override
    public int insert(Customer object) {

        String sql = "INSERT INTO customer (customer_id, first_name, last_name, country, postal_code, phone, email) VALUES (?,?,?,?,?,?,?)";

        int result = 0;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,object.customer_id());
            statement.setString(2, object.first_name());
            statement.setString(3, object.last_name());
            statement.setString(4, object.country());
            statement.setString(5, object.postal_code());
            statement.setString(6, object.phone());
            statement.setString(7, object.email());
            // Execute statement
            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //Finds customer who spends the most
    @Override
    public List<CustomerSpender> findHighestSpender() {

        String sql = "" +
                "SELECT customer.customer_id, first_name, last_name, invoice.total " +
                "FROM customer " +
                "INNER JOIN invoice ON customer.customer_id = invoice.customer_id " +
                "WHERE total = ( SELECT MAX(total) FROM invoice )" +
                "";
        List<CustomerSpender> highestSpender = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                CustomerSpender customerSpender = new CustomerSpender(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getDouble("total")
                );
                highestSpender.add(customerSpender);
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return highestSpender;
    }

    //Finds customers most popular genre
    @Override
    public List<CustomerGenre> findPopularGenreByName(int id) {
        String sql = "" +
                "SELECT customer.customer_id, first_name, last_name, genre.name, COUNT(genre.genre_id) \n" +
                "AS track_count\n" +
                "FROM customer\n" +
                "INNER JOIN invoice ON customer.customer_id = invoice.customer_id\n" +
                "INNER JOIN invoice_line ON invoice_line.invoice_id = invoice.invoice_id\n" +
                "INNER JOIN track ON track.track_id = invoice_line.track_id\n" +
                "INNER JOIN genre ON genre.genre_id = track.genre_id\n" +
                "WHERE customer.customer_id=?\n" +
                "GROUP BY customer.customer_id, genre.name\n" +
                "ORDER BY track_count DESC NULLS LAST\n" +
                "FETCH FIRST 1 ROWS WITH TIES";
        List<CustomerGenre> popularGenre = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            // Execute statement
            ResultSet result = statement.executeQuery();
            while (result.next()){
                CustomerGenre customerGenre = new CustomerGenre(
                        result.getInt("customer_id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getString("name"),
                        result.getInt("track_count")
                );
                popularGenre.add(customerGenre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return popularGenre;
    }

    @Override
    public int update(Customer object) {
        return 0;
    }

    // Updates a customers name
    @Override
    public int updateCustomer(int id, String first_name) {
        String sql = "UPDATE customer SET first_name = ? WHERE customer_id = ?";
        int result = 0;
        try(Connection conn = DriverManager.getConnection(url, username,password)) {
            // Write statement
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(2, id);
            statement.setString(1,first_name);
            // Execute statement
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public int delete(Customer object) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
