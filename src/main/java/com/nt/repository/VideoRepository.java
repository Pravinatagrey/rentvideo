package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
