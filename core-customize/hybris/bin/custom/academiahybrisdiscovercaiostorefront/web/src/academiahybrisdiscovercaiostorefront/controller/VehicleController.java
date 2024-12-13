package academiahybrisdiscovercaiostorefront.controller;

import br.com.discover.academia.hybris.data.PassengerCarData;
import br.com.discover.academia.hybris.facade.VehicleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class VehicleController {

    private VehicleFacade vehicleFacade;

    @Autowired
    public void setVehicleFacade(VehicleFacade vehicleFacade) {
        this.vehicleFacade = vehicleFacade;
    }

    @GetMapping("/vehicles")
    public String showVehicles(final Model model) {
        final List<PassengerCarData> vehicles = vehicleFacade.findPassengerCars();

        model.addAttribute("vehicles", vehicles);

        return "VehicleList";
    }

    @GetMapping("/vehicles/{vehicleId}")
    public String showVehicleDetails(@PathVariable final String vehicleId, final Model model) throws UnsupportedEncodingException {
        final String decodedVehicleId = URLDecoder.decode(vehicleId, "UTF-8");

        final PassengerCarData vehicle = vehicleFacade.findPassengerCarsByCode(decodedVehicleId);

        model.addAttribute("vehicle", vehicle);

        return "VehicleDetails";
    }
}