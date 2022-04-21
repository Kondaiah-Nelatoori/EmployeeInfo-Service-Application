package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeResponse;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Component
public class EmployeeInfoService {


    @Autowired
    private WebClient.Builder dbServiceClient;

    public Mono<EmployeeResponse> create(@Valid Employee employee){
        return this.dbServiceClient.build()
                .post()
                .uri( "http://localhost:9090/dbService/api/v6/saveEmployeeInfo")
                .bodyValue(employee)
                .retrieve()
                .bodyToMono(EmployeeResponse.class)
                .doOnError(System.out :: println);
    }

    public Flux<Employee> retriveEmpDetails() {
        return this.dbServiceClient
                .build()
                .get()
                .uri("http://localhost:9090/dbService/api/v6/getEmployeesInfo")
                .retrieve()
                .bodyToFlux(Employee.class)
                .doOnError(System.err :: println);
    }

    public Mono<Employee> updateEmployee(final Employee employee) {
        return this.dbServiceClient
                .build()
                .put()
                .uri("http://localhost:9090/dbService/api/v6/updateEmp")
                .bodyValue(employee)
                .retrieve()
                .bodyToMono(Employee.class)
                .doOnError(System.err :: println);
    }

    public Mono<Employee> deleteEmployee(final String id) {
        return this.dbServiceClient
                .build()
                .delete()
                .uri("http://localhost:9090/dbService/api/v6/delete/{id}")
                .retrieve()
                .bodyToMono(Employee.class)
                .doOnError(System.err :: println);
    }
}
