package net.acesinc.afco.model.dgsSiteReference;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dgsSiteReference")
public class DgsSiteReference {

    private String id;
    private String sigad;
    private String dgsSite;
    private List<String> expectedPddgs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSigad() {
        return sigad;
    }

    public void setSigad(String sigad) {
        this.sigad = sigad;
    }

    public String getDgsSite() {
        return dgsSite;
    }

    public void setDgsSite(String dgsSite) {
        this.dgsSite = dgsSite;
    }

    public List<String> getExpectedPddgs() {
        return expectedPddgs;
    }

    public void setExpectedPddgs(List<String> expectedPddgs) {
        this.expectedPddgs = expectedPddgs;
    }
}
