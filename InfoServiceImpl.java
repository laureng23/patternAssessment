package com.lauren.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lauren.dao.InfoDAO;
import com.lauren.model.Book;
import com.lauren.model.Info;
import com.lauren.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDAO infoDao;
	
	@Override
	public Info createInfo(Book book, int quantity) {
		Info newInfo = new Info();
		newInfo.setBook(book);
		newInfo.setQuantity(quantity);
		return infoDao.addNewInfo(newInfo);
	}
	
	@Override
	public void updateInfo(Info info) {
		infoDao.updateInfo(info);
	}

	public InfoDAO getInfoDao() {
		return infoDao;
	}

	public void setInfoDao(InfoDAO infoDao) {
		this.infoDao = infoDao;
	}

	
}
