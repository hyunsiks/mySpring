package com.kgitbank.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Employee;

public interface EmployeeMapper {

	//1�� ���
	//�������� �־��ְ� ������ List<Employee> Ÿ������ ������� �ϴ°�
	@Select("SELECT * FROM employees")
	public List<Employee> getEmpList();

	//2�� ���
	//XML������ �̿��� ��� (resultType�̿� / �� ���� ����ϴ� ���)
	public List<Employee> getEmpList2();
	
	//3�� ���(�ϳ��� ������)
	public Employee getEmployee(int id);
	
	//insert �� ��(�����ϸ� 1, �����ϸ� 0 ����)
	public int create(Employee e);
}
		
