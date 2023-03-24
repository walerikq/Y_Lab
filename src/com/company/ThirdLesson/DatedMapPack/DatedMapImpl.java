package com.company.ThirdLesson.DatedMapPack;

import com.company.ThirdLesson.DatedMapPack.DatedMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class DatedMapImpl implements DatedMap {
    private final Map<String, String> map;
    private final Map<String, Date> mapDate;

    public DatedMapImpl() {
        this.map = new HashMap<>();
        this.mapDate = new HashMap<>();
    }

    public void put(String key, String value) {
        map.put(key, value);
        mapDate.put(key, new Date());

    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        return mapDate.get(key);
    }
}
