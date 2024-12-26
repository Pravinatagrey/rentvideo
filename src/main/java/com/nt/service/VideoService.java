package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Video;

public interface VideoService {

	List<Video> getAllVideos();
	Video saveVideo(Video video) ;
	void deleteVideo(Long id);
	Optional<Video> updateVideo(Long id, Video updatedVideo);
}
