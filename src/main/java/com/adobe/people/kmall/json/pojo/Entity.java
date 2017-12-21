package com.adobe.people.kmall.json.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "rel",
        "links",
        "class",
        "properties"
})
public class Entity {

    @JsonProperty("rel")
    private List<String> rel = null;
    @JsonProperty("links")
    private List<Link> links = null;
    @JsonProperty("class")
    private List<String> _class = null;
    @JsonProperty("properties")
    private Properties properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rel")
    public List<String> getRel() {
        return rel;
    }

    @JsonProperty("rel")
    public void setRel(List<String> rel) {
        this.rel = rel;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @JsonProperty("class")
    public List<String> getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(List<String> _class) {
        this._class = _class;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
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