package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    //define field for entity manager
    private final EntityManager entityManager;
    //set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //execute the query
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        //save or update the employee
        Employee dbEmployee = entityManager.merge(employee);
        //return saved employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //delete the employee
        entityManager.remove(theEmployee);
    }
}
