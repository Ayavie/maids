package com.maids.devices;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;


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


    /**
     * Get predicted price for a device by ID.
     *
     * @param id the ID of the device
     * @return the ResponseEntity with status 200 (OK) and with body of the predicted price,
     *         or with status 404 (Not Found) if the device does not exist,
     *         or with status 500 (Internal Server Error) if there was an error predicting the price
     */
    @GetMapping("/predict/{id}")
    public ResponseEntity<String> predictPrice(@PathVariable Long id) {
        // Retrieve device specifications from the database
        Optional<Devices> deviceOptional = DevicesService.getDeviceById(id);
        if (!deviceOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Devices device = deviceOptional.get();
        ObjectMapper objectMapper = new ObjectMapper();
        RestTemplate  restTemplate = new RestTemplate();

        // Prepare device specifications to send to ML model API
          // Convert device object to JSON
       
          try {
            // Convert device object to JSON
            String deviceJson = objectMapper.writeValueAsString(device);
    
            // Set request headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> requestEntity = new HttpEntity<>(deviceJson, headers);
    
            // Make a request to the ML model API to get the predicted price
            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:5000/predict", requestEntity, String.class);
    
            if (response.getStatusCode() == HttpStatus.OK) {
                // Extract predicted price from the response
                return ResponseEntity.ok(response.getBody());
            } else {
                // Handle error
                // Log error message
                System.err.println("Error predicting price. Status code: " + response.getStatusCode());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error predicting price. Status code: " + response.getStatusCode());
            }
        } catch (JsonProcessingException e) {
            // Handle JSON processing error
            // Log error message
            System.err.println("Error converting device object to JSON: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting device object to JSON: " + e.getMessage());
        }
    }
}