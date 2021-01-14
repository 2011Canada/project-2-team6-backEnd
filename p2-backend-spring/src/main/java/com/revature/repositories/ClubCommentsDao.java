package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Club;
import com.revature.models.ClubComment;

public interface ClubCommentsDao extends JpaRepository<ClubComment, Integer>{

}
