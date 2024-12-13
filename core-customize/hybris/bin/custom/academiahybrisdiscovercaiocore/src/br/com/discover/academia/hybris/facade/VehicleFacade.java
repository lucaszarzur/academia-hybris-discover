package br.com.discover.academia.hybris.facade;

import java.util.List;

import br.com.discover.academia.hybris.data.CargoVehicleData;
import br.com.discover.academia.hybris.data.PassengerCarData;

public interface VehicleFacade {
    List<PassengerCarData> findPassengerCars();
    PassengerCarData findPassengerCarsByCode(String name);

    List<CargoVehicleData> findCargoVehicles();
    CargoVehicleData findCargoVehiclesByCode(String name);

}
