package br.com.discover.academia.hybris.dao;
import java.util.List;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import br.com.discover.academia.hybris.model.CargoVehicleModel;

public interface VehicleDAO
{
    List<PassengerCarModel> findPassengerCars();
    List<CargoVehicleModel> findCargoVehicles();
    PassengerCarModel findPassengerCarsByCode(String code);
    CargoVehicleModel findCargoVehiclesByCode(String code);
}