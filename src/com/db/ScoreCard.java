package com.db;

import com.domain.Bowler;
import com.domain.Player;

import java.util.*;

public class ScoreCard {

    private boolean isFirstInningCompleted =false;
    private boolean isSecondInningCompleted =false;
    private InningType currentInningType;
    private String matchKey;

    Map<InningType,ScoreCardInning> scoreCardInningMap = new HashMap<>(2);

    public InningType getCurrentInningType() {
        return currentInningType;
    }

    public boolean isSecondInningCompleted() {
        return isSecondInningCompleted;
    }

    public void setSecondInningCompleted(boolean secondInningCompleted) {
        isSecondInningCompleted = secondInningCompleted;
    }

    public void setCurrentInningType(InningType currentInningType) {
        this.currentInningType = currentInningType;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    public boolean isFirstInningCompleted() {
        return isFirstInningCompleted;
    }

    public void setFirstInningCompleted(boolean firstInningCompleted) {
        isFirstInningCompleted = firstInningCompleted;
    }

    public Map<InningType, ScoreCardInning> getScoreCardInningMap() {
        return scoreCardInningMap;
    }

    public void setScoreCardInningMap(Map<InningType, ScoreCardInning> scoreCardInningMap) {
        this.scoreCardInningMap = scoreCardInningMap;
    }

   public static class ScoreCardInning{
        private String inningStatus;
        private Player onStrike;
        private int currentBallNumber=0;
        private Player nonStrike;
        private int totalOver;
        private int totalRun;
        private int extra;
        private int remainingOver;
        private Map<String, Queue<Player>> outPlayer = new HashMap<>();
        private Map<String, Queue<Player>> retiredPlayer;
        private List<Player>  bowlers;
        private Bowler currentBowler;
        private int nextPlayerIndex;

       public String getInningStatus() {
           return inningStatus;
       }

       public void setInningStatus(String inningStatus) {
           this.inningStatus = inningStatus;
       }

       public int getNextPlayerIndex() {
           return nextPlayerIndex;
       }

       public void setNextPlayerIndex(int nextPlayerIndex) {
           this.nextPlayerIndex = nextPlayerIndex;
       }

       public int getCurrentBallNumber() {
           return currentBallNumber;
       }

       public void setCurrentBallNumber(int currentBallNumber) {
           this.currentBallNumber = currentBallNumber;
       }

       public Player getOnStrike() {
            return onStrike;
        }

        public void setOnStrike(Player onStrike) {
            this.onStrike = onStrike;
        }

        public Player getNonStrike() {
            return nonStrike;
        }

        public void setNonStrike(Player nonStrike) {
            this.nonStrike = nonStrike;
        }

        public int getTotalOver() {
            return totalOver;
        }

        public void setTotalOver(int totalOver) {
            this.totalOver = totalOver;
        }

        public int getTotalRun() {
            return totalRun;
        }

        public void setTotalRun(int totalRun) {
            this.totalRun = totalRun;
        }

        public int getExtra() {
            return extra;
        }

        public void setExtra(int extra) {
            this.extra = extra;
        }

        public int getRemainingOver() {
            return remainingOver;
        }

        public void setRemainingOver(int remainingOver) {
            this.remainingOver = remainingOver;
        }

        public Map<String, Queue<Player>> getOutPlayer() {
            return outPlayer;
        }

        public void setOutPlayer(Map<String, Queue<Player>> outPlayer) {
            this.outPlayer = outPlayer;
        }

        public Map<String, Queue<Player>> getRetiredPlayer() {
            return retiredPlayer;
        }

        public void setRetiredPlayer(Map<String, Queue<Player>> retiredPlayer) {
            this.retiredPlayer = retiredPlayer;
        }

        public List<Player> getBowlers() {
            return bowlers;
        }

        public void setBowlers(List<Player> bowlers) {
            this.bowlers = bowlers;
        }

        public Bowler getCurrentBowler() {
            return currentBowler;
        }

        public void setCurrentBowler(Bowler currentBowler) {
            this.currentBowler = currentBowler;
        }
    }

    public enum InningType{
        FIRST,SECOND
    }


}
