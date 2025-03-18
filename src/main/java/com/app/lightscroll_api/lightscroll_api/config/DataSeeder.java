package com.app.lightscroll_api.lightscroll_api.config;

import com.app.lightscroll_api.lightscroll_api.models.Novel;
import com.app.lightscroll_api.lightscroll_api.repositories.NovelRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(NovelRepository novelRepository) {
        return args -> {
            Faker faker = new Faker();
            Random random = new Random();

            for (int i = 0; i < 30; i++) {
                Novel novel = new Novel();
                novel.setTitle(truncate(faker.book().title(), 255));  // Ensure title length
                novel.setDescription(faker.lorem().sentence(10)); // Shorter description
                novel.setGenre(truncate(faker.book().genre(), 50)); // Genre should be short
                novel.setAuthorId(random.nextLong(100));
                novel.setImageUrl(truncate("https://picsum.photos/300/400?random=" + i, 255));

                novelRepository.save(novel);
            }
        };
    }

    private String truncate(String text, int length) {
        return text.length() > length ? text.substring(0, length) : text;
    }
}
