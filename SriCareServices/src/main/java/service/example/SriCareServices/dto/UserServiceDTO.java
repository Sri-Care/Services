package service.example.SriCareServices.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.example.SriCareServices.enumeration.SubscriptionStatus;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceDTO {
    private LocalDate subscribedDate;
    private LocalDate cancellationDate;
    private SubscriptionStatus subscriptionStatus;
    private Integer serviceId;
    private Integer userId;
}
