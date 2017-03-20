package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Note;

public interface NoteDao {
	
	void insertNote(Note note);
	
	void deleteNote(int userid, int sstitreid);
	
	List<Note> findbySstritre(int sstitreid);
	
	void updateNote(int score);
	
	Note findbyId();

}