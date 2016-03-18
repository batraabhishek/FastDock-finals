
package in.abhishek.fastdock.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Current {

    @SerializedName("last_updated_epoch")
    @Expose
    private Integer lastUpdatedEpoch;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("temp_c")
    @Expose
    private Double tempC;
    @SerializedName("temp_f")
    @Expose
    private Double tempF;
    @SerializedName("condition")
    @Expose
    private Condition condition;
    @SerializedName("wind_mph")
    @Expose
    private Double windMph;
    @SerializedName("wind_kph")
    @Expose
    private Double windKph;
    @SerializedName("wind_degree")
    @Expose
    private Integer windDegree;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mb")
    @Expose
    private Integer pressureMb;
    @SerializedName("pressure_in")
    @Expose
    private Double pressureIn;
    @SerializedName("precip_mm")
    @Expose
    private Double precipMm;
    @SerializedName("precip_in")
    @Expose
    private Double precipIn;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("cloud")
    @Expose
    private Integer cloud;
    @SerializedName("feelslike_c")
    @Expose
    private Double feelslikeC;
    @SerializedName("feelslike_f")
    @Expose
    private Double feelslikeF;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Current() {
    }

    /**
     * 
     * @param tempC
     * @param feelslikeC
     * @param condition
     * @param pressureMb
     * @param windKph
     * @param precipMm
     * @param lastUpdated
     * @param windMph
     * @param windDegree
     * @param humidity
     * @param lastUpdatedEpoch
     * @param precipIn
     * @param cloud
     * @param pressureIn
     * @param tempF
     * @param feelslikeF
     * @param windDir
     */
    public Current(Integer lastUpdatedEpoch, String lastUpdated, Double tempC, Double tempF, Condition condition, Double windMph, Double windKph, Integer windDegree, String windDir, Integer pressureMb, Double pressureIn, Double precipMm, Double precipIn, Integer humidity, Integer cloud, Double feelslikeC, Double feelslikeF) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
        this.lastUpdated = lastUpdated;
        this.tempC = tempC;
        this.tempF = tempF;
        this.condition = condition;
        this.windMph = windMph;
        this.windKph = windKph;
        this.windDegree = windDegree;
        this.windDir = windDir;
        this.pressureMb = pressureMb;
        this.pressureIn = pressureIn;
        this.precipMm = precipMm;
        this.precipIn = precipIn;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslikeC = feelslikeC;
        this.feelslikeF = feelslikeF;
    }

    /**
     * 
     * @return
     *     The lastUpdatedEpoch
     */
    public Integer getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    /**
     * 
     * @param lastUpdatedEpoch
     *     The last_updated_epoch
     */
    public void setLastUpdatedEpoch(Integer lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The last_updated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 
     * @return
     *     The tempC
     */
    public Double getTempC() {
        return tempC;
    }

    /**
     * 
     * @param tempC
     *     The temp_c
     */
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    /**
     * 
     * @return
     *     The tempF
     */
    public Double getTempF() {
        return tempF;
    }

    /**
     * 
     * @param tempF
     *     The temp_f
     */
    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    /**
     * 
     * @return
     *     The condition
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition
     *     The condition
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    /**
     * 
     * @return
     *     The windMph
     */
    public Double getWindMph() {
        return windMph;
    }

    /**
     * 
     * @param windMph
     *     The wind_mph
     */
    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

    /**
     * 
     * @return
     *     The windKph
     */
    public Double getWindKph() {
        return windKph;
    }

    /**
     * 
     * @param windKph
     *     The wind_kph
     */
    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    /**
     * 
     * @return
     *     The windDegree
     */
    public Integer getWindDegree() {
        return windDegree;
    }

    /**
     * 
     * @param windDegree
     *     The wind_degree
     */
    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    /**
     * 
     * @return
     *     The windDir
     */
    public String getWindDir() {
        return windDir;
    }

    /**
     * 
     * @param windDir
     *     The wind_dir
     */
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    /**
     * 
     * @return
     *     The pressureMb
     */
    public Integer getPressureMb() {
        return pressureMb;
    }

    /**
     * 
     * @param pressureMb
     *     The pressure_mb
     */
    public void setPressureMb(Integer pressureMb) {
        this.pressureMb = pressureMb;
    }

    /**
     * 
     * @return
     *     The pressureIn
     */
    public Double getPressureIn() {
        return pressureIn;
    }

    /**
     * 
     * @param pressureIn
     *     The pressure_in
     */
    public void setPressureIn(Double pressureIn) {
        this.pressureIn = pressureIn;
    }

    /**
     * 
     * @return
     *     The precipMm
     */
    public Double getPrecipMm() {
        return precipMm;
    }

    /**
     * 
     * @param precipMm
     *     The precip_mm
     */
    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    /**
     * 
     * @return
     *     The precipIn
     */
    public Double getPrecipIn() {
        return precipIn;
    }

    /**
     * 
     * @param precipIn
     *     The precip_in
     */
    public void setPrecipIn(Double precipIn) {
        this.precipIn = precipIn;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The cloud
     */
    public Integer getCloud() {
        return cloud;
    }

    /**
     * 
     * @param cloud
     *     The cloud
     */
    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    /**
     * 
     * @return
     *     The feelslikeC
     */
    public Double getFeelslikeC() {
        return feelslikeC;
    }

    /**
     * 
     * @param feelslikeC
     *     The feelslike_c
     */
    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    /**
     * 
     * @return
     *     The feelslikeF
     */
    public Double getFeelslikeF() {
        return feelslikeF;
    }

    /**
     * 
     * @param feelslikeF
     *     The feelslike_f
     */
    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

}
