package br.com.ifg.ifeventos.model.dao;

import java.util.List;

public interface IDAO <T, PK> {
	  void save(T t);
	  void remove(T t);
	  void removeById(PK id);
	  void deleteAll(); 
	  T getById(PK id);
	  List<T> getAll();
	  List<T> getPage(int page); 
	  Long count();
	}