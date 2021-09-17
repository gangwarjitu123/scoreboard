package com.factory;

import com.Type.PlayerType;
import com.domain.BatsMan;
import com.domain.Bowler;
import com.domain.Player;

public class PlayerFactor {

    // by default it will batsman
    public static Player getPlayer(String playerType){
        if(playerType.equalsIgnoreCase(PlayerType.BOWLER.name())){
            return new Bowler(PlayerType.BOWLER); // for now will change in future
        }else if(playerType.equalsIgnoreCase(PlayerType.BATSMAN.name())){
            return new BatsMan(PlayerType.BATSMAN);
        }
        return new BatsMan(PlayerType.BATSMAN);
    }
}
