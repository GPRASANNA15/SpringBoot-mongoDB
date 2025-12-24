package com.example.demo.Service;
import com.example.demo.DTO.empDto;
import com.example.demo.Entity.empEntity;
import com.example.demo.Repository.EmpRepository;
import com.example.demo.ServiceMethods.ServiceMethod;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements ServiceMethod {
    private EmpRepository empRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmpRepository empRepository, ModelMapper modelMapper) {
        this.empRepository = empRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public empDto createEmployee(empDto emp) {
        empEntity entity=new empEntity();
        entity.setEmployeeName(emp.getEmployeeName());
        entity.setEmployeeEmail(emp.getEmployeeEmail());
        entity.setLocation(emp.getLocation());
         empEntity savedemp= empRepository.save(entity);
       empDto e=modelMapper.map(savedemp,empDto.class);
        return e;
    }

    @Override
    public List<empDto> getEmployees() {
        List<empDto> result=new ArrayList<>();
         Iterable<empEntity> employees= empRepository.findAll();
         for(empEntity i:employees){
             result.add(modelMapper.map(i,empDto.class));
//             System.out.println(i.getId());
         }

        return result;
    }

    @Override
    public empDto getEmployeeById(String id) {
        Optional<empEntity> employee= empRepository.findById(id);
        if(employee.isEmpty())
        {
            throw new RuntimeException("not found");
        }
        return modelMapper.map(employee,empDto.class);
    }
}
