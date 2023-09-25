package service.example.SriCareServices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.example.SriCareServices.dao.ServiceJDBCDao;
import service.example.SriCareServices.dto.ServiceDTO;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceJDBCDao serviceJDBCDao;
    public List<ServiceDTO> serviceList(){
        return serviceJDBCDao.getAllServices();
    }
}
