package com.codegym.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (versionHistoryMap.containsKey(rollbackVersion)){
            currentVersion=rollbackVersion;
            Iterator<Map.Entry<Integer, String>> pair = versionHistoryMap.entrySet().iterator();
            while(pair.hasNext()){
                Map.Entry<Integer, String> x=pair.next();
                if(x.getKey()>rollbackVersion) pair.remove();
            }
            return true;
        }
        return false;
    }
}
