package com.dao.Impl;

import com.Utils.KeyUtils;
import com.dao.MatchServiceDao;
import com.db.Database;
import com.db.Match;

import java.util.HashSet;
import java.util.Set;

public class MatchServiceDaoImpl implements MatchServiceDao {

    @Override
    public void createMatch(Match match) {
        String matchKey = KeyUtils.createMatchKey(match.getFirstTeam(),match.getSecondTeam());
        match.setMatchKey(matchKey);
        Database.matchMap.put(matchKey,match);
        System.out.println("match created");
    }

    @Override
    public Match getMatchKey(String matchKey) {
        return Database.matchMap.get(matchKey);
    }
}
