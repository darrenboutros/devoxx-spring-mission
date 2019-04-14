package fr.devoxx.spring.mission.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.devoxx.spring.mission.model.Mission;
import fr.devoxx.spring.mission.service.MissionService;

@RestController
@RequestMapping("/v1")
public class MissionController {
	
	@Autowired MissionService missionService;
	
	@PostMapping("/mission")
	@ResponseStatus(HttpStatus.CREATED)
	public Mission createNewMission(@RequestBody Mission mission) {
		return missionService.createNewMission(mission);
	}
}
