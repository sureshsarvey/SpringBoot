package com.boot.database.testrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.database.test.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
