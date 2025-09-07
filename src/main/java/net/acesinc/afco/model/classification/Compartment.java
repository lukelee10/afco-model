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
public enum Compartment {
    // Order is important here as we use the ordinal value for sorting.
    SI,
    TK,
    G,
    HCS,
    STLW,
    EL,
    KDK,
    RSV,
    BYE,
    EL_EU,
    EL_NK,
    HCS_O,
    HCS_P,
    KDK_BLFH,
    KDK_IDIT,
    KDK_KAND;
}
