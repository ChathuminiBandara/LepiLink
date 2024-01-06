package lk.ijse.bo.Custom.Impl;

import lk.ijse.bo.Custom.EmployeeBO;
import lk.ijse.dao.Custom.EmployeeDAO;
import lk.ijse.dao.Custom.Impl.EmployeeDaoImpl;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dto.employeeDto;
import lk.ijse.entity.employee;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public boolean update(employeeDto dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new employee(dto.getEId(),dto.getEName(),dto.getTP(),dto.getStartedDate(),dto.getESrt()));
    }

    boolean ArrayList<employeeDto> getAllEmployee() throws SQLException,ClassNotFoundException{
        ArrayList<employee> employees  = EmployeeDAO.getAll();
        ArrayList<employeeDto> employeeDtos = new ArrayList<>();

        for(employee employeeDtos : employees){
            employeeDtos.add(employee.geteId(),employee.geteName(),employee.geteSrt(),employee.getStartedDate(),employee.getContact()));
        }
        return employeeDtos;
    }



}
