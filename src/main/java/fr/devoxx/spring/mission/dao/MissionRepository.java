package fr.devoxx.spring.mission.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.devoxx.spring.mission.model.Mission;

@Repository
public interface MissionRepository extends CrudRepository<Mission, Integer>{

}
