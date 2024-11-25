package br.com.discover.academia.hybris.service.impl;

import br.com.discover.academia.hybris.dao.VehicleDAO;
import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import br.com.discover.academia.hybris.service.VehicleService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultVehicleService implements VehicleService {
    private VehicleDAO vehicleDAO;

    //    PassengerCar
    @Override
    public List<PassengerCarModel> findPassengerCars(){
        return vehicleDAO.findPassengerCars();
    }

    @Override
    public PassengerCarModel findPassengerCarsByCode(String code) throws AmbiguousIdentifierException, UnknownIdentifierException {
        final PassengerCarModel result = vehicleDAO.findPassengerCarsByCode(code);
        if(result == null) {
            throw new UnknownIdentifierException("Band with code '" + code + "' not found!");
        } else {
            return vehicleDAO.findPassengerCarsByCode(code);
        }
    }

    //    CargoVehicle
    @Override
    public List<CargoVehicleModel> findCargoVehicles(){
        return vehicleDAO.findCargoVehicles();
    }

    @Override
    public CargoVehicleModel findCargoVehiclesByCode(String code) throws AmbiguousIdentifierException, UnknownIdentifierException {
        final CargoVehicleModel result = vehicleDAO.findCargoVehiclesByCode(code);
        if(result == null) {
            throw new UnknownIdentifierException("Band with code '" + code + "' not found!");
        } else {
            return vehicleDAO.findCargoVehiclesByCode(code);
        }
    }

    @Required
    public void setVehicleDAO(final VehicleDAO vehicleDAO)
    {
        this.vehicleDAO = vehicleDAO;
    }
}
