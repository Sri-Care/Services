package service.example.SriCareServices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import service.example.SriCareServices.dto.ServiceDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ServiceJDBCDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<ServiceDTO> getAllServices() {
        System.out.println("eeeeeee");
        StringBuffer SQL = new StringBuffer();
        HashMap<String, Object> params = new HashMap<>();
        List<ServiceDTO> tripList = new ArrayList<>();

        SQL.append("SELECT * FROM service");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, rs -> {
            while (rs.next()) {
                ServiceDTO serviceDTO = new ServiceDTO();

                // Corrected setter method calls
                serviceDTO.setServiceId(rs.getInt("service_id"));
                serviceDTO.setServiceName(rs.getString("service_name"));
                serviceDTO.setChargePerMonth(rs.getInt("charge_per_month"));
                serviceDTO.setServiceDetails(rs.getString("service_details"));

                tripList.add(serviceDTO);
                System.out.println("ffffffff");
            }
            return tripList;
        });
    }
}
