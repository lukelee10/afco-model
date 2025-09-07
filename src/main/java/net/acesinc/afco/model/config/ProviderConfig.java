/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeremytaylor
 */
public class ProviderConfig {

    private ProviderType type;

    @JsonProperty(required = false)
    private String url; // more common among more than one provider

    @JsonProperty(required = false)
    private boolean withCredentials; // used for CesiumTerrainProvider specifically

    @JsonProperty(required = false)
    private String token; // more common among more than one provider

    @JsonProperty(required = false)
    private String accessToken; // used for MapBox specifically

    @JsonProperty(required = false)
    private String key; // used for Bing specifically

    @JsonProperty(required = false)
    private String credit; // more common among more than one provider

    @JsonProperty(required = false)
    private String proxy; // more common among more than one provider

    @JsonProperty(required = false)
    private Parameters parameters; // used by WMS specifically

    @JsonProperty(required = false)
    private String gtFeatureInfoParameters;

    @JsonProperty(required = false)
    private String layers; // used for ArcGisMapServerImageryProvider and WMS specifically

    @JsonProperty(required = false)
    private String layer; // used for WebMapTileServiceImageryProvider specifically

    @JsonProperty(required = false)
    private String style; // used for WebMapTileServiceImageryProvider specifically

    @JsonProperty(required = false)
    private boolean enablePickFeatures; // used for ArcGisMapServerImageryProvider and WMS specifically

    @JsonProperty(required = false)
    private String tileProtocol; // used for Bing specifically

    @JsonProperty(required = false)
    private String mapStyle; // used for Bing specifically

    @JsonProperty(required = false)
    private String culture; // used for Bing specifically

    @JsonProperty(required = false)
    private Integer tileHeight; // used for ArcGisMapServerImageryProvider and WMS specifically

    @JsonProperty(required = false)
    private Integer tileWidth; // used for ArcGisMapServerImageryProvider and WMS specifically

    @JsonProperty(required = false)
    private Integer minimumLevel; // more common among more than one provider

    @JsonProperty(required = false)
    private Integer maximumLevel; // more common among more than one provider

    @JsonProperty(required = false)
    private String mapId; // used for mapbox specifically

    @JsonProperty(required = false)
    private String format; // used for mapbox specifically

    @JsonProperty(required = false)
    private String fileExtension; // used for openstreet map specifically

    @JsonProperty(required = false)
    private String tileMatrixSetID; // used for WebMapTileServiceImageryProvider specifically

    @JsonProperty(required = false)
    private String tileMatrixLabels; // used for WebMapTileServiceImageryProvider specifically

    @JsonProperty(required = false)
    private List<WmsFeatureInfoFormat> gtfeatureInfoFormats = new ArrayList<>(); // used for WMS specifically

    private boolean requestVertexNormals; // used for CesiumTerrainProvider specifically

    @JsonProperty(required = false)
    private boolean requestWaterMask; // used for CesiumTerrainProvider specifically

    @JsonProperty(required = false)
    private Integer channel; // used for GoogleEarthProvider specifically specifically

    @JsonProperty(required = false)
    private String path; // used for GoogleEarthProvider specifically specifically

    @JsonProperty(required = false)
    private boolean wgs84; // used for WMTS specifically

    @JsonProperty(required = false)
    private boolean legacy; // if true dont use ESRI leaflet plugin

    @JsonProperty(required = false)
    private String showOn; // Options: all,3D,2D,leaflet,mapbox

