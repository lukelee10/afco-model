package net.acesinc.afco.model.filesystem;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import net.acesinc.afco.model.hal.HALResponse;

@JsonPropertyOrder({"id", "count", "name", "fullPath", "_links"})
public class FileSystemCount extends HALResponse implements Comparable<FileSystemCount> {

    private long count = 0;
    private String id;
    private String name;
    private String fullPath;

    /**
     * Sort in alphabetical order by id using the String.compareTo
     */
    @Override
    public int compareTo(FileSystemCount o) {
        return this.id.compareTo(o.id);
    }

    /**
     * @return the count
     */
    public long getCount() {
        return count;
    }
    /**
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
}
