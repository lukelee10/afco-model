/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.view;

/**
 * Views definitions to be used with @JsonView Annotations
 * @author andrewserff
 */
public class Views {

    public interface DefaultView {}

    public interface MapView extends DefaultView {}

    public interface DashboardView extends MapView {}

    public interface FullView extends DashboardView {}
}
