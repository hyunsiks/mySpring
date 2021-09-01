package com.kgitbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Department;

public interface DepartmentMapper {

	@Select("SELECT * FROM departments where department_id > 200")
	public List<Department> getDepList();
}
