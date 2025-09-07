package net.acesinc.afco.model.classification;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class UserCredentials extends Classification {
    private List<String> briefings;
    private List<String> lacs;
    private List<String> missions;
    private String entitySecurityMark;
    private String email;
    private String phoneNumber;
    private String securePhoneNumber;

    public UserCredentials() {
        super();
        briefings = new ArrayList<>();
        lacs = new ArrayList<>();
        missions = new ArrayList<>();
    }

    /**
     * Copy constructor
     *
     * @param credentials the authorization you want to clone
     */
    public UserCredentials(UserCredentials credentials) {
        super(credentials);
        briefings.addAll(credentials.getBriefings());
        lacs.addAll(credentials.getLacs());
        missions.addAll(credentials.getMissions());
    }

    public String getEntitySecurityMark() {
        return entitySecurityMark;
    }

    public void setEntitySecurityMark(String entitySecurityMark) {
        this.entitySecurityMark = entitySecurityMark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSecurePhoneNumber() {
        return securePhoneNumber;
    }

    public void setSecurePhoneNumber(String securePhoneNumber) {
        this.securePhoneNumber = securePhoneNumber;
    }

    /**
     * @return the visas
     */
    public SortedSet<Releasability> getVisas() {
        return getReleasabilities();
    }

    /**
     * @param releasabilities the releasabilities to set
     */
    public void setVisas(SortedSet<Releasability> releasabilities) {
        setReleasabilities(releasabilities);
    }

    public Classification addBriefing(String briefing) {
        getBriefings().add(briefing);
        return this;
    }

    public Classification addLac(String lac) {
        getLacs().add(lac);
        return this;
    }

    public Classification addMission(String mission) {
        getMissions().add(mission);
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserCredentials) {
            UserCredentials test = (UserCredentials) obj;
            List<String> testBriefings = test.getBriefings();
            List<String> testLacs = test.getLacs();
            List<String> testMissions = test.getMissions();

            if (!super.equals(obj)) {
                return false;
            }

            if (testBriefings.size() == briefings.size()) {
                for (String briefing : testBriefings) {
                    if (!briefings.contains(briefing)) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (testLacs.size() == lacs.size()) {
                for (String lac : testLacs) {
                    if (!lacs.contains(lac)) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (testMissions.size() == missions.size()) {
                for (String mission : testMissions) {
                    if (!missions.contains(mission)) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            // everything looks good
            return true;
        }
        return false;
    }

    /**
     * @return the briefings
     */
    public List<String> getBriefings() {
        return briefings;
    }

    /**
     * @param briefings the briefings to set
     */
    public void setBriefings(List<String> briefings) {
        this.briefings = briefings;
    }

    /**
     * @return the lacs
     */
    public List<String> getLacs() {
        return lacs;
    }

    /**
     * @param lacs the lacs to set
     */
    public void setLacs(List<String> lacs) {
        this.lacs = lacs;
    }

    /**
     * @return the missions
     */
    public List<String> getMissions() {
        return missions;
    }

    /**
     * @param missions the missions to set
     */
    public void setMissions(List<String> missions) {
        this.missions = missions;
    }
}
