/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.classification.comparator;

import java.io.Serializable;
import java.util.Comparator;
import net.acesinc.afco.model.classification.Level;

/**
 *
 * @author andrewserff
 */
public class LevelComparator implements Comparator<Level>, Serializable {

    @Override
    public int compare(Level o1, Level o2) {
        return o2.ordinal() - o1.ordinal();
    }
}
