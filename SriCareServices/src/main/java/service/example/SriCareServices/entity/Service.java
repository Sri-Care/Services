package service.example.SriCareServices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue
    private Integer serviceId;
    private String serviceName;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getChargePerMonth() {
        return chargePerMonth;
    }

    public void setChargePerMonth(Integer chargePerMonth) {
        this.chargePerMonth = chargePerMonth;
    }

    public String getServiceDetails() {
        return ServiceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        ServiceDetails = serviceDetails;
    }

    public Set<UserService> getUserService() {
        return userService;
    }

    public void setUserService(Set<UserService> userService) {
        this.userService = userService;
    }

    private Integer chargePerMonth;
    private String ServiceDetails;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<UserService> userService = new HashSet<>();

}


