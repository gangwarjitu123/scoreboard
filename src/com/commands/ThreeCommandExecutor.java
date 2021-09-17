package com.commands;

import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;

public class ThreeCommandExecutor extends CommandExecutor{

    @Override
    public void execute(String ballMetaData, Match match) {
        ScoreCard.ScoreCardInning scoreCardInning =  getScoreCardInning(match);
        scoreCardInning.setTotalRun(scoreCardInning.getTotalRun()+3);
        Player onStrike  = scoreCardInning.getOnStrike();
        onStrike.setTotalRun(onStrike.getTotalRun()+3);
        onStrike.setTotalBall(onStrike.getTotalBall()+1);
        updateBallNumberAndOver(scoreCardInning,match);
    }
}
