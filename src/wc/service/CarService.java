package wc.service;

import wc.entity.Car;
import wc.repository.CarDA;

import java.util.List;

public class CarService {

    private static final CarService CAR_SERVICE = new CarService();
    private CarService() {
    }

    public static CarService getCarService(){
        return CAR_SERVICE;
    }

    public void save(Car car) throws Exception {
        try (CarDA carDA = new CarDA()) {
            carDA.insert(car);
            carDA.commit();
        }
    }

    public List<Car> findAll() throws Exception {
        try (CarDA carDA = new CarDA()) {
            return carDA.selectAll();
        }
    }
}
