
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
    "startDate",
    "endDate",
    "passengerType",
    "from",
    "to",
    "fromStation",
    "toStation",
    "displayName",
    "displayOrder",
    "specialFare",
    "throughFare",
    "isTour",
    "ticketsAvailable",
    "messages"
})
public class Row {

    @JsonProperty("$type")
    private String $type;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("passengerType")
    private String passengerType;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;
    @JsonProperty("fromStation")
    private String fromStation;
    @JsonProperty("toStation")
    private String toStation;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("displayOrder")
    private Integer displayOrder;
    @JsonProperty("specialFare")
    private Boolean specialFare;
    @JsonProperty("throughFare")
    private Boolean throughFare;
    @JsonProperty("isTour")
    private Boolean isTour;
    @JsonProperty("ticketsAvailable")
    private List<TicketsAvailable> ticketsAvailable = new ArrayList<TicketsAvailable>();
    @JsonProperty("messages")
    private List<Object> messages = new ArrayList<Object>();
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
     *     The startDate
     */
    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The startDate
     */
    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The endDate
     */
    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 
     * @return
     *     The passengerType
     */
    @JsonProperty("passengerType")
    public String getPassengerType() {
        return passengerType;
    }

    /**
     * 
     * @param passengerType
     *     The passengerType
     */
    @JsonProperty("passengerType")
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    /**
     * 
     * @return
     *     The from
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * 
     * @param from
     *     The from
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 
     * @return
     *     The to
     */
    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    /**
     * 
     * @param to
     *     The to
     */
    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * 
     * @return
     *     The fromStation
     */
    @JsonProperty("fromStation")
    public String getFromStation() {
        return fromStation;
    }

    /**
     * 
     * @param fromStation
     *     The fromStation
     */
    @JsonProperty("fromStation")
    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    /**
     * 
     * @return
     *     The toStation
     */
    @JsonProperty("toStation")
    public String getToStation() {
        return toStation;
    }

    /**
     * 
     * @param toStation
     *     The toStation
     */
    @JsonProperty("toStation")
    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    /**
     * 
     * @return
     *     The displayName
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The displayName
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The displayOrder
     */
    @JsonProperty("displayOrder")
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * 
     * @param displayOrder
     *     The displayOrder
     */
    @JsonProperty("displayOrder")
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * 
     * @return
     *     The specialFare
     */
    @JsonProperty("specialFare")
    public Boolean getSpecialFare() {
        return specialFare;
    }

    /**
     * 
     * @param specialFare
     *     The specialFare
     */
    @JsonProperty("specialFare")
    public void setSpecialFare(Boolean specialFare) {
        this.specialFare = specialFare;
    }

    /**
     * 
     * @return
     *     The throughFare
     */
    @JsonProperty("throughFare")
    public Boolean getThroughFare() {
        return throughFare;
    }

    /**
     * 
     * @param throughFare
     *     The throughFare
     */
    @JsonProperty("throughFare")
    public void setThroughFare(Boolean throughFare) {
        this.throughFare = throughFare;
    }

    /**
     * 
     * @return
     *     The isTour
     */
    @JsonProperty("isTour")
    public Boolean getIsTour() {
        return isTour;
    }

    /**
     * 
     * @param isTour
     *     The isTour
     */
    @JsonProperty("isTour")
    public void setIsTour(Boolean isTour) {
        this.isTour = isTour;
    }

    /**
     * 
     * @return
     *     The ticketsAvailable
     */
    @JsonProperty("ticketsAvailable")
    public List<TicketsAvailable> getTicketsAvailable() {
        return ticketsAvailable;
    }

    /**
     * 
     * @param ticketsAvailable
     *     The ticketsAvailable
     */
    @JsonProperty("ticketsAvailable")
    public void setTicketsAvailable(List<TicketsAvailable> ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    /**
     * 
     * @return
     *     The messages
     */
    @JsonProperty("messages")
    public List<Object> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     *     The messages
     */
    @JsonProperty("messages")
    public void setMessages(List<Object> messages) {
        this.messages = messages;
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
        return new HashCodeBuilder().append($type).append(startDate).append(endDate).append(passengerType).append(from).append(to).append(fromStation).append(toStation).append(displayName).append(displayOrder).append(specialFare).append(throughFare).append(isTour).append(ticketsAvailable).append(messages).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Row) == false) {
            return false;
        }
        Row rhs = ((Row) other);
        return new EqualsBuilder().append($type, rhs.$type).append(startDate, rhs.startDate).append(endDate, rhs.endDate).append(passengerType, rhs.passengerType).append(from, rhs.from).append(to, rhs.to).append(fromStation, rhs.fromStation).append(toStation, rhs.toStation).append(displayName, rhs.displayName).append(displayOrder, rhs.displayOrder).append(specialFare, rhs.specialFare).append(throughFare, rhs.throughFare).append(isTour, rhs.isTour).append(ticketsAvailable, rhs.ticketsAvailable).append(messages, rhs.messages).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
