package com.kgitbank.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kgitbank.model.Department;
import com.kgitbank.model.Employee;

import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MybatisTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void test() {

		try(
			SqlSession session = sqlSessionFactory.openSession();	
			Connection conn = session.getConnection();
		){
			log.info(conn);
			assertNotNull(conn);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void getListTest() {
		List<Employee> employees = employeeMapper.getEmpList();
		
		if(employees.size() == 0) {
			fail("æ»≤®≥ª¡≥¥Ÿ ¿Ã¥Ææ∆");
		}
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void getDepartmentTest() {
		List<Department> departments = departmentMapper.getDepList();
		
		if(departments.size() == 0) {
			fail("æ»≤®≥ª¡≥¥Ÿ ¿Ã¥Ææ∆");
		}
		
		for(Department department : departments) {
			System.out.println(department);
		}
	}
	

	@Test
	public void getListTest2() {
		List<Employee> employees = employeeMapper.getEmpList2();
		
		if(employees.size() == 0) {
			fail("æ»≤®≥ª¡≥¥Ÿ ¿Ã¥Ææ∆");
		}
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	@Test
	public void getEmployee() {
		Employee employee = employeeMapper.getEmployee(190);
		
		assertNotNull(employee);
		System.out.println("»Æ¿Œ : " + employee);
	}
	
	@Test
	public void createEmployee() {
		
		Employee e = new Employee(
				"Minsu","KMinsu",new Date(), "IT_PROG");
		
		int row = employeeMapper.create(e);
		
		assertEquals(1, row);
	}
	
}
