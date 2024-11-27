package br.com.discover.academia.hybris.facade;

import br.com.discover.academia.hybris.data.CargoVehicleData;
import br.com.discover.academia.hybris.data.PassengerCarData;

import java.util.List;

public interface VehicleFacade {
    List<PassengerCarData> findPassengerCars();
    List<CargoVehicleData> findCargoVehicles();
    PassengerCarData findPassengerCarsByCode(String name);
    CargoVehicleData findCargoVehiclesByCode(String name);
}
