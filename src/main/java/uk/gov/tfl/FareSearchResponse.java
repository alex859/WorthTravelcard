
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
    "header",
    "index",
    "rows",
    "messages"
})
public class FareSearchResponse {

    @JsonProperty("$type")
    private String $type;
    @JsonProperty("header")
    private String header;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("rows")
    private List<Row> rows = new ArrayList<Row>();
    @JsonProperty("messages")
    private List<Message> messages = new ArrayList<Message>();
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
     *     The header
     */
    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    /**
     * 
     * @param header
     *     The header
     */
    @JsonProperty("header")
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 
     * @return
     *     The index
     */
    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The rows
     */
    @JsonProperty("rows")
    public List<Row> getRows() {
        return rows;
    }

    /**
     * 
     * @param rows
     *     The rows
     */
    @JsonProperty("rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    /**
     * 
     * @return
     *     The messages
     */
    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     *     The messages
     */
    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
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
        return new HashCodeBuilder().append($type).append(header).append(index).append(rows).append(messages).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FareSearchResponse) == false) {
            return false;
        }
        FareSearchResponse rhs = ((FareSearchResponse) other);
        return new EqualsBuilder().append($type, rhs.$type).append(header, rhs.header).append(index, rhs.index).append(rows, rhs.rows).append(messages, rhs.messages).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
