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
public class FileSource implements Source {
    private String fileId;

    @Override
    public String getType() {
        return "File";
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
}
