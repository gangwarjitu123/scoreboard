package com.commands;

import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;

public class SIXCommandExecutor extends CommandExecutor{

    @Override
    public void execute(String ballMetaData, Match match) {
        ScoreCard.ScoreCardInning scoreCardInning =  getScoreCardInning(match);
        scoreCardInning.setTotalRun(scoreCardInning.getTotalRun()+6);
        Player onStrike  = scoreCardInning.getOnStrike();
        onStrike.setTotalRun(onStrike.getTotalRun()+6);
        onStrike.setTotalBall(onStrike.getTotalBall()+1);
        onStrike.setSixCount(onStrike.getSixCount()+1);
        updateBallNumberAndOver(scoreCardInning,match);
    }
}
