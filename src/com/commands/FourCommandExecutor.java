package com.commands;

import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;

public class FourCommandExecutor extends CommandExecutor {

    @Override
    public void execute(String ballMetaData, Match match) {
        ScoreCard.ScoreCardInning scoreCardInning =  getScoreCardInning(match);
        scoreCardInning.setTotalRun(scoreCardInning.getTotalRun()+4);
        Player onStrike  = scoreCardInning.getOnStrike();
        onStrike.setTotalRun(onStrike.getTotalRun()+4);
        onStrike.setTotalBall(onStrike.getTotalBall()+1);
        onStrike.setFourCount(onStrike.getFourCount()+1);
        updateBallNumberAndOver(scoreCardInning,match);

    }
}
