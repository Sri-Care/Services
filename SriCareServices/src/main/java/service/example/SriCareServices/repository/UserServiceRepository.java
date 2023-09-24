package service.example.SriCareServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.example.SriCareServices.entity.UserService;

public interface UserServiceRepository extends JpaRepository<UserService, Integer> {
}
