package AngajatiApp.repository;

import AngajatiApp.model.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    private EmployeeMock employeeMock;
    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }

    @Test
    void TC02_testAddEmployeeCNP() {
        Employee employee = new Employee(9, "Maria", "Pop", "123456789012", DidacticFunction.ASISTENT, 3000d);
        assertFalse(employeeMock.addEmployee(employee));
    }

    @Test
    void TC01_testAddEmployeeLastNameAndFirstName() {
        Employee employee = new Employee(9, "Maria", "Pop", "1234567890123", DidacticFunction.ASISTENT, 3000d);
        assertTrue(employeeMock.addEmployee(employee));
    }

    @Test
    void TC02_testAddEmployeeLastNameAndFirstName() {
        Employee employee = new Employee(9, "M", "P", "1234567890123", DidacticFunction.ASISTENT, 3000d);
        assertFalse(employeeMock.addEmployee(employee));
    }

    @Test
    void TC01_testAddEmployeeCNP() {
        Employee employee = new Employee(8, "Ana", "Florea", "1234567890123", DidacticFunction.ASISTENT, 3000d);
        assertTrue(employeeMock.addEmployee(employee));
    }

    @Test
    void TC01_modifyEmployeeFunction() {
        int employeeIdToModify = 2;
        Employee existingEmployee = employeeMock.findEmployeeById(employeeIdToModify);
        assertNotNull(existingEmployee, "Existing employee is null. Employee ID: " + employeeIdToModify);
        assertEquals(DidacticFunction.LECTURER, existingEmployee.getFunction());

        DidacticFunction newFunction = DidacticFunction.ASISTENT;

        employeeMock.modifyEmployeeFunction(existingEmployee, newFunction);

        Employee modifiedEmployee = employeeMock.findEmployeeById(employeeIdToModify);
        assertNotNull(modifiedEmployee, "Modified employee is null. Employee ID: " + employeeIdToModify);
        assertEquals(newFunction,  modifiedEmployee.getFunction());

    }

    @Test
    void TC02_modifyEmployeeFunction() {
        int nonExistingEmployeeId = 999;
        Employee existingEmployee = employeeMock.findEmployeeById(nonExistingEmployeeId);
        assertNull(existingEmployee, "Non-existing employee should be null. Employee ID: " + nonExistingEmployeeId);

        DidacticFunction newFunction = DidacticFunction.ASISTENT;

        employeeMock.modifyEmployeeFunction(existingEmployee, newFunction);

        Employee unmodifiedEmployee = employeeMock.findEmployeeById(nonExistingEmployeeId);
        assertNull(unmodifiedEmployee, "Employee function should remain unchanged for non-existing ID: " + nonExistingEmployeeId);
    }

}