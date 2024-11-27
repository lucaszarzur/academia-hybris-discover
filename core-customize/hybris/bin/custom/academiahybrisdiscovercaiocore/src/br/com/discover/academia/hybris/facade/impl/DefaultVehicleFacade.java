package br.com.discover.academia.hybris.facade.impl;

import br.com.discover.academia.hybris.data.CargoVehicleData;
import br.com.discover.academia.hybris.data.PassengerCarData;
import br.com.discover.academia.hybris.facade.VehicleFacade;
import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import br.com.discover.academia.hybris.model.VehicleModel;
import br.com.discover.academia.hybris.service.VehicleService;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class DefaultVehicleFacade implements VehicleFacade {
    private VehicleService vehicleService;

    @Override
    public List<PassengerCarData> findPassengerCars() {
        final List<PassengerCarModel> vehicleModels = vehicleService.findPassengerCars();
        final List<PassengerCarData> passengerCarFacadeData = new ArrayList<>();

        for (final VehicleModel vm : vehicleModels) {
            final PassengerCarData pcd = new PassengerCarData();
            pcd.setLicensePlate(vm.getLicensePlate());
            pcd.setBrand(vm.getBrand());
            pcd.setColor(vm.getColor());
            pcd.setModel(vm.getModel());
            pcd.setYear(vm.getYear());

            if (vm instanceof PassengerCarModel) {
                pcd.setQtyPassengers(((PassengerCarModel) vm).getQtyPassengers());
            }

            passengerCarFacadeData.add(pcd);
        }

        return passengerCarFacadeData;
    }

    @Override
    public PassengerCarData findPassengerCarsByCode(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Model car name cannot be null");
        }

        final PassengerCarModel passengerCar = vehicleService.findPassengerCarsByCode(name);
        if (passengerCar == null) {
            return null;
        }

//        Lists of brand
        final List<String> brands = new ArrayList<>();
        if(passengerCar.getBrand() != null) {
            brands.add(passengerCar.getLicensePlate());
        }


//        Creating PassengerCarData DTO
        final PassengerCarData passengerCarData = new PassengerCarData();
        passengerCarData.setLicensePlate(passengerCar.getLicensePlate());
        passengerCarData.setBrand(passengerCar.getBrand());
        passengerCarData.setColor(passengerCar.getColor());
        passengerCarData.setModel(passengerCar.getModel());
        passengerCarData.setYear(passengerCar.getYear());
        passengerCarData.setQtyPassengers(passengerCarData.getQtyPassengers());
        return passengerCarData;
    }


//    Cargo Vehicle
    @Override
    public List<CargoVehicleData> findCargoVehicles() {
        final List<CargoVehicleModel> vehicleModels = vehicleService.findCargoVehicles();
        final List<CargoVehicleData> cargoVehicleFacadeData = new ArrayList<>();

        for (final VehicleModel vm : vehicleModels) {
            final CargoVehicleData cvd = new CargoVehicleData();
            cvd.setLicensePlate(vm.getLicensePlate());
            cvd.setBrand(vm.getBrand());
            cvd.setColor(vm.getColor());
            cvd.setModel(vm.getModel());
            cvd.setYear(vm.getYear());

            if (vm instanceof CargoVehicleModel) {
                cvd.setMaxWeight(((CargoVehicleModel) vm).getMaxWeitgh());
            }

            cargoVehicleFacadeData.add(cvd);
        }

        return cargoVehicleFacadeData;
    }

    @Override
    public CargoVehicleData findCargoVehiclesByCode(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Model car name cannot be null");
        }

        final CargoVehicleModel cargoVehicle = (CargoVehicleModel) vehicleService.findCargoVehiclesByCode(name);
        if(cargoVehicle == null) {
            return null;
        }

        //        Lists of brand
        final List<String> brands = new ArrayList<>();
        if(cargoVehicle.getBrand() != null) {
            brands.add(cargoVehicle.getLicensePlate());
        }

        //        Creating VehicleCargo DTO
        final CargoVehicleData cargoVehicleData = new CargoVehicleData();
        cargoVehicleData.setLicensePlate(cargoVehicleData.getLicensePlate());
        cargoVehicleData.setBrand(cargoVehicleData.getBrand());
        cargoVehicleData.setColor(cargoVehicleData.getColor());
        cargoVehicleData.setModel(cargoVehicleData.getModel());
        cargoVehicleData.setYear(cargoVehicleData.getYear());
        cargoVehicleData.setMaxWeight(cargoVehicleData.getMaxWeight());
        return cargoVehicleData;
    }

    @Required
    public void setVehicleService(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
}
