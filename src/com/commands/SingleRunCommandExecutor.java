package com.commands;

import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;

public class SingleRunCommandExecutor extends CommandExecutor{

    @Override
    public void execute(String ballMetaData, Match match) {
      ScoreCard.ScoreCardInning scoreCardInning =  match.getScoreCard().getScoreCardInningMap().get(match.getScoreCard().getCurrentInningType());
      scoreCardInning.setTotalRun(scoreCardInning.getTotalRun()+1);
      Player onStrike  = scoreCardInning.getOnStrike();
      onStrike.setTotalRun(onStrike.getTotalRun()+1);
      onStrike.setTotalBall(onStrike.getTotalBall()+1);
      changeStrike(scoreCardInning);
      updateBallNumberAndOver(scoreCardInning,match);
    }
}
