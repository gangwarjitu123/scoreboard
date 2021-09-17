package com.db;

import com.domain.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Match {
    private boolean isMatchStarted = false;
    private boolean isMatchCompleted = false;
    private String matchKey;
    private String firstTeam;
    private String secondTeam;
    private int numberOfPlayer;
    private int numberOfOver;
    private ScoreCard scoreCard = new ScoreCard();
    private Map<String, List<Player>> battingOrder = new HashMap<>();


    public boolean isMatchCompleted() {
        return isMatchCompleted;
    }

    public void setMatchCompleted(boolean matchCompleted) {
        isMatchCompleted = matchCompleted;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public int getNumberOfOver() {
        return numberOfOver;
    }

    public void setNumberOfOver(int numberOfOver) {
        this.numberOfOver = numberOfOver;
    }

    public Map<String, List<Player>> getBattingOrder() {
        return battingOrder;
    }

    public void setBattingOrder(Map<String, List<Player>> battingOrder) {
        this.battingOrder = battingOrder;
    }

    public String getMatchKey() {
        return matchKey;
    }

    public void setMatchKey(String matchKey) {
        this.matchKey = matchKey;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchKey='" + matchKey + '\'' +
                ", firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", numberOfPlayer=" + numberOfPlayer +
                ", numberOfOver=" + numberOfOver +
                ", battingOrder=" + battingOrder +
                '}';
    }

    public ScoreCard getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(ScoreCard scoreCard) {
        this.scoreCard = scoreCard;
    }

    public boolean isMatchStarted() {
        return isMatchStarted;
    }

    public void setMatchStarted(boolean matchStarted) {
        isMatchStarted = matchStarted;
    }
}
