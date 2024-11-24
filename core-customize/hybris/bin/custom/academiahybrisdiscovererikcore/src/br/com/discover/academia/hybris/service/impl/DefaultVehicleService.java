package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.VehicleDAO;
import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import br.com.discover.academia.hybris.service.VehicleService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultVehicleService implements VehicleService {
    private VehicleDAO vehicleDAO;

    @Override
    public List<PassengerCarModel> findPassengerCars(){
        return vehicleDAO.findPassengerCars();
    }

    @Override
    public List<CargoVehicleModel> findCargoVehicles(){
        return vehicleDAO.findCargoVehicles();
    }

    @Override
    public PassengerCarModel findPassengerCarsByCode(String code)
    {
        return vehicleDAO.findPassengerCarsByCode(code);
    }

    @Override
    public CargoVehicleModel findCargoVehiclesByCode(String code){
        return vehicleDAO.findCargoVehiclesByCode(code);
    }

    @Required
    public void setVehicleDAO(final VehicleDAO vehicleDAO)
    {
        this.vehicleDAO = vehicleDAO;
    }
}
