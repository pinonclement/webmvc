package com.websystique.springsecurity.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.websystique.springsecurity.model.Video;
import com.websystique.springsecurity.dao.VideoDao;

@Service 
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDao videodao;
	
	
	@Transactional
	public VideoDao getVideodao() {
		return videodao;
	}

	@Transactional
	public void setVideodao(VideoDao videodao) {
		this.videodao = videodao;
	}


	@Transactional
	public void addVideo(Video a) {
		this.videodao.insert(a);	
	}
	
	
	@Transactional
	public List<Video> listVideo() {
		return this.videodao.getAllVideos();
	}
	@Transactional
	public void removeVideo(int id) {
		this.videodao.deleteVideo(id);	
	}
	@Transactional
	public List<Video> listVideoByDurée(String name) {
	
		return this.videodao.getVideoByDurée(name);
	}
	@Transactional
	public List<Video> listVideoByDate(String name) {
		// TODO Auto-generated method stub
		return this.videodao.getVideoByDate(name);
	}

	public List<Video> getSoustitre() {
		
		return this.videodao.getSoustitre();
	}

	public Video getVideoByName(String name) {
		// TODO Auto-generated method stub
		return this.videodao.getVideoByName(name);
	}

	public Video getVideoById(int id) {
		// TODO Auto-generated method stub
		return this.videodao.getVideoById(id);
	}

}