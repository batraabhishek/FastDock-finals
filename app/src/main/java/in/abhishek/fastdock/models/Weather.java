
package in.abhishek.fastdock.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Weather {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("current")
    @Expose
    private Current current;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather() {
    }

    /**
     * 
     * @param location
     * @param current
     */
    public Weather(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The current
     */
    public Current getCurrent() {
        return current;
    }

    /**
     * 
     * @param current
     *     The current
     */
    public void setCurrent(Current current) {
        this.current = current;
    }

}
