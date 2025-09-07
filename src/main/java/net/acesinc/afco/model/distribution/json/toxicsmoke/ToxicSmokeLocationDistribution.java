package net.acesinc.afco.model.distribution.json.toxicsmoke;

import org.springframework.data.geo.Point;

/**
 * This is a Toxicsmoke specific solution to marshall and demarshall JSON. This class is used for serializing/deserializing a org.springframework.data.geo.Point object into lat/lon properties when
 * distributing to external systems. NiFi does make a service call to update the data source and so this class will get deserialized as well.
 */
public class ToxicSmokeLocationDistribution {

    private double lat;
    private double lon;

    public ToxicSmokeLocationDistribution(Point point) {
        super();
        this.lat = point.getY();
        this.lon = point.getX();
    }

    public ToxicSmokeLocationDistribution() {
        super();
    }

    /**
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * @param lon the lon to set
     */
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * @return The associated Point object
     */
    public Point toPoint() {
        return new Point(lon, lat);
    }
}
