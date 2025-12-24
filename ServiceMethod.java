package com.example.demo.ServiceMethods;

import com.example.demo.DTO.empDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ServiceMethod {
    public empDto createEmployee( empDto emp);
    public List<empDto> getEmployees();
    public empDto getEmployeeById(String id);
}
