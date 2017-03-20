package com.websystique.springsecurity.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springsecurity.model.Fav;
import com.websystique.springsecurity.dao.FavDao;

@Service
public class FavServiceImpl implements FavService {
	
	@Autowired
	private FavDao favdao;

	@Transactional
	public void setFavDao(FavDao favdao){
		this.favdao=favdao;
	}
	@Transactional
	public FavDao getFavdao() {
		return favdao;
	}
	@Transactional
	public void addFav(Fav v) {
		this.favdao.insert(v);	
	}
	@Transactional
	public List<Fav> listFav(int id) {	
		return this.favdao.findbyUser(id);
	}

	@Transactional
	public void removeFav(int id, int video) {
	this.favdao.delete(id, video);
		
	}

}
