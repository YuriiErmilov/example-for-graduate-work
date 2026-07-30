package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.CommentEntity;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий комментариев.
 */
public interface CommentRepository
        extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByAdIdOrderByCreatedAtAsc(Long adId);

    Optional<CommentEntity> findByIdAndAdId(
            Long commentId,
            Long adId
    );
}