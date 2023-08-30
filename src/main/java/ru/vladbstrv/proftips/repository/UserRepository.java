package ru.vladbstrv.proftips.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vladbstrv.proftips.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
