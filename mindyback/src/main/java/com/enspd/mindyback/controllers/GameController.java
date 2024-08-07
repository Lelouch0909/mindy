package com.enspd.mindyback.controllers;

import com.enspd.mindyback.controllers.api.GameApi;
import com.enspd.mindyback.dto.GameDto;
import com.enspd.mindyback.dto.LeconDto;
import com.enspd.mindyback.models.Communication;
import com.enspd.mindyback.models.Scenario;
import com.enspd.mindyback.models.type.CompetenceType;
import com.enspd.mindyback.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.enspd.mindyback.config.Utils.GAME_ENDPOINT;


@RestController(GAME_ENDPOINT)
public class GameController implements GameApi {

    @Autowired
    private ScenarioService scenarioService;

    @Autowired
    private CommunicationService communicationService;

    @Autowired
    private LeconService leconService;

    @Autowired
    private CompetenceService competenceService;

    @Autowired
    private GameService gameService;

    @Override
    public List<GameDto> createLeconGames(Integer leconId, String jwt) {
        return gameService.createLeconGames(leconId, jwt);
    }

    /*

    @Override
    public List<Scenario> createLeconScenarioGames(Integer leconId, String jwt) {
        LeconDto lecon = leconService.findLecon(leconId);

        CompetenceType competenceType = leconService.findLeconCompetenceType(leconId);
        List<Scenario> scenarios = scenarioService.createScenarios(LeconDto.toEntity(lecon), jwt);
        for (Scenario scenario : scenarios) {
            scenario.setLecon(null);
        }
        return scenarios;
    }


    @Override
    public List<Communication> createLeconCommunicationGames(Integer leconId, String jwt) {
        LeconDto lecon = leconService.findLecon(leconId);

        List<Communication> communications = communicationService.createCommunications(LeconDto.toEntity(lecon), jwt);
        communications.forEach((communication -> {
            communication.setLecon(null);
        }));
        return communications;
    }

*/
    @Override
    public Scenario findGameScenarioById(Integer id) {
        return scenarioService.findScenario(id);
    }

    @Override
    public Communication findGameCommunicationById(Integer id) {
        return communicationService.findCommunication(id);
    }

}
