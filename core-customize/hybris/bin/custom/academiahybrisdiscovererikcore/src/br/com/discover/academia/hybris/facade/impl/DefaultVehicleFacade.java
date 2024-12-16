package br.com.discover.academia.hybris.facade.impl;

import br.com.discover.academia.hybris.data.CargoVehicleData;
import br.com.discover.academia.hybris.data.PassengerCarData;
import br.com.discover.academia.hybris.facade.VehicleFacade;
import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import br.com.discover.academia.hybris.service.VehicleService;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class DefaultVehicleFacade implements VehicleFacade {

    private VehicleService vehicleService;

    @Override
    public List<PassengerCarData> findPassengerCars(){
        final List<PassengerCarModel> passengerCarModels = vehicleService.findPassengerCars();
        final List<PassengerCarData> passengerCarFacadeData = new ArrayList<>();

        for (final PassengerCarModel pcm : passengerCarModels)
        {
            final PassengerCarData sfd = new PassengerCarData();
            sfd.setLicensePlate(pcm.getLicensePlate());
            sfd.setBrand(pcm.getBrand());
            sfd.setColor(pcm.getColor());
            sfd.setYear(pcm.getYear());
            sfd.setModel(pcm.getModel());
            sfd.setQtyPassenger(pcm.getQtyPassengers());
            passengerCarFacadeData.add(sfd);
        }
        return passengerCarFacadeData;
    }

    public List<CargoVehicleData> findCargoVehicles(){
        final List<CargoVehicleModel> cargoVehicleModels = vehicleService.findCargoVehicles();
        final List<CargoVehicleData> cargoVehicleFacadeData = new ArrayList<>();

        for (final CargoVehicleModel cvm : cargoVehicleModels)
        {
            final CargoVehicleData sfd = new CargoVehicleData();
            sfd.setLicensePlate(cvm.getLicensePlate());
            sfd.setBrand(cvm.getBrand());
            sfd.setColor(cvm.getColor());
            sfd.setYear(cvm.getYear());
            sfd.setModel(cvm.getModel());
            sfd.setMaxWeight(cvm.getMaxWeitgh());
            cargoVehicleFacadeData.add(sfd);
        }
        return cargoVehicleFacadeData;
    }

    @Override
    public PassengerCarData findPassengerCarsByCode(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("License Plate cannot be null");
        }

        final PassengerCarModel passengerCar = vehicleService.findPassengerCarsByCode(name);
        if (passengerCar == null)
        {
            return null;
        }

        final PassengerCarData passengerCarData = new PassengerCarData();
        passengerCarData.setLicensePlate(passengerCar.getLicensePlate());
        passengerCarData.setModel(passengerCar.getModel());
        passengerCarData.setYear(passengerCar.getYear());
        passengerCarData.setBrand(passengerCar.getBrand());
        passengerCarData.setColor(passengerCar.getColor());
        passengerCarData.setQtyPassenger(passengerCar.getQtyPassengers());
        return passengerCarData;
    }

    public CargoVehicleData findCargoVehiclesByCode(String name){
        if (name == null)
        {
            throw new IllegalArgumentException("Band name cannot be null");
        }

        final CargoVehicleModel cargoVehicle = vehicleService.findCargoVehiclesByCode(name);
        if (cargoVehicle == null)
        {
            return null;
        }

        final CargoVehicleData cargoVehicleData = new CargoVehicleData();
        cargoVehicleData.setLicensePlate(cargoVehicle.getLicensePlate());
        cargoVehicleData.setBrand(cargoVehicleData.getBrand());
        cargoVehicleData.setYear(cargoVehicleData.getYear());
        cargoVehicleData.setColor(cargoVehicleData.getColor());
        cargoVehicleData.setModel(cargoVehicleData.getModel());
        cargoVehicleData.setMaxWeight(cargoVehicleData.getMaxWeight());
        return cargoVehicleData;
    }

    @Required
    public void setVehicleService(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
}
