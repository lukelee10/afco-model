/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model;

/**
 *
 * @author andrewserff
 */
public class AADFRaw {
    // just using f1, f2 to keep it generic for prototyping/testing
    // need to update to be more self documenting

    private String f1;
    private String f2;
    private String f3;
    private String f4;
    private String f5;
    private String f6;
    private String f7;
    private String f8;
    private String f9;
    private String f10;
    private String typeLine;

    public AADFRaw(
            String f1,
            String f2,
            String f3,
            String f4,
            String f5,
            String f6,
            String f7,
            String f8,
            String f9,
            String f10,
            String typeLine) {
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
        this.f6 = f6;
        this.f7 = f7;
        this.f8 = f8;
        this.f9 = f9;
        this.f10 = f10;
        this.typeLine = typeLine;
    }

    @Override
    public String toString() {
        return "F1=" + this.f1 + "::F2=" + this.f2 + "::F3=" + this.f3 + "::F4="
                + this.f4 + "::F5=" + this.f5 + "::F6=" + this.f6 + "::F7=" + this.f7 + "::F8="
                + this.f8 + "::F9=" + this.f9 + "::f10=" + this.f10 + "::typeLine=" + this.typeLine;
    }

    /**
     * @return the f1
     */
    public String getF1() {
        return f1;
    }

    /**
     * @param f1 the f1 to set
     */
    public void setF1(String f1) {
        this.f1 = f1;
    }

    /**
     * @return the f2
     */
    public String getF2() {
        return f2;
    }

    /**
     * @param f2 the f2 to set
     */
    public void setF2(String f2) {
        this.f2 = f2;
    }

    /**
     * @return the f3
     */
    public String getF3() {
        return f3;
    }

    /**
     * @param f3 the f3 to set
     */
    public void setF3(String f3) {
        this.f3 = f3;
    }

    /**
     * @return the f4
     */
    public String getF4() {
        return f4;
    }

    /**
     * @param f4 the f4 to set
     */
    public void setF4(String f4) {
        this.f4 = f4;
    }

    /**
     * @return the f5
     */
    public String getF5() {
        return f5;
    }

    /**
     * @param f5 the f5 to set
     */
    public void setF5(String f5) {
        this.f5 = f5;
    }

    /**
     * @return the f6
     */
    public String getF6() {
        return f6;
    }

    /**
     * @param f6 the f6 to set
     */
    public void setF6(String f6) {
        this.f6 = f6;
    }

    /**
     * @return the f7
     */
    public String getF7() {
        return f7;
    }

    /**
     * @param f7 the f7 to set
     */
    public void setF7(String f7) {
        this.f7 = f7;
    }

    /**
     * @return the f8
     */
    public String getF8() {
        return f8;
    }

    /**
     * @param f8 the f8 to set
     */
    public void setF8(String f8) {
        this.f8 = f8;
    }

    /**
     * @return the f9
     */
    public String getF9() {
        return f9;
    }

    /**
     * @param f9 the f9 to set
     */
    public void setF9(String f9) {
        this.f9 = f9;
    }

    /**
     * @return the f10
     */
    public String getF10() {
        return f10;
    }

    /**
     * @param f10 the f10 to set
     */
    public void setF10(String f10) {
        this.f10 = f10;
    }

    /**
     * @return the typeLine
     */
    public String getTypeLine() {
        return typeLine;
    }

    /**
     * @param typeLine the typeLine to set
     */
    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }
}
