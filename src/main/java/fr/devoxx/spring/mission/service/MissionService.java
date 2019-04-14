package fr.devoxx.spring.mission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.devoxx.spring.mission.dao.MissionRepository;
import fr.devoxx.spring.mission.model.Mission;

@Service
public class MissionService {

	@Autowired MissionRepository missionRepository;
	
	public Mission createNewMission(Mission mission) {
		return missionRepository.save(mission);
	}
}
