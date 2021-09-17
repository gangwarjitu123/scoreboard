package com.domain;

import com.Type.PlayerStatus;
import com.Type.PlayerType;
import com.Type.RunType;
import com.Type.WicketType;

public abstract class Player  extends Person{
    private PlayerType playerType;

    public Player(PlayerType playerMainType){
        this.playerType = playerMainType;
    }
    private String id;
    private int fourCount;
    private int totalRun;
    private int totalBall;
    private int sixCount;
    private RunType runType;
    private WicketType wicketType;
    private Over over;
    private Ball ball;
    private int totalOver;
    private int totalWide;
    private  PlayerStatus playerStatus = PlayerStatus.NOTOUT;

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public int getTotalRun() {
        return totalRun;
    }

    public void setTotalRun(int totalRun) {
        this.totalRun = totalRun;
    }

    public int getTotalBall() {
        return totalBall;
    }

    public void setTotalBall(int totalBall) {
        this.totalBall = totalBall;
    }

    public int getTotalOver() {
        return totalOver;
    }

    public void setTotalOver(int totalOver) {
        this.totalOver = totalOver;
    }

    public int getTotalWide() {
        return totalWide;
    }

    public void setTotalWide(int totalWide) {
        this.totalWide = totalWide;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFourCount() {
        return fourCount;
    }

    public void setFourCount(int fourCount) {
        this.fourCount = fourCount;
    }

    public int getSixCount() {
        return sixCount;
    }

    public void setSixCount(int sixCount) {
        this.sixCount = sixCount;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public Over getOver() {
        return over;
    }

    public void setOver(Over over) {
        this.over = over;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerType=" + playerType +
                ", id=" + id +
                ", fourCount=" + fourCount +
                ", sixCount=" + sixCount +
                ", runType=" + runType +
                ", wicketType=" + wicketType +
                ", over=" + over +
                ", ball=" + ball +
                '}';
    }
}
