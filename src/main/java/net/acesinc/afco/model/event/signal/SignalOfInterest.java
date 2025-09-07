package net.acesinc.afco.model.event.signal;

import java.util.List;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.subject.SignalSubject;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "signalOfInterest")
public class SignalOfInterest {

    private String id;
    private Boolean autoDistribute;
    private Classification classification;
    private Integer confidenceMin;
    private String elnot;
    private List<SignalOfInterestRange> pri;
    private List<SignalOfInterestRange> pw;
    private List<SignalOfInterestRange> rf;
    private String siteDigraph;

    public SignalOfInterest() {
        super();
    }

    /**
     * Match the given signal to the current rules in this signal of interest. Return a
     * SignalOfInterestMatchResult record with the results from this match attempt.
     *
     * @param signalSubject The signal record to match
     * @return The SignalOfInterestMatchResult record that contains the results of this match attempt
     */
    public SignalOfInterestMatchResult matchSignal(SignalSubject signalSubject) {
        // Create a new SOI match result object for this signal
        SignalOfInterestMatchResult signalOfInterestMatchResult = new SignalOfInterestMatchResult(this, signalSubject);

        // Find the matching ELNOT in the given signal
        IdentOfEmit identOfEmit = null;
        for (IdentOfEmit ident : signalSubject.getIdents()) {
            if (elnot.equalsIgnoreCase(ident.getIdent())) {
                identOfEmit = ident;
                break;
            }
        }

        // If the ELNOT does not exist for the signal, then return immediately
        if (identOfEmit == null) {
            signalOfInterestMatchResult.addMatchResult(
                    false, String.format("Signal [%s] must contain ELNOT [%s]", signalSubject.getMappingId(), elnot));
            return signalOfInterestMatchResult;
        }

        // Add minimum requirement match result
        signalOfInterestMatchResult.addMatchResult(
                identOfEmit.getConfidence() >= confidenceMin,
                String.format(
                        "Confidence of ELNOT [%d] must be equal or greater than required minimum [%d]",
                        identOfEmit.getConfidence(), confidenceMin));

        // If the signal has no characterization, then return immediately since there is nothing further to check
        if (signalSubject.getCharacterization() == null) {
            return signalOfInterestMatchResult;
        }

        // Add PRI match result if appropriate
        if (pri != null
                && !pri.isEmpty()
                && signalSubject.getCharacterization().getPulseRepIntervalSummary() != null
                && signalSubject
                                .getCharacterization()
                                .getPulseRepIntervalSummary()
                                .getPulseRepititionIntervalMeanEstimates()
                        != null) {
            testWithinRange(
                    signalOfInterestMatchResult,
                    signalSubject
                            .getCharacterization()
                            .getPulseRepIntervalSummary()
                            .getPulseRepititionIntervalMeanEstimates(),
                    pri,
                    "PRI");
        }

        // Add PW match result if appropriate
        if (pw != null
                && !pw.isEmpty()
                && signalSubject.getCharacterization().getPulseWidthSummary() != null
                && signalSubject.getCharacterization().getPulseWidthSummary().getPulseWidthMeanEstimates() != null) {
            testWithinRange(
                    signalOfInterestMatchResult,
                    signalSubject.getCharacterization().getPulseWidthSummary().getPulseWidthMeanEstimates(),
                    pw,
                    "PW");
        }

        // Add RF match result if appropriate
        if (rf != null
                && !rf.isEmpty()
                && signalSubject.getCharacterization().getRadioFreqSummary() != null
                && signalSubject.getCharacterization().getRadioFreqSummary().getFreqs() != null) {
            testWithinRange(
                    signalOfInterestMatchResult,
                    signalSubject.getCharacterization().getRadioFreqSummary().getFreqs(),
                    rf,
                    "Frequency");
        }

        return signalOfInterestMatchResult;
    }

    /**
     * Test a within range rule for the given SignalOfInterestRange records. Add the result to the given match result object.
     *
     * @param signalOfInterestMatchResult The match result object to add the results of each test to
     * @param doublesList The list of Double values to test
     * @param rangeList The list of SignalOfInterestRange objects to test against
     * @param field The name of the field to test
     */
    private void testWithinRange(
            SignalOfInterestMatchResult signalOfInterestMatchResult,
            List<Double> doublesList,
            List<SignalOfInterestRange> rangeList,
            String field) {
        for (int i = 0; i < doublesList.size(); i++) {
            Double doubleValueToTest = doublesList.get(i);
            if (rangeList.size() > i) {
                SignalOfInterestRange range = rangeList.get(i);
                signalOfInterestMatchResult.addMatchResult(
                        range.isWithinRange(doubleValueToTest),
                        String.format(
                                "%s [%f] must be within range of min [%f] and max [%f]",
                                field, doubleValueToTest, range.getMin(), range.getMax()));
            }
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the autoDistribute
     */
    public Boolean isAutoDistribute() {
        return autoDistribute;
    }

    /**
     * @param autoDistribute the autoDistribute to set
     */
    public void setAutoDistribute(Boolean autoDistribute) {
        this.autoDistribute = autoDistribute;
    }

    /**
     * @return the classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    /**
     * @return the confidenceMin
     */
    public Integer getConfidenceMin() {
        return confidenceMin;
    }

    /**
     * @param confidenceMin the confidenceMin to set
     */
    public void setConfidenceMin(Integer confidenceMin) {
        this.confidenceMin = confidenceMin;
    }

    /**
     * @return the elnot
     */
    public String getElnot() {
        return elnot;
    }

    /**
     * @param elnot the elnot to set
     */
    public void setElnot(String elnot) {
        this.elnot = elnot;
    }

    /**
     * @return the pri
     */
    public List<SignalOfInterestRange> getPri() {
        return pri;
    }

    /**
     * @param pri the pri to set
     */
    public void setPri(List<SignalOfInterestRange> pri) {
        this.pri = pri;
    }

    /**
     * @return the pw
     */
    public List<SignalOfInterestRange> getPw() {
        return pw;
    }

    /**
     * @param pw the pw to set
     */
    public void setPw(List<SignalOfInterestRange> pw) {
        this.pw = pw;
    }

    /**
     * @return the rf
     */
    public List<SignalOfInterestRange> getRf() {
        return rf;
    }

    /**
     * @param rf the rf to set
     */
    public void setRf(List<SignalOfInterestRange> rf) {
        this.rf = rf;
    }

    /**
     * @return the siteDigraph
     */
    public String getSiteDigraph() {
        return siteDigraph;
    }

    /**
     * @param siteDigraph the siteDigraph to set
     */
    public void setSiteDigraph(String siteDigraph) {
        this.siteDigraph = siteDigraph;
    }
}
