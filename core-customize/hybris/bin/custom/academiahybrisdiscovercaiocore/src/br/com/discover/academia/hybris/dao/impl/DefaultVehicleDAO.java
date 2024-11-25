package br.com.discover.academia.hybris.dao.impl;

import java.util.List;

import br.com.discover.academia.hybris.dao.VehicleDAO;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;

import br.com.discover.academia.hybris.model.CargoVehicleModel;
import br.com.discover.academia.hybris.model.PassengerCarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="VehicleDAO")
public class DefaultVehicleDAO implements VehicleDAO {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    //    PassengerCar
    @Override
    public List<PassengerCarModel> findPassengerCars(){
        final String queryString =
                "SELECT {p:" + PassengerCarModel.PK + "} "
                        + "FROM {" + PassengerCarModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        return flexibleSearchService.<PassengerCarModel> search(query).getResult();
    }

    @Override
    public PassengerCarModel findPassengerCarsByCode(String code){
        final String queryString =
                "SELECT {p:" + PassengerCarModel.PK + "} "
                        + "FROM {" + PassengerCarModel._TYPECODE + " AS p} "
                        + "WHERE {p:" + PassengerCarModel.LICENSEPLATE + "}=?code";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        List<PassengerCarModel> results = flexibleSearchService.<PassengerCarModel>search(query).getResult();

        return results.isEmpty() ? null : results.get(0);
    }

    //    CargoVehicle
    @Override
    public List<CargoVehicleModel> findCargoVehicles(){
        final String queryString =
                "SELECT {p:" + CargoVehicleModel.PK + "} "
                        + "FROM {" + CargoVehicleModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        return flexibleSearchService.<CargoVehicleModel> search(query).getResult();
    }

    @Override
    public CargoVehicleModel findCargoVehiclesByCode(String code) {
        final String queryString =
                "SELECT {p:" + CargoVehicleModel.PK + "} "
                        + "FROM {" + CargoVehicleModel._TYPECODE + " AS p} "
                        + "WHERE {p:" + CargoVehicleModel.LICENSEPLATE + "}=?code";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        List<CargoVehicleModel> results = flexibleSearchService.<CargoVehicleModel>search(query).getResult();

        return results.isEmpty() ? null : results.get(0);
    }
}