package service.example.SriCareServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.example.SriCareServices.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
