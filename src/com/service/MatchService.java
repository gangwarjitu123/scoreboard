package com.service;

import com.domain.ScoreBoard;
import com.request.MatchCreateRequest;

import java.util.List;


public interface MatchService {
     void createMatch(MatchCreateRequest matchCreateRequest);
     void createBattingOrderForMatch(String matchKey, String teamName, List<String> playerOrder);

     public void getScoreBoard(String matchKey,String teamName);

     public void bowled(int overNumber,String command,String matchKey);

}
