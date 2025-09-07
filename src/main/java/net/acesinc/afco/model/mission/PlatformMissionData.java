package net.acesinc.afco.model.mission;

import java.util.Date;

public class PlatformMissionData extends PlatformMission {

    private Date missionDataStartTime;
    private Date missionDataStopTime;

    public PlatformMissionData() {
        super();
    }

    public Date getMissionDataStartTime() {
        return missionDataStartTime;
    }

    public void setMissionDataStartTime(Date missionDataStartTime) {
        this.missionDataStartTime = missionDataStartTime;
    }

    public Date getMissionDataStopTime() {
        return missionDataStopTime;
    }

    public void setMissionDataStopTime(Date missionDataStopTime) {
        this.missionDataStopTime = missionDataStopTime;
    }
}
