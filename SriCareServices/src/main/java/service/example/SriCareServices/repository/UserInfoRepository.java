package service.example.SriCareServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.example.SriCareServices.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
}
