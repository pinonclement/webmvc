package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Fav;

public interface FavDao {
	
	void insert(Fav fav);
	
	void delete(int userid, int idvideo);
	
	
	List<Fav> findbyVideo(int idvideo);
	
	List<Fav> findbyUser(int iduser);
	

}
