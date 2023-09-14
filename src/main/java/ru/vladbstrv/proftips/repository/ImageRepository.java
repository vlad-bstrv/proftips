package ru.vladbstrv.proftips.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vladbstrv.proftips.model.Image;

import java.util.Optional;

public interface ImageRepository  //extends JpaRepository<Image, Long>
{
//    @Transactional
//    Optional<Image> findByName(String fileName);
}
