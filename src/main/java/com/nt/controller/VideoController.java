package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Video;
import com.nt.service.VideoService;

@RestController
@RequestMapping("/api")
public class VideoController {

	    @Autowired
	    private VideoService videoService;

	    @GetMapping("/videos")
	    public List<Video> getAllVideos() {
	        return videoService.getAllVideos();
	    }

	    @PostMapping("/admin/videos")
	    ResponseEntity<?> createVideo(@RequestBody Video video) {
	    	System.out.println("came");
	         videoService.saveVideo(video);
	         return new ResponseEntity<Video>(video, HttpStatus.CREATED);
	    }

	    @DeleteMapping("/admin/videos/{id}")
	    public void deleteVideo(@PathVariable Long id) {
	        videoService.deleteVideo(id);
	    }
	    
}
