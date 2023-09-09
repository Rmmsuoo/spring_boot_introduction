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
    // 新規登録処理
    public Employee insert(String name, String department) {
        // 保存したいEntityクラスのインスタンスを作成する
        Employee employee = new Employee();

        // 引数で受けたname, departmentをEmployeeオブジェクトにセットします
        employee.setName(name);
        employee.setDepartment(department);

        // データベースに保存する
        return this.employeeRepository.save(employee);
    }
    // 更新処理
    public Employee update(Integer employeeId, String name, String department) {
        // 更新したいデータを取得する
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.get();

        // Entityクラスのフィールドに更新内容をセットする
        employee.setName(name);
        employee.setDepartment(department);

        // データベースに保存する
        return this.employeeRepository.save(employee);
    }
 // 削除処理
    public void delete(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
