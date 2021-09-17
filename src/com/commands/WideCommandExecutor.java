package com.commands;

import com.db.Match;
import com.db.ScoreCard;

public class WideCommandExecutor extends CommandExecutor {


    @Override
    public void execute(String ballMetaData, Match match) {
        ScoreCard.ScoreCardInning scoreCardInning =  getScoreCardInning(match);
        scoreCardInning.setTotalRun(scoreCardInning.getTotalRun()+1);
        scoreCardInning.setExtra(scoreCardInning.getExtra()+1);
    }
}
