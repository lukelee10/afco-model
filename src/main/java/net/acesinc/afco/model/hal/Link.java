package net.acesinc.afco.model.hal;

public class Link {

    private String href;

    public Link(String href) {
        super();
        this.href = href;
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) {
        this.href = href;
    }
}
