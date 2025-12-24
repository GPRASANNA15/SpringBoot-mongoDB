package com.example.demo.Controller;

import com.example.demo.DTO.empDto;
import com.example.demo.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
//@CrossOrigin(origins="http://127.0.0.1:5501/Task5")
public class EmployeeController {
    public EmployeeController( EmployeeService empService) {
        this.empService = empService;
    }

    private EmployeeService empService;

    @PostMapping
    public ResponseEntity<empDto> create(@RequestBody @Valid empDto dto){
     empDto createdEmp=empService.createEmployee(dto);
     return new  ResponseEntity<>(createdEmp, HttpStatus.CREATED);
    }

    @GetMapping("/displayAll")
    public ResponseEntity<List<empDto>> find()
    {
        List<empDto> emplist=empService.getEmployees();
        return new ResponseEntity<>(emplist,HttpStatus.OK);
    }

    @GetMapping("/display/{id}")
    public ResponseEntity<empDto> findById(@PathVariable String id){
        empDto emp=empService.getEmployeeById(id);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }
}
