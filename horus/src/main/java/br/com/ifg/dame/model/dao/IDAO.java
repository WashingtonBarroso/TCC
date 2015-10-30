package br.com.ifg.dame.model.dao;

import java.util.List;

public interface IDAO <T, PK> {
	  void save(T t);
	  void remove(T t);
	  void removeById(PK id);
	  void deleteAll(); 
	  T getById(PK id);
	  List<T> getAll();
	  Long count();
	}