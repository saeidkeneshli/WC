package wc.repository;

import wc.entity.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CarDA() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1", "saeid", "123");
        connection.setAutoCommit(false);
    }

    public void insert(Car car) throws Exception{
        preparedStatement = connection.prepareStatement("insert into car(name, company) values (?,?)");
        preparedStatement.setString(1, car.getName());
        preparedStatement.setString(2, car.getCompany());
        preparedStatement.executeUpdate();
    }

    public List<Car> selectAll() throws Exception {
        preparedStatement = connection.prepareStatement("select * from car");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Car> carList = new ArrayList<>();
        while (resultSet.next()) {
            Car car = new Car().setName(resultSet.getString("name")).setCompany(resultSet.getString("company"));
            carList.add(car);
        }
        return carList;
    }

    public void commit() throws Exception{
        connection.commit();
    }
    @Override
    public void close() throws Exception{
        connection.close();
        preparedStatement.close();
    }
}
