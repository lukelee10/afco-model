/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.location;

/**
 *
 * @author andrewserff
 */
public class AADFPlatformLocation extends PlatformLocation {
    private Integer subFileNo;

    /**
     * @return the subFileNo
     */
    public Integer getSubFileNo() {
        return subFileNo;
    }

    /**
     * @param subFileNo the subFileNo to set
     */
    public void setSubFileNo(Integer subFileNo) {
        this.subFileNo = subFileNo;
    }
}
