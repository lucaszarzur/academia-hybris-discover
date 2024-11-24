package br.com.discover.academia.hybris.service;

import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;

import java.util.List;

public interface VehicleService {
    List<PassengerCarModel> findPassengerCars();
    List<CargoVehicleModel> findCargoVehicles();
    PassengerCarModel findPassengerCarsByCode(String code);
    CargoVehicleModel findCargoVehiclesByCode(String code);
}
