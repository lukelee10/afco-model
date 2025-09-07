/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.acesinc.afco.model.classification;

/**
 *
 * @author andrewserff
 */
public enum Releasability {
    // Order is important here as we use the ordinal value for sorting.
    FOUO,
    USA,
    AUS,
    CAN,
    GBR,
    NZL,
    FVEY,
    ACGU,
    APFS,
    BWCS,
    CFCK,
    CMFC,
    CMFP,
    CNFC,
    CPMT,
    CWCS,
    ECTF,
    EFOR,
    GCTF,
    GMIF,
    IESC,
    ISAF,
    KFOR,
    MCFI,
    MIFH,
    NACT,
    NATO,
    OSAG,
    SFOR,
    UNCK;

    public static Releasability[] FVEY_SHORTCUT = {USA, AUS, CAN, GBR, NZL};
}
