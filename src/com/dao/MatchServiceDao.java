package com.dao;

import com.db.Match;

public interface MatchServiceDao {
    public void createMatch(Match match);
    Match getMatchKey(String matchKey);
}
