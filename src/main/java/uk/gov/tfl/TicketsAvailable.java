
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
    "passengerType",
    "ticketType",
    "ticketTime",
    "cost",
    "description",
    "mode",
    "displayOrder",
    "messages"
})
public class TicketsAvailable {

    @JsonProperty("$type")
    private String $type;
    @JsonProperty("passengerType")
    private String passengerType;
    @JsonProperty("ticketType")
    private TicketType ticketType;
    @JsonProperty("ticketTime")
    private TicketTime ticketTime;
    @JsonProperty("cost")
    private String cost;
    @JsonProperty("description")
    private String description;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("displayOrder")
    private Integer displayOrder;
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
     *     The ticketType
     */
    @JsonProperty("ticketType")
    public TicketType getTicketType() {
        return ticketType;
    }

    /**
     * 
     * @param ticketType
     *     The ticketType
     */
    @JsonProperty("ticketType")
    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * 
     * @return
     *     The ticketTime
     */
    @JsonProperty("ticketTime")
    public TicketTime getTicketTime() {
        return ticketTime;
    }

    /**
     * 
     * @param ticketTime
     *     The ticketTime
     */
    @JsonProperty("ticketTime")
    public void setTicketTime(TicketTime ticketTime) {
        this.ticketTime = ticketTime;
    }

    /**
     * 
     * @return
     *     The cost
     */
    @JsonProperty("cost")
    public String getCost() {
        return cost;
    }

    /**
     * 
     * @param cost
     *     The cost
     */
    @JsonProperty("cost")
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The mode
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * 
     * @param mode
     *     The mode
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
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
        return new HashCodeBuilder().append($type).append(passengerType).append(ticketType).append(ticketTime).append(cost).append(description).append(mode).append(displayOrder).append(messages).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TicketsAvailable) == false) {
            return false;
        }
        TicketsAvailable rhs = ((TicketsAvailable) other);
        return new EqualsBuilder().append($type, rhs.$type).append(passengerType, rhs.passengerType).append(ticketType, rhs.ticketType).append(ticketTime, rhs.ticketTime).append(cost, rhs.cost).append(description, rhs.description).append(mode, rhs.mode).append(displayOrder, rhs.displayOrder).append(messages, rhs.messages).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
