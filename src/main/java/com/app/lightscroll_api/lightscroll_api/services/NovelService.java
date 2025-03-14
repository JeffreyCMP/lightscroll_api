package com.app.lightscroll_api.lightscroll_api.services;

import com.app.lightscroll_api.lightscroll_api.models.Novel;
import com.app.lightscroll_api.lightscroll_api.repositories.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovelService {
    @Autowired
    private NovelRepository novelRepository;

    public List<Novel> getAllNovels() {
        return novelRepository.findAll();
    }

    public Optional<Novel> getNovelById(Long id) {
        return novelRepository.findById(id);
    }

    public Novel createNovel(Novel novel) {
        novel.setCreatedAt(LocalDateTime.now());
        return novelRepository.save(novel);
    }

    public Novel updateNovel(Long id, Novel novelDetails) {
        Novel novel = novelRepository.findById(id).orElseThrow(() -> new RuntimeException("Novel not found"));
        novel.setTitle(novelDetails.getTitle());
        novel.setDescription(novelDetails.getDescription());
        novel.setGenre(novelDetails.getGenre());
        novel.setUpdatedAt(LocalDateTime.now());
        return novelRepository.save(novel);
    }

    public void deleteNovel(Long id) {
        novelRepository.deleteById(id);
    }
}