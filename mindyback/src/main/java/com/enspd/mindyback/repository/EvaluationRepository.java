package com.enspd.mindyback.repository;

import com.enspd.mindyback.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface EvaluationRepository extends JpaRepository<Evaluation,Integer> {
    Optional<List<Evaluation>> findAllByLeconIdOrderByCreationDate(Integer idLecon);

    @Query("SELECT e FROM Evaluation e WHERE e.lecon.id = :leconId ORDER BY e.creationDate DESC")
    Optional<Evaluation> findFirstByOOrderByCreationDateDescBy(@Param("leconId") Integer leconId);

    }
