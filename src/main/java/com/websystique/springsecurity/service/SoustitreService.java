package com.websystique.springsecurity.service;

import java.util.List;
import com.websystique.springsecurity.model.Soustitre;

public interface SoustitreService {
	
	public void addSoustitre(Soustitre soustitre); 
	public List<Soustitre> listSoustitre(int id);
	public void removeSoustitre(int id);
	
}
