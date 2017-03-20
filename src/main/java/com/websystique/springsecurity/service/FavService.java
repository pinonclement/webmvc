package com.websystique.springsecurity.service;

import java.util.List;
import com.websystique.springsecurity.model.Fav;


public interface FavService {
	public void addFav(Fav v);
	public List<Fav> listFav(int id);
	public void removeFav(int id, int video);
}
