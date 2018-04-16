package com.lauren.service;

import com.lauren.model.Book;
import com.lauren.model.Info;

public interface InfoService {

	Info createInfo(Book book,int quantity);
	
	void updateInfo(Info info);
}
