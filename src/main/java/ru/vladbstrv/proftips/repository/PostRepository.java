package ru.vladbstrv.proftips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vladbstrv.proftips.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
