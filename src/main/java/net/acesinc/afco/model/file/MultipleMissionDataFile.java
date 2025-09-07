package net.acesinc.afco.model.file;

import com.fasterxml.jackson.annotation.JsonView;
import net.acesinc.afco.model.mission.MissionData;
import net.acesinc.afco.model.view.Views;

/**
 * This is meant to handle ECMS-ZIPs and then anything else in the future that is a file and has the scope of corresponding to 1 to N missions and thus the generic name.
 *
 * @author jeremytaylor
 */
public class MultipleMissionDataFile extends DataFile {
    @JsonView(Views.DashboardView.class)
    private MissionData missionData;

    public MissionData getMissionData() {
        return missionData;
    }

    public void setMissionData(MissionData missionData) {
        this.missionData = missionData;
    }
}
