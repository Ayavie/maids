package com.maids.devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class DevicesService {

    private final DevicesRepository DevicesRepository;
 
    @Autowired
    public DevicesService(DevicesRepository DeviceRepository) {
        this.DevicesRepository = DeviceRepository;
    }
 
 
    /**
     * Save a Device.
     *
     * @param Device the entity to save
     * @return the persisted entity
     */
    public Devices saveDevice(Devices Device) {
        return DevicesRepository.save(Device);
    }
 
    /**
     * Get all the Devices.
     *
     * @return the list of entities
     */
    public List<Devices> getAllDevices() {
        return DevicesRepository.findAll();
    }
 
    /**
     * Get one Device by ID.
     *
     * @param id the ID of the entity
     * @return the entity
     */
    public Optional<Devices> getDeviceById(Long id) {
        return DevicesRepository.findById(id);
    }
    /**
     * Delete the Device by ID.
     * @param id the ID of the entity
     * @return void
     */
    public void deleteDevice(Long id) {
        DevicesRepository.deleteById(id);
    }

    
}
