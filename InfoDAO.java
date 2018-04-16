package com.lauren.dao;
import com.lauren.model.Info;

public interface InfoDAO {
	
	Info addNewInfo(Info info);
	
	void updateInfo(Info info);
	
	Info getInfoById(int id);
	
}
