package com.commands;

import com.Type.RunType;
import com.db.Match;
import com.db.ScoreCard;
import com.domain.Player;

public abstract class CommandExecutor {

    protected void changeStrike(ScoreCard.ScoreCardInning scoreCardInning){
        Player onStrike  = scoreCardInning.getOnStrike();
        Player nonStrike  = scoreCardInning.getNonStrike();
        scoreCardInning.setOnStrike(nonStrike);
        scoreCardInning.setNonStrike(onStrike);
    }

    protected ScoreCard.ScoreCardInning getScoreCardInning(Match match){
        return  match.getScoreCard().getScoreCardInningMap().get(match.getScoreCard().getCurrentInningType());

    }

    protected void updateBallNumberAndOver(ScoreCard.ScoreCardInning scoreCardInning,Match match){
        scoreCardInning.setCurrentBallNumber(scoreCardInning.getCurrentBallNumber()+1);
        if(scoreCardInning.getCurrentBallNumber()==6){
            scoreCardInning.setCurrentBallNumber(0);
            scoreCardInning.setTotalOver(scoreCardInning.getTotalOver()+1);
            changeStrike(scoreCardInning);
        }
        if(match.getNumberOfOver()==scoreCardInning.getTotalOver() && !match.getScoreCard().isFirstInningCompleted()){
            match.getScoreCard().setFirstInningCompleted(true);
            scoreCardInning.setInningStatus("completed");
            match.getScoreCard().setCurrentInningType(ScoreCard.InningType.SECOND);
        }else if(match.getNumberOfOver()==scoreCardInning.getTotalOver()){
            match.getScoreCard().setSecondInningCompleted(true);
            scoreCardInning.setInningStatus("completed");
            match.setMatchCompleted(true);
        }
    }


    public abstract void execute(String ballMetaData,Match match);
}
