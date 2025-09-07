/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classification;

import static net.acesinc.afco.model.classification.Classification.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import jblocks.dataheaders.classification.MarkingsDefinition;
import jblocks.dataheaders.nsa.NsaMarkingsDefinition;
import net.acesinc.afco.model.classification.Classification;
import net.acesinc.afco.model.classification.Compartment;
import net.acesinc.afco.model.classification.DisseminationControl;
import net.acesinc.afco.model.classification.Level;
import net.acesinc.afco.model.classification.Releasability;
import net.acesinc.afco.model.exception.InvalidClassificationException;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jeremytaylor
 */
public class ClassificationTest {

    public void testClassificationFromString(String classificationString, Classification expectedClassificationObject)
            throws InvalidClassificationException {
        Classification actualClassificationObject = Classification.fromString(classificationString);
        assertEquals(expectedClassificationObject, actualClassificationObject);
    }

    public void testClassificationToString(String expectedClassificationString, Classification classificationObject) {
        String actualClassificationString = classificationObject.toString();
        System.out.println(actualClassificationString + " " + expectedClassificationString);
        assertEquals(expectedClassificationString, actualClassificationString);
    }

    @Test
    public void testClassificationFromString1() throws InvalidClassificationException {
        testClassificationFromString("UNCLASSIFIED", UNCLASSIFIED);
    }

    @Test
    public void testClassificationFromString2() throws InvalidClassificationException {
        testClassificationFromString("UNCLASSIFIED//FOUO", UNCLASSIFIED_FOUO);
    }

