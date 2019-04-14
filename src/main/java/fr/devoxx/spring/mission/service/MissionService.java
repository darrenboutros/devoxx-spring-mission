package fr.devoxx.spring.mission.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import fr.devoxx.spring.mission.dao.MissionRepository;
import fr.devoxx.spring.mission.model.Mission;
import fr.devoxx.spring.mission.model.Stone;
import fr.devoxx.spring.mission.utils.NotFoundException;

@Service
public class MissionService {

	@Autowired MissionRepository missionRepository;
	
	@Autowired RestTemplate restTemplate;
	
	public Mission createNewMission(Mission mission) {
		if (checkIftheirExistingStone(mission.getStoneId()))
			return missionRepository.save(mission);
		
		throw new NotFoundException(mission.getStoneId());
	}
	
	private Boolean checkIftheirExistingStone(Integer stoneId) {

		URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/v1/stone/{id}")
				.buildAndExpand(stoneId.toString()).toUri();

		System.out.println(uri);
	
		ResponseEntity<Stone> stone=restTemplate.getForEntity(uri, Stone.class);

		if (stone.getStatusCode()==HttpStatus.OK) {

			if (stone.getBody().getId()==stoneId)
				return true;
		}
		return false;
	}
}
