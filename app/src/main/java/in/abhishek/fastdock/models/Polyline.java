package in.abhishek.fastdock.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Polyline {

    @SerializedName("points")
    @Expose
    private String points;

    /**
     * No args constructor for use in serialization
     */
    public Polyline() {
    }

    /**
     * @param points
     */
    public Polyline(String points) {
        this.points = points;
    }

    /**
     * @return The points
     */
    public String getPoints() {
        return points;
    }

    /**
     * @param points The points
     */
    public void setPoints(String points) {
        this.points = points;
    }

}
