package net.acesinc.afco.model.filesystem;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.acesinc.afco.model.hal.HALResponse;

@JsonPropertyOrder({"name", "fullPath", "parentPath", "type", "_links"})
public class FileSystemPath extends HALResponse implements Comparable<FileSystemPath> {

    private String name;
    private String fullPath;
    private FileSystemPathType type;

    /**
     * Sort in alphabetical order by fullPath using the String.compareTo
     */
    @Override
    public int compareTo(FileSystemPath o) {
        return this.fullPath.compareTo(o.fullPath);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the fullPath
     */
    public String getFullPath() {
        return fullPath;
    }
    /**
     * @param fullPath the fullPath to set
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
    /**
     * @return the type
     */
    public FileSystemPathType getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(FileSystemPathType type) {
        this.type = type;
    }
}
