package br.com.discover.academia.hybris.dao;

import java.util.List;

import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;

public interface VehicleDAO {
    //    PassengerCar
    List<PassengerCarModel> findPassengerCars();
    PassengerCarModel findPassengerCarsByCode(String code);

    //    CargoVehicle
    List<CargoVehicleModel> findCargoVehicles();
    CargoVehicleModel findCargoVehiclesByCode(String code);
}