    @Test
    public void testClassificationFromString3() throws InvalidClassificationException {
        testClassificationFromString(
                "CONFIDENTIAL//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.CONFIDENTIAL)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString5() throws InvalidClassificationException {
        testClassificationFromString(
                "CONFIDENTIAL//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.CONFIDENTIAL)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString6() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString7() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString8() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//SI//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString9() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString10() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//SI//NOFORN",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationFromString11() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//SI/TK//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString12() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//SI/TK//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString4() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString13() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString14() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//NOFORN",
                new Classification().addLevel(Level.TOP_SECRET).addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationFromString15() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//SI//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString16() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString17() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//SI//NOFORN",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationFromString18() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//SI/TK//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationFromString19() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//SI/TK//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationFromString20() throws InvalidClassificationException {
        testClassificationFromString(
                "TOP SECRET//SI/TK//NOFORN",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationFromString20a() throws InvalidClassificationException {
        testClassificationFromString(
                "SECRET//SI/TK//NOFORN",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testAbbreviatedClassificationFromString1() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString3() throws InvalidClassificationException {
        testClassificationFromString(
                "U//FOUO",
                new Classification().addLevel(Level.UNCLASSIFIED).addDisseminationControl(DisseminationControl.FOUO));
    }

    @Test
    public void testAbbreviatedClassificationFromString4() throws InvalidClassificationException {
        testClassificationFromString("U", new Classification().addLevel(Level.UNCLASSIFIED));
    }

    @Test
    public void testAbbreviatedClassificationFromString5() throws InvalidClassificationException {
        testClassificationFromString(
                "C//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.CONFIDENTIAL)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString6() throws InvalidClassificationException {
        testClassificationFromString(
                "S//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString7() throws InvalidClassificationException {
        testClassificationFromString(
                "S//SI//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString8() throws InvalidClassificationException {
        testClassificationFromString(
                "S//SI//NF",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.NF));
    }

    @Test
    public void testAbbreviatedClassificationFromString9() throws InvalidClassificationException {
        testClassificationFromString(
                "S//SI/TK//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString10() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString10a() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//REL USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString11() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//NF",
                new Classification().addLevel(Level.TOP_SECRET).addDisseminationControl(DisseminationControl.NF));
    }

    @Test
    public void testAbbreviatedClassificationFromString12() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString13() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI//NF",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.NF));
    }

    @Test
    public void testAbbreviatedClassificationFromString14() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI/TK//NF",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.NF));
    }

    @Test
    public void testAbbreviatedClassificationFromString14a() throws InvalidClassificationException {
        testClassificationFromString(
                "S//SI/TK//NF",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.NF));
    }

    @Test
    public void testAbbreviatedClassificationFromString15() throws InvalidClassificationException {
        testClassificationFromString(
                "C//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.CONFIDENTIAL)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString16() throws InvalidClassificationException {
        testClassificationFromString(
                "S//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString17() throws InvalidClassificationException {
        testClassificationFromString(
                "S//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString18() throws InvalidClassificationException {
        testClassificationFromString(
                "S//SI/TK//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString19() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString20() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString21() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI/TK//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testAbbreviatedClassificationFromString22() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI/TK//REL USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testAbbreviatedClassificationFromString23() throws InvalidClassificationException {
        testClassificationFromString(
                "TS//SI/TK//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString1() {
        testClassificationToString("UNCLASSIFIED", UNCLASSIFIED);
    }

    @Test
    public void testClassificationToString2() {
        testClassificationToString("UNCLASSIFIED//FOUO", UNCLASSIFIED_FOUO);
    }

    @Test
    public void testClassificationToString3() {
        testClassificationToString(
                "CONFIDENTIAL//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.CONFIDENTIAL)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString5() {
        testClassificationToString(
                "CONFIDENTIAL//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.CONFIDENTIAL)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString6() {
        testClassificationToString(
                "SECRET//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString7() {
        testClassificationToString(
                "SECRET//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString8() {
        testClassificationToString(
                "SECRET//SI//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString9() {
        testClassificationToString(
                "SECRET//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString10() {
        testClassificationToString(
                "SECRET//SI//NOFORN",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationToString11() {
        testClassificationToString(
                "SECRET//SI/TK//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString12() {
        testClassificationToString(
                "SECRET//SI/TK//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString4() {
        testClassificationToString(
                "TOP SECRET//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString13() {
        testClassificationToString(
                "TOP SECRET//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString14() {
        testClassificationToString(
                "TOP SECRET//NOFORN",
                new Classification().addLevel(Level.TOP_SECRET).addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationToString15() {
        testClassificationToString(
                "TOP SECRET//SI//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString16() {
        testClassificationToString(
                "TOP SECRET//SI//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString17() {
        testClassificationToString(
                "TOP SECRET//SI//NOFORN",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationToString18() {
        testClassificationToString(
                "TOP SECRET//SI/TK//REL TO USA, FVEY",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.FVEY));
    }

    @Test
    public void testClassificationToString19() {
        testClassificationToString(
                "TOP SECRET//SI/TK//REL TO USA, CAN, GBR",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.REL)
                        .addReleasability(Releasability.USA)
                        .addReleasability(Releasability.CAN)
                        .addReleasability(Releasability.GBR));
    }

    @Test
    public void testClassificationToString20() {
        testClassificationToString(
                "TOP SECRET//SI/TK//NOFORN",
                new Classification()
                        .addLevel(Level.TOP_SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testClassificationToString20a() {
        testClassificationToString(
                "SECRET//SI/TK//NOFORN",
                new Classification()
                        .addLevel(Level.SECRET)
                        .addCompartment(Compartment.SI)
                        .addCompartment(Compartment.TK)
                        .addDisseminationControl(DisseminationControl.NOFORN));
    }

    @Test
    public void testFileNameString1() throws InvalidClassificationException {
        String capco = "TOP SECRET//SI//REL TO USA, AUS, GBR";
        Classification c = Classification.fromString(capco);
        String expected = "TOPSECRET_SI_REL_TO_USA_AUS_GBR";
        assertThat("filename", c.toClassificationFileNameString(), is(equalTo(expected)));

        assertEquals(Sets.newLinkedHashSet(Level.TOP_SECRET), c.getLevels());
        assertEquals(Sets.newLinkedHashSet(Compartment.SI), c.getCompartments());
        assertEquals(Arrays.asList(DisseminationControl.REL), c.getDisseminationControls());
        assertEquals(
                Sets.newLinkedHashSet(Releasability.USA, Releasability.AUS, Releasability.GBR), c.getReleasabilities());
    }

    @Test
    public void testFileNameString2() throws InvalidClassificationException {
        String capco = "TOP SECRET//SI//NF";
        Classification c = Classification.fromString(capco);
        String expected = "TOPSECRET_SI_NOFORN";
        assertThat("filename", c.toClassificationFileNameString(), is(equalTo(expected)));

        assertEquals(Sets.newLinkedHashSet(Level.TOP_SECRET), c.getLevels());
        assertEquals(Sets.newLinkedHashSet(Compartment.SI), c.getCompartments());
        assertEquals(Arrays.asList(DisseminationControl.NF), c.getDisseminationControls());
        assertEquals(Sets.newLinkedHashSet(), c.getReleasabilities());
    }

    @Test
    public void testFileNameString3() throws InvalidClassificationException {
        String capco = "TOP SECRET//REL TO USA, AUS, GBR";
        Classification c = Classification.fromString(capco);
        String expected = "TOPSECRET_REL_TO_USA_AUS_GBR";
        assertThat("filename", c.toClassificationFileNameString(), is(equalTo(expected)));

        assertEquals(Sets.newLinkedHashSet(Level.TOP_SECRET), c.getLevels());
        assertEquals(Sets.newLinkedHashSet(), c.getCompartments());
        assertEquals(Arrays.asList(DisseminationControl.REL), c.getDisseminationControls());
        assertEquals(
                Sets.newLinkedHashSet(Releasability.USA, Releasability.AUS, Releasability.GBR), c.getReleasabilities());
    }

    @Test
    public void testFileNameString4() throws InvalidClassificationException {
        String capco = "UNCLASSIFIED//FOUO";
        Classification c = Classification.fromString(capco);
        String expected = "UNCLASSIFIED_FOUO";
        assertThat("filename", c.toClassificationFileNameString(), is(equalTo(expected)));

        assertEquals(Sets.newLinkedHashSet(Level.UNCLASSIFIED), c.getLevels());
        assertEquals(Sets.newLinkedHashSet(), c.getCompartments());
        assertEquals(Arrays.asList(DisseminationControl.FOUO), c.getDisseminationControls());
        assertEquals(Sets.newLinkedHashSet(), c.getReleasabilities());
    }

    @Test
    public void testFromJblocks() throws InvalidClassificationException {
        final MarkingsDefinition MARKINGS_DEFINITION = NsaMarkingsDefinition.buildLatest();
        jblocks.dataheaders.classification.Classification classification =
                jblocks.dataheaders.classification.Classification.parse(MARKINGS_DEFINITION, "UNCLASSIFIED//FOUO");
        assertEquals(fromJBlocksClassification(classification).toClassificationString(), "UNCLASSIFIED//FOUO");
    }

    @Test
    public void testInvalidClassificationString() {
        assertThrows(InvalidClassificationException.class, () -> fromString("UNCLASSIFIED///FOUO"));
    }

    @Test
    public void testEmptyClassificationString() {
        assertThrows(InvalidClassificationException.class, () -> fromString(""));
    }

    @Test
    public void testNullClassificationString1() {
        assertThrows(InvalidClassificationException.class, () -> fromString(null));
    }

    @Test
    public void testNullClassificationString2() {
        assertThrows(InvalidClassificationException.class, () -> fromJBlocksClassification(null));
    }
}
