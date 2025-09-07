/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

/**
 *
 * @author jeremytaylor
 */
public class ElintLobLocation extends LobLocation {

    //    @JsonView(Views.DefaultView.class)
    private ConeAxis coneAxis;

    public ElintLobLocation() {
        setLobType(LobType.ELINT_LOB);
    }

    /**
     * @return the coneAxis
     */
    public ConeAxis getConeAxis() {
        return coneAxis;
    }

    /**
     * @param coneAxis the coneAxis to set
     */
    public void setConeAxis(ConeAxis coneAxis) {
        this.coneAxis = coneAxis;
    }
}
