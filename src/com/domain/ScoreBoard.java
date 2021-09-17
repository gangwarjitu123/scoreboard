package com.domain;

import com.Type.ResultType;
import java.util.Map;

public class ScoreBoard {
    Map<String, Innings> inningsMap;
    private ResultType resultType;

    public Map<String, Innings> getInningsMap() {
        return inningsMap;
    }

    public void setInningsMap(Map<String, Innings> inningsMap) {
        this.inningsMap = inningsMap;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }
}
