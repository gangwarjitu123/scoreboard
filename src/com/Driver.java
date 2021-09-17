package com;


import com.Utils.KeyUtils;
import com.dao.Impl.MatchServiceDaoImpl;
import com.request.MatchCreateRequest;
import com.service.Impl.MatchServiceImpl;
import com.service.MatchService;

import java.util.Arrays;


public class Driver {
    private static final MatchService matchService = new MatchServiceImpl(new MatchServiceDaoImpl());
    public static void main(String[] args){
        MatchCreateRequest matchCreateRequest = new MatchCreateRequest();
        matchCreateRequest.setNumberOfOvers(2);
        matchCreateRequest.setFirstTeamName("t1");
        matchCreateRequest.setSecondTeamName("t2");
        matchCreateRequest.setNumberOfPlayer(5);
        matchService.createMatch(matchCreateRequest);
       // System.out.println(Database.matchMap.get(KeyUtils.createMatchKey("t1","t2")));
        matchService.createBattingOrderForMatch(KeyUtils.createMatchKey("t1","t2"),"t1", Arrays.asList("p1","p2","p3","p4","p5"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"w",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"wd",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"2",KeyUtils.createMatchKey("t1","t2"));
        matchService.getScoreBoard(KeyUtils.createMatchKey("t1","t2"),"t1");

        //second over
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"w",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"wd",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"2",KeyUtils.createMatchKey("t1","t2"));
        matchService.getScoreBoard(KeyUtils.createMatchKey("t1","t2"),"t1");


        // CREATE SECOND
        matchService.createBattingOrderForMatch(KeyUtils.createMatchKey("t1","t2"),"t2", Arrays.asList("P6","P7","P8","P9","P10"));

        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"w",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"wd",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(1,"2",KeyUtils.createMatchKey("t1","t2"));
        matchService.getScoreBoard(KeyUtils.createMatchKey("t1","t2"),"t2");

        //second over
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"1",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"w",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"wd",KeyUtils.createMatchKey("t1","t2"));
        matchService.bowled(2,"2" ,KeyUtils.createMatchKey("t1","t2"));
        matchService.getScoreBoard(KeyUtils.createMatchKey("t1","t2"),"t2");


    }

}
