package ru.vladbstrv.proftips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vladbstrv.proftips.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
