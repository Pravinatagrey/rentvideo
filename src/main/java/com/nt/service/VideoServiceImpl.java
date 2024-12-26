package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Video;
import com.nt.repository.VideoRepository;
@Service
public class VideoServiceImpl implements VideoService {

	 @Autowired
	    private VideoRepository videoRepo;
	@Override
	public List<Video> getAllVideos() {
		return videoRepo.findAll();
	}

	@Override
	public Video saveVideo(Video video) {
		 return videoRepo.save(video);
	}

	@Override
	public void deleteVideo(Long id) {
		  videoRepo.deleteById(id);
	}

	@Override
	public Optional<Video> updateVideo(Long id, Video updatedVideo) {
		//using java stream 
		return videoRepo.findById(id).map(existingVideo -> {
            existingVideo.setTitle(updatedVideo.getTitle());
            existingVideo.setDirector(updatedVideo.getDirector());
            existingVideo.setGenre(updatedVideo.getGenre());
            existingVideo.setAvailable(updatedVideo.isAvailable());
            return videoRepo.save(existingVideo);
        });
	}

}
