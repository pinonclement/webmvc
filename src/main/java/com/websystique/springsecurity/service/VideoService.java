package com.websystique.springsecurity.service;

import java.util.List;

import com.websystique.springsecurity.model.Video;

public interface VideoService {

	public void addVideo(Video a);
	public Video getVideoById(int id);
	public Video getVideoByName(String name);
	public List<Video> listVideo();
	public void removeVideo(int id);
	public List<Video> listVideoByDurée(String name);
	public List<Video> listVideoByDate(String name);
	public List<Video> getSoustitre();
}