package fr.devoxx.spring.mission;

import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import fr.devoxx.spring.mission.model.Mission;
import fr.devoxx.spring.mission.rest.MissionController;
import fr.devoxx.spring.mission.service.MissionService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=InfinityMissionApplication.class)
public abstract class MissionContractsTest {
	
	@Autowired MissionController missionController;
	
	@MockBean MissionService missionService;
	
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(missionController);
		
		Mission mission = new Mission();
		mission.setId(1);
		mission.setKeeper("Red skull");
		mission.setName("Go and find the Soul Stone!!!!");
		mission.setPlanet("Vomir");
		mission.setStoneId(6);
		
		when(missionService.createNewMission(any(Mission.class))).thenReturn(mission);
	}

}
