package com.example.employee.resource;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeResponse;
import com.example.employee.model.Organization;
import com.example.employee.service.EmployeeInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/employeInfo")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService service;

    @PostMapping("api/v6/create")
    public Mono<EmployeeResponse> save(@Valid @RequestBody Employee employee){

        return  this.service.create(employee);
    }

    @GetMapping("api/v6/getEmployees")
    public Flux<Employee> getEmployees()
    {
        return this.service.retriveEmpDetails();
    }

    @PutMapping("api/v6/updateEmployee")
    public Mono<Employee> updateEmployee(@Valid @RequestBody Employee employee){

        return this.service.updateEmployee(employee);
    }

    @DeleteMapping("api/v6/delete/{id}")
    public Mono<Employee> deleteEmployee(@PathVariable("id")  String id ){

        return this.service.deleteEmployee(id);
    }
}
