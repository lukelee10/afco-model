/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.classification.comparator;

import java.io.Serializable;
import java.util.Comparator;
import net.acesinc.afco.model.classification.Compartment;

/**
 *
 * @author andrewserff
 */
public class CompartmentComparator implements Comparator<Compartment>, Serializable {

    @Override
    public int compare(Compartment o1, Compartment o2) {
        return o1.ordinal() - o2.ordinal();
    }
}
