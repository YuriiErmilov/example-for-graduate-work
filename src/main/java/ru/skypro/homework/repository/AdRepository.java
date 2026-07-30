package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.AdEntity;

import java.util.List;

/**
 * Репозиторий объявлений.
 */
public interface AdRepository
        extends JpaRepository<AdEntity, Long> {

    List<AdEntity> findAllByOrderByIdDesc();

    List<AdEntity> findAllByAuthorUsernameIgnoreCaseOrderByIdDesc(
            String username
    );
}