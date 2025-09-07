package net.acesinc.afco.model.hal;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.HashMap;
import java.util.Map;
import net.acesinc.afco.model.view.Views;

public abstract class HALResponse {

    public static final String SELF = "self";

    @JsonView(Views.FullView.class)
    private Map<String, Link> _links = new HashMap<>();

    public void addLink(String name, String value) {
        _links.put(name, new Link(value));
    }

    /**
     * @return the _links
     */
    public Map<String, Link> get_links() {
        return _links;
    }

    /**
     * @param _links the _links to set
     */
    public void set_links(Map<String, Link> _links) {
        this._links = _links;
    }
}
