/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.acesinc.afco.model.classification;

import java.io.Serializable;

/**
 *
 * @author andrewserff
 */
public enum Level implements Serializable {
    // The order of these enum values matters as we're using the ordinal value to determine which level is greater
    // than another.
    UNCLASSIFIED("UNCLASSIFIED", "U"),
    CONFIDENTIAL("CONFIDENTIAL", "C"),
    SECRET("SECRET", "S"),
    TOP_SECRET("TOP SECRET", "TS");

    private final String name;
    private final String abbrev;

    Level(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
    }

    public String getName() {
        return name;
    }

    public static Level fromString(String name) {
        for (Level e : values()) {
            if (e.name.equals(name) || e.abbrev.equals(name)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Unsupported enum value '" + name + "' for " + Level.class.getName());
    }
}
