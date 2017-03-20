package com.websystique.springsecurity.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springsecurity.dao.SoustitreDao;
import com.websystique.springsecurity.model.Soustitre;

@Service
public class SoustitreImpl implements SoustitreService {

	@Autowired
	private SoustitreDao soustitredao;
	
	@Transactional
	public SoustitreDao getSoustitredao() {
		return soustitredao;
	}
	public void setSoustitredao(SoustitreDao soustitredao) {
		this.soustitredao = soustitredao;
	}
	@Transactional
	public void addSoustitre(Soustitre soustitre) {
		this.soustitredao.insertSoustitre(soustitre);
		
	}
	@Transactional
	public List<Soustitre> listSoustitre(int id) {
		return this.soustitredao.findbyVideos(id);
	}
	@Transactional
	public void removeSoustitre(int id) {
		this.soustitredao.deleteSoustitre(id);
		
	}


}