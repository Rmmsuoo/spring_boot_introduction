package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
    // Repositoryをフィールドに用意する
    private final EmployeeRepository employeeRepository;

    // コンストラクタでRepositoryをインジェクションします
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
   
    public List<Employee> findAllEmployee(){
    	return this.employeeRepository.findAll();
    }
    public Employee findEmployee(Integer employeeId) {
    	Optional<Employee>optionalEmployee = this.employeeRepository.findById(employeeId);
    	Employee employee = optionalEmployee.get();
    	return employee;
    }
    // 絞り込み検索
    public List<Employee> findByName(String name) {
        return this.employeeRepository.findByName(name);
    }
}
