
package in.abhishek.fastdock.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Location {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("tz_id")
    @Expose
    private String tzId;
    @SerializedName("localtime_epoch")
    @Expose
    private Integer localtimeEpoch;
    @SerializedName("localtime")
    @Expose
    private String localtime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Location() {
    }

    /**
     * 
     * @param region
     * @param localtime
     * @param tzId
     * @param lon
     * @param localtimeEpoch
     * @param name
     * @param lat
     * @param country
     */
    public Location(String name, String region, String country, Double lat, Double lon, String tzId, Integer localtimeEpoch, String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tzId = tzId;
        this.localtimeEpoch = localtimeEpoch;
        this.localtime = localtime;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The region
     */
    public String getRegion() {
        return region;
    }

    /**
     * 
     * @param region
     *     The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The tzId
     */
    public String getTzId() {
        return tzId;
    }

    /**
     * 
     * @param tzId
     *     The tz_id
     */
    public void setTzId(String tzId) {
        this.tzId = tzId;
    }

    /**
     * 
     * @return
     *     The localtimeEpoch
     */
    public Integer getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    /**
     * 
     * @param localtimeEpoch
     *     The localtime_epoch
     */
    public void setLocaltimeEpoch(Integer localtimeEpoch) {
        this.localtimeEpoch = localtimeEpoch;
    }

    /**
     * 
     * @return
     *     The localtime
     */
    public String getLocaltime() {
        return localtime;
    }

    /**
     * 
     * @param localtime
     *     The localtime
     */
    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

}
