package com.websystique.springsecurity.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import com.websystique.springsecurity.model.Video;

@Transactional
@Repository("VideoDao")
public class VideoDaoImpl extends AbstractDao<Integer,Video> implements VideoDao {

	public void insert(Video video) {
		persist(video);
	}

	public Video getVideoById(int videoid) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("videoid", videoid));
		return (Video) criteria.uniqueResult();
	}

	public void deleteVideo(int videoid) {
		Query query = getSession().createSQLQuery("delete from video where videoid = :videoid");
		query.setInteger("videoid", videoid);
		query.executeUpdate();
		
	}

	public void update(Video video) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Video> getAllVideos() {
		Criteria criteria = createEntityCriteria();
		return (List<Video>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Video> getVideoByDurée(String name){
			 Criteria criteria=createEntityCriteria().add(Restrictions.eq("arc",name)).addOrder(Order.desc("durée"));
		return (List<Video>) criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public List <Video> getVideoByDate(String name){
		Criteria criteria=createEntityCriteria().add(Restrictions.eq("arc",name)).addOrder(Order.desc("datediffusion"));
		return (List<Video>) criteria.list();
	}

	public List<Video> getSoustitre() {
		Criteria criteria=createEntityCriteria().add(Restrictions.eq("issubtitled",false)).addOrder(Order.desc("datediffusion"));
		return (List<Video>) criteria.list();
	}

	public List<Video> getLastVideo() {
		Criteria criteria=createEntityCriteria().addOrder(Order.desc("datediffusion"));
		return (List<Video>) criteria.list();
	}

	public Video getVideoByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nom", name));
		return (Video) criteria.uniqueResult();
	}

}

