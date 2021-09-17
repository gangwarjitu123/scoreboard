package com.service.Impl;
import com.Type.PlayerStatus;
import com.Type.PlayerType;
import com.commands.CommandExecutor;
import com.commands.CommandFactory;
import com.dao.MatchServiceDao;
import com.db.Database;
import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;
import com.domain.ScoreBoard;
import com.factory.PlayerFactor;
import com.request.MatchCreateRequest;
import com.service.MatchService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.CRC32;


public class MatchServiceImpl implements MatchService {

    private MatchServiceDao matchServiceDao ;

    public MatchServiceImpl(MatchServiceDao matchServiceDao){
        this.matchServiceDao = matchServiceDao;
    }

    @Override
    public void createMatch(MatchCreateRequest matchCreateRequest) {
        Match match = new Match();
        match.setFirstTeam(matchCreateRequest.getFirstTeamName());
        match.setSecondTeam(matchCreateRequest.getSecondTeamName());
        match.setNumberOfOver(matchCreateRequest.getNumberOfOvers());
        match.setNumberOfPlayer(matchCreateRequest.getNumberOfPlayer());
        matchServiceDao.createMatch(match);
    }

    @Override
    public void createBattingOrderForMatch(String matchKey, String teamName, List<String> playerOrder) {
      Match match =   matchServiceDao.getMatchKey(matchKey);
      List<Player> players = match.getBattingOrder().getOrDefault(teamName,new ArrayList<>());
      playerOrder.forEach(player->{
          Player playerDb = PlayerFactor.getPlayer(PlayerType.BATSMAN.name());
          playerDb.setName(player);
          playerDb.setId(player);
          players.add(playerDb);
      });
        match.getBattingOrder().put(teamName,players);
        //System.out.println("player order for team " + teamName + "is created "+ match);
    }


    @Override
    public void bowled(int overNumber, String command,String matchKey) {
        Match match =   matchServiceDao.getMatchKey(matchKey);
        if(!match.isMatchStarted()){
            ScoreCard.InningType inningType = ScoreCard.InningType.FIRST;
            createInning(matchKey,match,match.getFirstTeam(),match.getScoreCard(),inningType);
        }
       ScoreCard.InningType currentInningType=  match.getScoreCard().getCurrentInningType();
        if(currentInningType!=null && currentInningType!= ScoreCard.InningType.SECOND && match.isMatchStarted() && match.getScoreCard().isFirstInningCompleted()){
            ScoreCard.InningType inningType = ScoreCard.InningType.SECOND;
            createInning(matchKey,match,match.getSecondTeam(),match.getScoreCard(),inningType);
        }
        CommandExecutor commandExecutor = CommandFactory.getCommandExecutor(command);
        commandExecutor.execute(command,match);

    }

    @Override
    public void getScoreBoard(String matchKey,String teamName) {
        Match match =  Database.matchMap.get(matchKey);
        System.out.println("Scorecard for Team " + teamName);
        ScoreCard.ScoreCardInning scoreCardInning =  match.getScoreCard().getScoreCardInningMap().get(match.getScoreCard().getCurrentInningType());
        Queue<Player> outPlayer = scoreCardInning.getOutPlayer().get(teamName);
        System.out.println("player Name "+ " score " + " 4s " + " 6s " + " ball ");

        int outCount =0;
        if(outPlayer!=null && !outPlayer.isEmpty()){
            outCount =outPlayer.size();
        }

        List<Player> allPlayer = match.getBattingOrder().get(teamName);
        String playerName ="";
        for (Player player : allPlayer){
            playerName = player.getId();
            if(player.getPlayerStatus()==PlayerStatus.BATTING){
                playerName =   playerName+"*";
            }
            System.out.println(playerName+ "  "+ player.getTotalRun() + "  "+ player.getFourCount() + "  "+ player.getSixCount() + "  "+ player.getTotalBall());
        }

        System.out.println("Total :"+ scoreCardInning.getTotalRun()+ "/"+outCount);
        System.out.println("Overs :"+ scoreCardInning.getTotalOver());
        System.out.println("extra " + scoreCardInning.getExtra());
        System.out.println(match.getFirstTeam() + " inning = "+scoreCardInning.getInningStatus());

    }

    private void createInning(String matchKey,Match match,String teamName,ScoreCard scoreCardInput, ScoreCard.InningType inningType){
        ScoreCard scoreCard =scoreCardInput;
        scoreCard.setMatchKey(matchKey);
        ScoreCard.ScoreCardInning scoreCardInning =  new ScoreCard.ScoreCardInning();
        scoreCard.getScoreCardInningMap().put(inningType,scoreCardInning);
        scoreCard.setFirstInningCompleted(false);
        scoreCard.setCurrentInningType(inningType);
        Player onStrike = match.getBattingOrder().get(teamName).get(0);
        onStrike.setPlayerStatus(PlayerStatus.BATTING);
        scoreCardInning.setOnStrike(onStrike);
        scoreCardInning.setInningStatus("progress");
        Player nonStrike = match.getBattingOrder().get(teamName).get(1);
        nonStrike.setPlayerStatus(PlayerStatus.BATTING);
        scoreCardInning.setNonStrike(nonStrike);
        scoreCardInning.setNextPlayerIndex(2);
        scoreCard.setCurrentInningType(inningType);
        match.setMatchStarted(true);
        match.setScoreCard(scoreCard);
    }

}
