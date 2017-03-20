package com.websystique.springsecurity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.Fav;



@Repository("FavDao")
public class FavDaoImpl extends AbstractDao<Integer,Fav> implements FavDao{

	public void insert(Fav fav) {
		persist(fav);
		
	}

	public void delete(int userid, int idvideo) {
		Query query = getSession().createSQLQuery("delete from Fav where userid = :userid and videoid = :videoid");
		query.setInteger("userid", userid);
		query.setInteger("idvideo", idvideo);
		query.executeUpdate();
	}
		

	@SuppressWarnings("unchecked")
	public List<Fav> findbyVideo(int idvideo) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idvideo", idvideo));
		return (List<Fav>) criteria.list();
	}
	

	@SuppressWarnings("unchecked")
	public List<Fav> findbyUser(int userid) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userid", userid));
		return (List<Fav>) criteria.list();
	}





}
