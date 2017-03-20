package com.websystique.springsecurity.dao;


import java.util.List;

import com.websystique.springsecurity.model.Video;

public interface VideoDao {
	
	void insert(Video video);
	
	Video getVideoById (int id);
	
	List<Video> getAllVideos ();
	
	void deleteVideo(int id);
	
	void update (Video video);
	
	List <Video> getVideoByDate(String parametre1);
	
	List <Video> getVideoByDurée(String parametre1);
	
	List<Video>getLastVideo();
	
	List<Video> getSoustitre();
	
	Video getVideoByName(String name);

}