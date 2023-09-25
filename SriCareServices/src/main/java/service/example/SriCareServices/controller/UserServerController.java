package service.example.SriCareServices.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.example.SriCareServices.entity.UserService;
import service.example.SriCareServices.enumeration.SubscriptionStatus;
import service.example.SriCareServices.repository.UserServiceRepository;

@RestController
@RequestMapping("/api/v1/userServerControl")
@RequiredArgsConstructor
public class UserServerController {

    private final UserServiceRepository userServiceRepository; // Use constructor injection

    @PostMapping("/server_acivated")
    public UserService addUserServer(@RequestBody UserService userService) {
        userService.setSubscriptionStatus(SubscriptionStatus.Active);
        System.out.println("service add");
        return userServiceRepository.save(userService);
    }

//    @PutMapping("/server_acivated/{userId}/{newStatus}")
//    public void updateStatus(
//            @PathVariable Integer userId,
//            @PathVariable Status newStatus
//    ) {
////        System.out.println("not works" +userId);
//        userService.updateUserStatus(userId, newStatus);
//    }

}
