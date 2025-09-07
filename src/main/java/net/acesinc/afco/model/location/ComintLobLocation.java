/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

import lombok.experimental.SuperBuilder;

/**
 *
 * @author jeremytaylor
 */
@SuperBuilder
public class ComintLobLocation extends LobLocation {
    public ComintLobLocation() {
        setLobType(LobType.COMINT_LOB);
    }
}
