package net.acesinc.afco.model.special.signal;

import com.fasterxml.jackson.annotation.JsonView;
import net.acesinc.afco.model.view.Views;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "specialSignalFolder")
public class SpecialSignalFolder {

    @Id
    @JsonView(Views.DefaultView.class)
    private String id;

    @JsonView(Views.DefaultView.class)
    private String folder;

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
    public String getFolder() {
        return folder;
    }
    /**
     * @param folder the folder to set
     */
    public void setFolder(String folder) {
        this.folder = folder;
    }
}
