package service.example.SriCareServices.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.example.SriCareServices.entity.Service;
import service.example.SriCareServices.entity.UserInfo;
import service.example.SriCareServices.entity.UserService;
import service.example.SriCareServices.enumeration.SubscriptionStatus;
import service.example.SriCareServices.repository.ServiceRepository;
import service.example.SriCareServices.repository.UserInfoRepository;
import service.example.SriCareServices.repository.UserServiceRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/userServerControl")
@RequiredArgsConstructor
public class UserServerController {

    @Autowired
    private UserServiceRepository userServiceRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

//    @PostMapping("/server_acivated/{serviceId}/{userId}")
//    public UserService addUserServer(@PathVariable Integer serviceId,@PathVariable Integer userId, @RequestBody UserService userService) {
//        Integer serviceId = userServiceDTO.getServiceId();
//        Integer userId = userServiceDTO.getUserId();
//        userService.setSubscriptionStatus(SubscriptionStatus.Active);
//        System.out.println("service add");
//        return userServiceRepository.save(userService);
//    }


    @PostMapping("/server_acivated/{serviceId}/{userId}")
    public UserService addUserServer(
            @PathVariable Integer serviceId,
            @PathVariable Integer userId,
            @RequestBody UserService userService) {

        Service service = serviceRepository.findById(serviceId).orElse(null);
        UserInfo user = userInfoRepository.findById(userId).orElse(null);

        if (service != null && user != null) {
            userService.setService(service);
            userService.setUser(user);
            userService.setSubscriptionStatus(SubscriptionStatus.Active);

            return userServiceRepository.save(userService);
        } else {
            return null;
        }
    }


    @PutMapping("/server_deactivated/{userServiceId}")
    public ResponseEntity<Void> updateUserServiceStatusToInactive(@PathVariable Integer userServiceId) {
        Optional<UserService> userServiceOptional = userServiceRepository.findById(userServiceId);

        if (userServiceOptional.isPresent()) {
            UserService userService = userServiceOptional.get();
            userService.setSubscriptionStatus(SubscriptionStatus.InActive);
            userServiceRepository.save(userService);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