    /**
     * @return the type
     */
    public ProviderType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ProviderType type) {
        this.type = type;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     * @return the proxy
     */
    public String getProxy() {
        return proxy;
    }

    /**
     * @param proxy the proxy to set
     */
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    /**
     * @return the gtFeatureInfoParameters
     */
    public String getGtFeatureInfoParameters() {
        return gtFeatureInfoParameters;
    }

    /**
     * @param gtFeatureInfoParameters the gtFeatureInfoParameters to set
     */
    public void setGtFeatureInfoParameters(String gtFeatureInfoParameters) {
        this.gtFeatureInfoParameters = gtFeatureInfoParameters;
    }

    /**
     * @return the layers
     */
    public String getLayers() {
        return layers;
    }

    /**
     * @param layers the layers to set
     */
    public void setLayers(String layers) {
        this.layers = layers;
    }

    /**
     * @return the layer
     */
    public String getLayer() {
        return layer;
    }

    /**
     * @param layer the layer to set
     */
    public void setLayer(String layer) {
        this.layer = layer;
    }

    /**
     * @return the style
     */
    public String getStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @return the tileProtocol
     */
    public String getTileProtocol() {
        return tileProtocol;
    }

    /**
     * @param tileProtocol the tileProtocol to set
     */
    public void setTileProtocol(String tileProtocol) {
        this.tileProtocol = tileProtocol;
    }

    /**
     * @return the mapStyle
     */
    public String getMapStyle() {
        return mapStyle;
    }

    /**
     * @param mapStyle the mapStyle to set
     */
    public void setMapStyle(String mapStyle) {
        this.mapStyle = mapStyle;
    }

    /**
     * @return the culture
     */
    public String getCulture() {
        return culture;
    }

    /**
     * @param culture the culture to set
     */
    public void setCulture(String culture) {
        this.culture = culture;
    }

    /**
     * @return the tileHeight
     */
    public Integer getTileHeight() {
        return tileHeight;
    }

    /**
     * @param tileHeight the tileHeight to set
     */
    public void setTileHeight(Integer tileHeight) {
        this.tileHeight = tileHeight;
    }

    /**
     * @return the tileWidth
     */
    public Integer getTileWidth() {
        return tileWidth;
    }

    /**
     * @param tileWidth the tileWidth to set
     */
    public void setTileWidth(Integer tileWidth) {
        this.tileWidth = tileWidth;
    }

    /**
     * @return the minimumLevel
     */
    public Integer getMinimumLevel() {
        return minimumLevel;
    }

    /**
     * @param minimumLevel the minimumLevel to set
     */
    public void setMinimumLevel(Integer minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    /**
     * @return the maximumLevel
     */
    public Integer getMaximumLevel() {
        return maximumLevel;
    }

    /**
     * @param maximumLevel the maximumLevel to set
     */
    public void setMaximumLevel(Integer maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    /**
     * @return the mapId
     */
    public String getMapId() {
        return mapId;
    }

    /**
     * @param mapId the mapId to set
     */
    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return the fileExtension
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * @param fileExtension the fileExtension to set
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @return the tileMatrixSetID
     */
    public String getTileMatrixSetID() {
        return tileMatrixSetID;
    }

    /**
     * @param tileMatrixSetID the tileMatrixSetID to set
     */
    public void setTileMatrixSetID(String tileMatrixSetID) {
        this.tileMatrixSetID = tileMatrixSetID;
    }

    /**
     * @return the tileMatrixLabels
     */
    public String getTileMatrixLabels() {
        return tileMatrixLabels;
    }

    /**
     * @param tileMatrixLabels the tileMatrixLabels to set
     */
    public void setTileMatrixLabels(String tileMatrixLabels) {
        this.tileMatrixLabels = tileMatrixLabels;
    }

    /**
     * @return the gtfeatureInfoFormats
     */
    public List<WmsFeatureInfoFormat> getGtfeatureInfoFormats() {
        return gtfeatureInfoFormats;
    }

    /**
     * @param gtfeatureInfoFormats the gtfeatureInfoFormats to set
     */
    public void setGtfeatureInfoFormats(List<WmsFeatureInfoFormat> gtfeatureInfoFormats) {
        this.gtfeatureInfoFormats = gtfeatureInfoFormats;
    }

    /**
     * @return the channel
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the parameters
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the enablePickFeatures
     */
    public boolean isEnablePickFeatures() {
        return enablePickFeatures;
    }

    /**
     * @param enablePickFeatures the enablePickFeatures to set
     */
    public void setEnablePickFeatures(boolean enablePickFeatures) {
        this.enablePickFeatures = enablePickFeatures;
    }

    /**
     * @return the requestVertexNormals
     */
    public boolean isRequestVertexNormals() {
        return requestVertexNormals;
    }

    /**
     * @param requestVertexNormals the requestVertexNormals to set
     */
    public void setRequestVertexNormals(boolean requestVertexNormals) {
        this.requestVertexNormals = requestVertexNormals;
    }

    /**
     * @return the withCredentials
     */
    public boolean isWithCredentials() {
        return withCredentials;
    }

    /**
     * @param withCredentials the withCredentials to set
     */
    public void setWithCredentials(boolean withCredentials) {
        this.withCredentials = withCredentials;
    }

    /**
     * @return the requestWaterMask
     */
    public boolean isRequestWaterMask() {
        return requestWaterMask;
    }

    /**
     * @param requestWaterMask the requestWaterMask to set
     */
    public void setRequestWaterMask(boolean requestWaterMask) {
        this.requestWaterMask = requestWaterMask;
    }

    /**
     * @return the wgs84
     */
    public boolean isWgs84() {
        return wgs84;
    }

    /**
     * @param wgs84 the wgs84 to set
     */
    public void setWgs84(boolean wgs84) {
        this.wgs84 = wgs84;
    }

    public boolean isLegacy() {
        return legacy;
    }

    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
    }

    public String getShowOn() {
        return showOn;
    }

    public void setShowOn(String showOn) {
        this.showOn = showOn;
    }
}
