/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.classification.comparator;

import java.io.Serializable;
import java.util.Comparator;
import net.acesinc.afco.model.classification.Releasability;

/**
 *
 * @author andrewserff
 */
public class ReleasabilityComparator implements Comparator<Releasability>, Serializable {

    @Override
    public int compare(Releasability o1, Releasability o2) {
        return o1.ordinal() - o2.ordinal();
    }
}
