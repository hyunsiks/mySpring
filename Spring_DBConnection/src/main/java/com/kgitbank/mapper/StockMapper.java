package com.kgitbank.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kgitbank.model.Stock;

public interface StockMapper {

	//1�� ���
	//�������� �־��ְ� ������ List<Employee> Ÿ������ ������� �ϴ°�
	@Select("SELECT * FROM stock")
	public List<Stock> getStockLi();

	//2�� ���
	//XML������ �̿��� ��� (resultType�̿� / �� ���� ����ϴ� ���)
	public List<Stock> getStockList();
	
	//3�� ���(�ϳ��� ������)
	public Stock getStock(int id);
	
	//insert �� ��(�����ϸ� 1, �����ϸ� 0 ����)
	public int insertStock(Stock e);
	public int deleteStock(Stock e);
	public int changeStock(Stock e);
}
