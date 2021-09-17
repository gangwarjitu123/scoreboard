package com.commands;

import com.Type.PlayerStatus;
import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;

import java.util.LinkedList;
import java.util.Queue;

public class WicketCommandExecutor extends CommandExecutor{

    @Override
    public void execute(String ballMetaData, Match match) {
        ScoreCard.ScoreCardInning scoreCardInning =  getScoreCardInning(match);
        Player outPlayer = scoreCardInning.getOnStrike();
        outPlayer.setTotalBall(outPlayer.getTotalRun()+1);
        outPlayer.setPlayerStatus(PlayerStatus.OUT);
        String team = match.getSecondTeam();
        if(match.getScoreCard().getCurrentInningType()== ScoreCard.InningType.FIRST){
            team = match.getFirstTeam();
        }
        Queue<Player>  alreadyOutPlayer = scoreCardInning.getOutPlayer().getOrDefault(team,new LinkedList<>());
        alreadyOutPlayer.add(outPlayer);
        scoreCardInning.getOutPlayer().put(team,alreadyOutPlayer);
        if(alreadyOutPlayer.size() == match.getNumberOfPlayer()-1 && !match.getScoreCard().isFirstInningCompleted()){
            match.getScoreCard().setFirstInningCompleted(true);
            scoreCardInning.setInningStatus("completed");
            match.getScoreCard().setCurrentInningType(ScoreCard.InningType.SECOND);
            return;
        }else if(alreadyOutPlayer.size() == match.getNumberOfPlayer()-1) {
            match.setMatchCompleted(true);
            match.getScoreCard().setSecondInningCompleted(true);
            return;
        }
        Player onStrike = match.getBattingOrder().get(team).get(scoreCardInning.getNextPlayerIndex());
        scoreCardInning.setOnStrike(onStrike);
        onStrike.setPlayerStatus(PlayerStatus.BATTING);
        scoreCardInning.setNextPlayerIndex(scoreCardInning.getNextPlayerIndex()+1);
        updateBallNumberAndOver(scoreCardInning,match);
    }
}
