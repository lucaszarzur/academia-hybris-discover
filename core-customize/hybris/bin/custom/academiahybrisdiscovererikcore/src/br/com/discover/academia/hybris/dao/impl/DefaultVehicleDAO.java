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

    @Override
    public List<PassengerCarModel> findPassengerCars(){
        // Build a query for the flexible search.
        final String queryString = //
                "SELECT {p:" + PassengerCarModel.PK + "} "//
                        + "FROM {" + PassengerCarModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        // Note that we could specify paginating logic by providing a start and count variable (commented out below)
        // This can provide a safeguard against returning very large amounts of data, or hogging the database when there are
        // for example millions of items being returned.
        // As we know that there are only a few persisted bands in this use case we do not need to provide this.
        //query.setStart(start);
        //query.setCount(count);
        // Return the list of BandModels.
        return flexibleSearchService.<PassengerCarModel> search(query).getResult();
    }

    @Override
    public List<CargoVehicleModel> findCargoVehicles(){
        // Build a query for the flexible search.
        final String queryString = //
                "SELECT {p:" + CargoVehicleModel.PK + "} "//
                        + "FROM {" + CargoVehicleModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        // Note that we could specify paginating logic by providing a start and count variable (commented out below)
        // This can provide a safeguard against returning very large amounts of data, or hogging the database when there are
        // for example millions of items being returned.
        // As we know that there are only a few persisted bands in this use case we do not need to provide this.
        //query.setStart(start);
        //query.setCount(count);
        // Return the list of BandModels.
        return flexibleSearchService.<CargoVehicleModel> search(query).getResult();
    }

    @Override
    public PassengerCarModel findPassengerCarsByCode(String code){
        final String queryString = //
                "SELECT {p:" + PassengerCarModel.PK + "} " //
                        + "FROM {" + PassengerCarModel._TYPECODE + " AS p} " //
                        + "WHERE {p:" + PassengerCarModel.LICENSEPLATE + "}=?code";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        List<PassengerCarModel> results = flexibleSearchService.<PassengerCarModel>search(query).getResult();

        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public CargoVehicleModel findCargoVehiclesByCode(String code) {
        final String queryString = //
                "SELECT {p:" + CargoVehicleModel.PK + "} "//
                        + "FROM {" + CargoVehicleModel._TYPECODE + " AS p} "//
                        + "WHERE {p:" + CargoVehicleModel.LICENSEPLATE + "}=?code";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        List<CargoVehicleModel> results = flexibleSearchService.<CargoVehicleModel>search(query).getResult();

        return results.isEmpty() ? null : results.get(0);
    }
}
