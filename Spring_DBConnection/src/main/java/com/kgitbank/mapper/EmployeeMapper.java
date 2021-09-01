package com.kgitbank.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

public interface EmployeeMapper {

	//1번 방식
	//쿼리문을 넣어주고 꺼낼때 List<Employee> 타입으로 꺼내라고 하는것
	@Select("SELECT * FROM employees")
	public List<Employee> getEmpList();

	//2번 방식
	//XML파일을 이용한 방식 (resultType이용 / 더 많이 사용하는 방식)
	public List<Employee> getEmpList2();
	
	//3번 방식(하나만 뽑을때)
	public Employee getEmployee(int id);
	
	//insert 할 때(성공하면 1, 실패하면 0 나옴)
	public int create(Employee e);
}
		
