package com.enspd.mindyback.repository;

import com.enspd.mindyback.models.ScenarioScene;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioSceneRepository extends JpaRepository<ScenarioScene,Integer> {
}
