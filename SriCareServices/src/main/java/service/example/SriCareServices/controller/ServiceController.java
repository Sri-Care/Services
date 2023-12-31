package service.example.SriCareServices.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.example.SriCareServices.dto.ServiceDTO;
import service.example.SriCareServices.entity.Service;
import service.example.SriCareServices.repository.ServiceRepository;
import service.example.SriCareServices.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceRepository serviceRepository; // Use constructor injection
    private final ServiceService serviceService;

    @PostMapping("/create")
    public Service createService(@RequestBody Service service) {
        Service savedService = serviceRepository.save(service);
        return savedService;
    }

    @GetMapping("/servicelist")
    public List<ServiceDTO> getservicelist() {
        return serviceService.serviceList();
    }
}
