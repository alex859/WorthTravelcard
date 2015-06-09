
package uk.gov.tfl;

import java.util.HashMap;
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
    "bulletOrder",
    "messageText"
})
public class Message {

    @JsonProperty("$type")
    private String $type;
    @JsonProperty("bulletOrder")
    private Integer bulletOrder;
    @JsonProperty("messageText")
    private String messageText;
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
     *     The bulletOrder
     */
    @JsonProperty("bulletOrder")
    public Integer getBulletOrder() {
        return bulletOrder;
    }

    /**
     * 
     * @param bulletOrder
     *     The bulletOrder
     */
    @JsonProperty("bulletOrder")
    public void setBulletOrder(Integer bulletOrder) {
        this.bulletOrder = bulletOrder;
    }

    /**
     * 
     * @return
     *     The messageText
     */
    @JsonProperty("messageText")
    public String getMessageText() {
        return messageText;
    }

    /**
     * 
     * @param messageText
     *     The messageText
     */
    @JsonProperty("messageText")
    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
        return new HashCodeBuilder().append($type).append(bulletOrder).append(messageText).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Message) == false) {
            return false;
        }
        Message rhs = ((Message) other);
        return new EqualsBuilder().append($type, rhs.$type).append(bulletOrder, rhs.bulletOrder).append(messageText, rhs.messageText).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
