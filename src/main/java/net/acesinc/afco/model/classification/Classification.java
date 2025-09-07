/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.classification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.acesinc.afco.model.classification.comparator.CompartmentComparator;
import net.acesinc.afco.model.classification.comparator.LevelComparator;
import net.acesinc.afco.model.classification.comparator.ReleasabilityComparator;
import net.acesinc.afco.model.exception.InvalidClassificationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * This class represent the legacy afco classification model that was used to provide classifications for NMPG objects.
 * This will eventually be migrated to use a JBlocks classification model which will deprecate this class
 */
@Getter
@Setter
public class Classification implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(Classification.class);

    private SortedSet<Level> levels;
    private SortedSet<Compartment> compartments;
    private SortedSet<Releasability> releasabilities;
    private List<DisseminationControl> disseminationControls;

    public static final Classification UNCLASSIFIED = new Classification().addLevel(Level.UNCLASSIFIED);
    public static final Classification UNCLASSIFIED_FOUO =
            new Classification().addLevel(Level.UNCLASSIFIED).addDisseminationControl(DisseminationControl.FOUO);
    public static final Classification CONFIDENTIAL = new Classification().addLevel(Level.CONFIDENTIAL);
    public static final Classification SECRET = new Classification().addLevel(Level.SECRET);
    public static final Classification SECRET_SI =
            new Classification().addLevel(Level.SECRET).addCompartment(Compartment.SI);
    public static final Classification SECRET_SI_TK = new Classification()
            .addLevel(Level.SECRET)
            .addCompartment(Compartment.SI)
            .addCompartment(Compartment.TK);
    public static final Classification SECRET_FVEY =
            new Classification().addLevel(Level.SECRET).addReleasabilities(Releasability.FVEY_SHORTCUT);
    public static final Classification SECRET_SI_FVEY = new Classification()
            .addLevel(Level.SECRET)
            .addCompartment(Compartment.SI)
            .addReleasabilities(Releasability.FVEY_SHORTCUT);
    public static final Classification SECRET_SI_TK_FVEY = new Classification()
            .addLevel(Level.SECRET)
            .addCompartment(Compartment.SI)
            .addCompartment(Compartment.TK)
            .addReleasabilities(Releasability.FVEY_SHORTCUT);
    public static final Classification TOP_SECRET = new Classification().addLevel(Level.TOP_SECRET);
    public static final Classification TOP_SECRET_SI =
            new Classification().addLevel(Level.TOP_SECRET).addCompartment(Compartment.SI);
    public static final Classification TOP_SECRET_SI_TK = new Classification()
            .addLevel(Level.TOP_SECRET)
            .addCompartment(Compartment.SI)
            .addCompartment(Compartment.TK);
    public static final Classification TOP_SECRET_FVEY =
            new Classification().addLevel(Level.TOP_SECRET).addReleasabilities(Releasability.FVEY_SHORTCUT);
    public static final Classification TOP_SECRET_SI_FVEY = new Classification()
            .addLevel(Level.TOP_SECRET)
            .addCompartment(Compartment.SI)
            .addReleasabilities(Releasability.FVEY_SHORTCUT);
    public static final Classification TOP_SECRET_SI_TK_FVEY = new Classification()
            .addLevel(Level.TOP_SECRET)
            .addCompartment(Compartment.SI)
            .addCompartment(Compartment.TK)
            .addReleasabilities(Releasability.FVEY_SHORTCUT);
    private static final String REL_TO = "REL TO";
    private static final String REL = "REL";
    private static final String TO = "TO";

    public Classification() {
        levels = new TreeSet<>(new LevelComparator());
        compartments = new TreeSet<>(new CompartmentComparator());
        releasabilities = new TreeSet<>(new ReleasabilityComparator());
        disseminationControls = new ArrayList<>();
    }

    /**
     * Copy Constructor.
     *
     * @param classification the source classification you want to clone
     */
    public Classification(Classification classification) {
        this();
        levels.addAll(classification.levels);
        compartments.addAll(classification.compartments);
        releasabilities.addAll(classification.releasabilities);
        disseminationControls.addAll(classification.disseminationControls);
    }

    public Classification addLevel(Level l) {
        getLevels().add(l);
        return this;
    }

    public Classification addCompartment(Compartment c) {
        getCompartments().add(c);
        return this;
    }

    public Classification addCompartments(Compartment[] list) {
        getCompartments().addAll(Arrays.asList(list));
        return this;
    }

    public Classification addReleasability(Releasability r) {
        getReleasabilities().add(r);
        return this;
    }

    public Classification addReleasabilities(Releasability[] list) {
        getReleasabilities().addAll(Arrays.asList(list));
        return this;
    }

    public Classification addDisseminationControl(DisseminationControl d) {
        getDisseminationControls().add(d);
        return this;
    }

    @Override
    public String toString() {
        return toClassificationString();
    }

    public String toClassificationString() {
        StringBuilder sb = new StringBuilder();
        String level = "NOTHING";

        if (!getLevels().isEmpty()) {
            level = getLevels().first().toString();
            level = level.replaceAll("_", " ");
            sb.append(level);
        }

        if (!getCompartments().isEmpty()) {
            sb.append("//");
            Iterator<Compartment> cIt = getCompartments().iterator();
            while (cIt.hasNext()) {
                Compartment c = cIt.next();
                String cStr = c.toString();
                cStr = cStr.replaceAll("_", " ");
                sb.append(cStr);
                if (cIt.hasNext()) {
                    sb.append("/");
                }
            }
        }

        if (!getReleasabilities().isEmpty()) {
            if (!"UNCLASSIFIED".equals(level)) {
                sb.append("//REL TO ");
            } else {
                sb.append("//");
            }

            Iterator<Releasability> rIt = getReleasabilities().iterator();
            while (rIt.hasNext()) {
                Releasability r = rIt.next();
                sb.append(r.toString());
                if (rIt.hasNext()) {
                    sb.append(", ");
                }
            }
        }

        if (!getDisseminationControls().isEmpty() && getReleasabilities().isEmpty()) {
            // then there is NF somehow and give a //
            sb.append("//");
        }
        if (!getDisseminationControls().isEmpty()) {
            Iterator<DisseminationControl> rIt = getDisseminationControls().iterator();
            while (rIt.hasNext()) {
                DisseminationControl r = rIt.next();
                if (!r.toString().contains("REL")) {
                    if (r.toString().contains("NF")) {
                        sb.append("NOFORN");
                    } else {
                        sb.append(r.toString());
                    }
                    if (rIt.hasNext()) {
                        sb.append("//");
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * Return the current classification string in a file name format. Copied
     * from CapcoToSecurityMarkingFileNameTranslator in
     * nmpg-streaming-audio-agent.
     *
     * @return The file name classification string
     */
    public String toClassificationFileNameString() {
        return this.toClassificationString()
                .replaceAll("(//|/|,\\s)", "_")
                .replaceFirst("TOP SECRET", "TOPSECRET")
                .replaceAll("\\s", "_");
    }

    public static Classification fromString(String classification) throws InvalidClassificationException {
        Classification c = new Classification();
        log.trace("Converting classification [ {} ]", classification);

        if (!StringUtils.hasText(classification)) {
            throw new InvalidClassificationException("Classification string is empty");
        }

        String[] parts = classification.toUpperCase().split("//");

        try {
            if (parts.length == 1) {
                // Only a Level
                Level l = Level.fromString(classification);
                c.addLevel(l);
            } else if (parts.length == 2) {
                // level and rel only
                Level l = Level.fromString(parts[0]);
                c.addLevel(l);

                String relTo = parts[1];
                String relsOnly = relTo;
                if (l.compareTo(Level.UNCLASSIFIED) != 0) {
                    // looping through to get dissemControls and REL for sure
                    for (DisseminationControl dissemControl : DisseminationControl.values()) {
                        if (relTo.contains(dissemControl.name())) {
                            c.addDisseminationControl(dissemControl);
                        }
                    }
                    if (relTo.contains(REL_TO)) {
                        // has REL TO
                        int startIndex = relTo.indexOf(REL_TO) + REL_TO.length();
                        relsOnly = relTo.substring(startIndex, relTo.length());
                    } else if (relTo.contains(REL)) {
                        // has just REL, but no TO
                        int startIndex = relTo.indexOf(REL) + REL.length();
                        relsOnly = relTo.substring(startIndex, relTo.length());
                    } else {
                        // for some reason it was assumed CAPCO would have either REL or REL this was added for NF cases
                        relsOnly = "";
                    }
                } else if (l.compareTo(Level.UNCLASSIFIED) == 0) {
                    // Dissemination only
                    // FOUO
                    c.addDisseminationControl(DisseminationControl.FOUO.valueOf(relTo));
                    return c;
                }

                String[] rels = relsOnly.split(",");
                // hack here cuz Jav class string is incorrect
                // sort the RELs, then put USA first, don't add in loop
                Arrays.sort(rels);

                // added for NF cases where CAPCO won't have USA
                if (!StringUtils.isEmpty(relsOnly)) {
                    c.addReleasability(Releasability.USA);
                }

                for (String r : rels) {
                    if (!r.equals(REL)
                            && !r.equals("USA")
                            && !StringUtils.isEmpty(
                                    r)) { // added isEmpty as a check to prevent looking up empty sting in enum
                        Releasability rel = Releasability.valueOf(r.trim());
                        c.addReleasability(rel);
                    }
                }

            } else if (parts.length > 2) {
                Level l = Level.fromString(parts[0]);
                c.addLevel(l);

                String comps = parts[1];
                String[] compList = comps.split("[/,]");
                for (String comp : compList) {
                    Compartment compartment = Compartment.valueOf(comp.trim());
                    c.addCompartment(compartment);
                }

                String relTo = parts[2];
                // wow, if we actually loop through dissemControls, we might actually be able to check for each one of
                // them an add them.  wow!
                for (DisseminationControl dissemControl : DisseminationControl.values()) {
                    if (relTo.contains(dissemControl.name())) {
                        c.addDisseminationControl(dissemControl);
                    }
                }
                String relsOnly = relTo;
                // wow, if there isn't a REL there, maybe we shouldn't do a bunch of crap and assume it's there anyway.
                // wow!
                if (l.compareTo(Level.UNCLASSIFIED) != 0 && relTo.contains(REL)) {
                    if (relTo.contains(REL_TO)) {
                        // has REL TO
                        int startIndex = relTo.indexOf(REL_TO) + REL_TO.length();
                        relsOnly = relTo.substring(startIndex, relTo.length());
                    } else {
                        // has just REL, but no TO
                        int startIndex = relTo.indexOf(REL) + REL.length();
                        relsOnly = relTo.substring(startIndex, relTo.length());
                    }

                    String[] rels = null;
                    if (relsOnly.indexOf(',') > 0) {
                        rels = relsOnly.split(",");
                    } else {
                        rels = relTo.split(" ");
                    }

                    // hack here cuz Jav class string is incorrect
                    // sort the RELs, then put USA first, don't add in loop
                    Arrays.sort(rels);
                    c.addReleasability(Releasability.USA);
                    for (String r : rels) {
                        log.trace("rel item:=" + r);
                        if (!r.equals(REL) && !r.equals("USA") && !r.equals(TO)) {
                            Releasability rel = Releasability.valueOf(r.trim());
                            c.addReleasability(rel);
                        }
                    }
                }
                // note that we are going to skip anything after part 3, i.e the declassification block is skipped.
            }
        } catch (Exception e) {
            log.error("Error occurred parsing classification [{}]", classification, e);
            throw new InvalidClassificationException(
                    String.format("Error occurred parsing classification: [%s], exception: [%s]", classification, e));
        }

        return c;
    }

    /**
     *
     * ({@link net.acesinc.afco.model.location.PlatformLocation}) objects into the platform_location collection for retrieval
     * by the NMPG UI.
     */
    @NonNull
    public static Classification fromJBlocksClassification(
            jblocks.dataheaders.classification.Classification classification) throws InvalidClassificationException {
        log.trace(
                "Trying to convert JBlocks classification with values: {} to AFCO classification model ...",
                classification);
        if (classification == null) {
            throw new InvalidClassificationException(
                    "JBlocks classification object that was received appears to no be correctly populated, value");
        }
        return fromString(classification.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Classification) {
            Classification test = (Classification) obj;
            SortedSet<Level> testLevels = test.getLevels();
            SortedSet<Compartment> testComps = test.getCompartments();
            SortedSet<Releasability> testRels = test.getReleasabilities();
            List<DisseminationControl> testDissems = test.getDisseminationControls();

            if (testLevels.size() == levels.size()) {
                for (Level l : testLevels) {
                    if (!levels.contains(l)) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (testComps.size() == compartments.size()) {
                for (Compartment c : testComps) {
                    if (!compartments.contains(c)) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (testRels.size() == releasabilities.size()) {
                for (Releasability r : testRels) {
                    if (!releasabilities.contains(r)) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            if (testDissems.size() == disseminationControls.size()) {
                for (DisseminationControl d : testDissems) {
                    if (!disseminationControls.contains(d)) {
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
}
