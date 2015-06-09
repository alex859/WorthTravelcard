
package uk.gov.tfl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "$type",
    "stationId",
    "icsId",
    "topMostParentId",
    "modes",
    "stopType",
    "zone",
    "id",
    "name",
    "lat",
    "lon",
    "parentId"
})
public class Match {

    @JsonProperty("$type")
    private String $type;
    @JsonProperty("stationId")
    private String stationId;
    @JsonProperty("icsId")
    private String icsId;
    @JsonProperty("topMostParentId")
    private String topMostParentId;
    @JsonProperty("modes")
    private List<String> modes = new ArrayList<String>();
    @JsonProperty("stopType")
    private String stopType;
    @JsonProperty("zone")
    private String zone;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("parentId")
    private String parentId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The $type
     */
    @JsonProperty("$type")
    public String get$type() {
        return $type;
    }

    /**
     * 
     * @param $type
     *     The $type
     */
    @JsonProperty("$type")
    public void set$type(String $type) {
        this.$type = $type;
    }

    /**
     * 
     * @return
     *     The stationId
     */
    @JsonProperty("stationId")
    public String getStationId() {
        return stationId;
    }

    /**
     * 
     * @param stationId
     *     The stationId
     */
    @JsonProperty("stationId")
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    /**
     * 
     * @return
     *     The icsId
     */
    @JsonProperty("icsId")
    public String getIcsId() {
        return icsId;
    }

    /**
     * 
     * @param icsId
     *     The icsId
     */
    @JsonProperty("icsId")
    public void setIcsId(String icsId) {
        this.icsId = icsId;
    }

    /**
     * 
     * @return
     *     The topMostParentId
     */
    @JsonProperty("topMostParentId")
    public String getTopMostParentId() {
        return topMostParentId;
    }

    /**
     * 
     * @param topMostParentId
     *     The topMostParentId
     */
    @JsonProperty("topMostParentId")
    public void setTopMostParentId(String topMostParentId) {
        this.topMostParentId = topMostParentId;
    }

    /**
     * 
     * @return
     *     The modes
     */
    @JsonProperty("modes")
    public List<String> getModes() {
        return modes;
    }

    /**
     * 
     * @param modes
     *     The modes
     */
    @JsonProperty("modes")
    public void setModes(List<String> modes) {
        this.modes = modes;
    }

    /**
     * 
     * @return
     *     The stopType
     */
    @JsonProperty("stopType")
    public String getStopType() {
        return stopType;
    }

    /**
     * 
     * @param stopType
     *     The stopType
     */
    @JsonProperty("stopType")
    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

    /**
     * 
     * @return
     *     The zone
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * 
     * @param zone
     *     The zone
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The lat
     */
    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lon
     */
    @JsonProperty("lon")
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    @JsonProperty("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The parentId
     */
    @JsonProperty("parentId")
    public String getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId
     *     The parentId
     */
    @JsonProperty("parentId")
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append($type).append(stationId).append(icsId).append(topMostParentId).append(modes).append(stopType).append(zone).append(id).append(name).append(lat).append(lon).append(parentId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Match) == false) {
            return false;
        }
        Match rhs = ((Match) other);
        return new EqualsBuilder().append($type, rhs.$type).append(stationId, rhs.stationId).append(icsId, rhs.icsId).append(topMostParentId, rhs.topMostParentId).append(modes, rhs.modes).append(stopType, rhs.stopType).append(zone, rhs.zone).append(id, rhs.id).append(name, rhs.name).append(lat, rhs.lat).append(lon, rhs.lon).append(parentId, rhs.parentId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
