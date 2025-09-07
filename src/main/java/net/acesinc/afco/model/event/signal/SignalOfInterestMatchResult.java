package net.acesinc.afco.model.event.signal;

import java.util.ArrayList;
import java.util.List;
import net.acesinc.afco.model.subject.SignalSubject;

public class SignalOfInterestMatchResult {

    private boolean autoDistribute = false;
    private boolean matchResult = true;
    private List<String> failedMatchResults = new ArrayList<>();
    private List<String> successfulMatchResults = new ArrayList<>();
    private SignalOfInterest signalOfInterest;
    private SignalSubject signalSubject;

    public SignalOfInterestMatchResult(SignalOfInterest signalOfInterest, SignalSubject signalSubject) {
        this.signalOfInterest = signalOfInterest;
        this.signalSubject = signalSubject;
    }

    /**
     * Add a new match result to the successful match results list if match is true, otherwise add
     * it to the failed match results list. If failed, then set the overall match result boolen
     * to false.
     *
     * @param match Whether or not the match succeeded
     * @param criteria The criteria string that describes what was tested
     */
    public void addMatchResult(boolean match, String criteria) {
        // If match is true, then add the criteria string to the successful match results list
        if (match) {
            successfulMatchResults.add(criteria);

            // Otherwise add the criteria string to the failure match results list and set the
            // overall match result boolean to false
        } else {
            failedMatchResults.add(criteria);
            matchResult = false;
        }
    }

    /**
     * @return the autoDistribute
     */
    public boolean isAutoDistribute() {
        return autoDistribute;
    }

    /**
     * @param autoDistribute the autoDistribute to set
     */
    public void setAutoDistribute(boolean autoDistribute) {
        this.autoDistribute = autoDistribute;
    }

    /**
     * @return the matchResult
     */
    public boolean isMatchResult() {
        return matchResult;
    }

    /**
     * @param matchResult the matchResult to set
     */
    public void setMatchResult(boolean matchResult) {
        this.matchResult = matchResult;
    }

    /**
     * @return the failedMatchResults
     */
    public List<String> getFailedMatchResults() {
        return failedMatchResults;
    }

    /**
     * @param failedMatchResults the failedMatchResults to set
     */
    public void setFailedMatchResults(List<String> failedMatchResults) {
        this.failedMatchResults = failedMatchResults;
    }

    /**
     * @return the successfulMatchResults
     */
    public List<String> getSuccessfulMatchResults() {
        return successfulMatchResults;
    }

    /**
     * @param successfulMatchResults the successfulMatchResults to set
     */
    public void setSuccessfulMatchResults(List<String> successfulMatchResults) {
        this.successfulMatchResults = successfulMatchResults;
    }

    /**
     * @return the signalOfInterest
     */
    public SignalOfInterest getSignalOfInterest() {
        return signalOfInterest;
    }

    /**
     * @param signalOfInterest the signalOfInterest to set
     */
    public void setSignalOfInterest(SignalOfInterest signalOfInterest) {
        this.signalOfInterest = signalOfInterest;
    }

    /**
     * @return the signalSubject
     */
    public SignalSubject getSignalSubject() {
        return signalSubject;
    }

    /**
     * @param signalSubject the signalSubject to set
     */
    public void setSignalSubject(SignalSubject signalSubject) {
        this.signalSubject = signalSubject;
    }
}
