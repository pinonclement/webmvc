package com.websystique.springsecurity.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springsecurity.model.Note;
import com.websystique.springsecurity.dao.NoteDao;

@Service
public class NoteServiceImpl implements NoteService {
	@Autowired
	private NoteDao notedao;

	@Transactional
	public NoteDao getNotedao() {
		return notedao;
	}
	@Transactional
	public void setNotedao(NoteDao notedao) {
		this.notedao = notedao;
	}

	@Transactional
	public void addnote(Note p) {
		this.notedao.insertNote(p);
		
	}

	@Transactional
	public List<Note> listNote(int sstitreid) {
		return this.notedao.findbySstritre(sstitreid);
	}

	@Transactional
	public void removeNote(int id, int sstitreid) {
		this.notedao.deleteNote(id, sstitreid);
		
	}

}

