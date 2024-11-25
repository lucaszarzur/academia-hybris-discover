package br.com.discover.academia.hybris.service;

import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import br.com.discover.academia.hybris.model.VehicleModel;

import java.util.List;

public interface VehicleService {
    //    PassengerCar
    List<PassengerCarModel> findPassengerCars();
    PassengerCarModel findPassengerCarsByCode(String code);

    //    CargoVehicle
    List<CargoVehicleModel> findCargoVehicles();
    VehicleModel findCargoVehiclesByCode(String code);
}
