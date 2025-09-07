/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.source;

/**
 *
 * @author andrewserff
 */
public class ManualSource implements Source {
    @Override
    public String getType() {
        return "Manual";
    }
}
