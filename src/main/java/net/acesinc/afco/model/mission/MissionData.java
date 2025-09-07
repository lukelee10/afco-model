package net.acesinc.afco.model.mission;

import java.util.ArrayList;

public class MissionData {

    private ArrayList<String> missionIds = new ArrayList<>();

    public MissionData() {
        super();
    }

    public ArrayList<String> getMissionIds() {
        return missionIds;
    }

    public void setMissionIds(ArrayList<String> missionIds) {
        this.missionIds = missionIds;
    }
}
