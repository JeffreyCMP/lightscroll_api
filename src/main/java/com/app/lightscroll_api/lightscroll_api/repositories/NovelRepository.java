package com.app.lightscroll_api.lightscroll_api.repositories;

import com.app.lightscroll_api.lightscroll_api.models.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelRepository extends JpaRepository<Novel, Long> {
}
