package academiahybrisdiscovererikstorefront.controller;

import br.com.discover.academia.hybris.data.PassengerCarData;
import br.com.discover.academia.hybris.data.VehicleData;
import br.com.discover.academia.hybris.facade.VehicleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class VehicleController {

    private VehicleFacade vehicleFacade;

    @RequestMapping(value = "/vehicle")
    public String showVehicles(final Model model)
    {
        final List<PassengerCarData> vehicles = vehicleFacade.findPassengerCars();

        model.addAttribute("vehicles", vehicles);

        return "VehicleList";
    }

    //IMPORTANTE: se tiver dando erro, confira que o metodo findPassengerCarsByCode recebe um nome como parametro, e nao um ID (apesar do DAO tratar como ID e não dever dar erro)
    @RequestMapping(value = "/vehicles/{vehicleId}")
    public String showVehicleDetails(@PathVariable final String vehicleId, final Model model) throws UnsupportedEncodingException
    {
        final String decodedBandId = URLDecoder.decode(vehicleId, "UTF-8");
        final PassengerCarData vehicle = vehicleFacade.findPassengerCarsByCode(decodedBandId);

        model.addAttribute("vehicle", vehicle);

        return "VehicleDetails";
    }

    @Autowired
    public void setFacade(final VehicleFacade facade)
    {
        this.vehicleFacade = facade;
    }
}
