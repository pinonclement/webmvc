package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Note;


@Repository("NoteDao")
public class NoteDaoImpl extends AbstractDao<Integer,Note> implements NoteDao {

	public void insertNote(Note note) {
		persist(note);
		
	}

	public void deleteNote(int userid, int sstitreid) {
		Query query = getSession().createSQLQuery("delete from Note where userid = :userid and sstitreid = :sstitreid");
		query.setInteger("userid", userid);
		query.setInteger("sstitreid", sstitreid);
		query.executeUpdate();
		
		
	}


	@SuppressWarnings("unchecked")
	public List<Note> findbySstritre(int sstitreid) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("sstitreid", sstitreid));
		return (List<Note>) criteria.list();
	
	}

	public void updateNote(int score) {
		
	}

	public Note findbyId() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
