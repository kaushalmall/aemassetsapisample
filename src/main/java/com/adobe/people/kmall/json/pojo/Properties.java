package com.adobe.people.kmall.json.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "metadataSchema"
})
public class Properties {

    @JsonProperty("name")
    private String name;
    @JsonProperty("metadataSchema")
    private String metadataSchema;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("metadataSchema")
    public String getMetadataSchema() {
        return metadataSchema;
    }

    @JsonProperty("metadataSchema")
    public void setMetadataSchema(String metadataSchema) {
        this.metadataSchema = metadataSchema;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}