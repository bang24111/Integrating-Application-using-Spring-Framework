package com.example.thith_iasf.repository;

import com.example.thith_iasf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor {
    @Query(value = "from Employee where name like %:name% ")
    List<Employee> findEmployeesByName(@Param("name") String employeeName);

}
