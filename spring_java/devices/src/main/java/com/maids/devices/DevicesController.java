package com.maids.devices;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import java.net.URI;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class DevicesController {
    private final DevicesService DevicesService;
 
    @Autowired
    public DevicesController(DevicesService DevicesService) {
        this.DevicesService = DevicesService;
    }
 
    /**
     * Create a new Devices.
     *
     * @param Devices the Devices to create
     * @return the ResponseEntity with status 200 (OK) and with body of the new Devices
     */
    @PostMapping("/saveDevice")
    public ResponseEntity<Devices> saveDevices(@RequestBody Devices Devices) {
        Devices newDevices = DevicesService.saveDevice(Devices);
        return ResponseEntity.ok(newDevices);
    }
 
    /**
     * Get all Devices.
     *
     * @return the ResponseEntity with status 200 (OK) and with body of the list of Devices
     */
    @GetMapping("/Devices")
    public List<Devices> getAllDevices() {
        return DevicesService.getAllDevices();
    }
 
    /**
     * Get a Devices by ID.
     *
     * @param id the ID of the Devices to get
     * @return the ResponseEntity with status 200 (OK) and with body of the Devices, or with status 404 (Not Found) if the Devices does not exist
     */
    @GetMapping("/Devices/{id}")
    public ResponseEntity<Devices> getDeviceById(@PathVariable Long id) {
        Optional<Devices> Devices = DevicesService.getDeviceById(id);
        return Devices.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
 
 
    /**
     * Delete a Devices by ID.
     *
     * @param id the ID of the Devices to delete
     * @return the ResponseEntity with status 200 (OK) and with body of the message "Devices deleted successfully"
     */
    @DeleteMapping("/Devices/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable Long id) {
        DevicesService.deleteDevice(id);
        return ResponseEntity.ok("Device deleted successfully");
    }
    
}
