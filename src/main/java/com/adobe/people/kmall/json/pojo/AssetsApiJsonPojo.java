package com.adobe.people.kmall.json.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "entities",
        "links",
        "class",
        "actions",
        "properties"
})
public class AssetsApiJsonPojo {

    @JsonProperty("entities")
    private List<Entity> entities = null;
    @JsonProperty("links")
    private List<Link_> links = null;
    @JsonProperty("class")
    private List<String> _class = null;
    @JsonProperty("actions")
    private List<Action> actions = null;
    @JsonProperty("properties")
    private Properties_ properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("entities")
    public List<Entity> getEntities() {
        return entities;
    }

    @JsonProperty("entities")
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    @JsonProperty("links")
    public List<Link_> getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(List<Link_> links) {
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

    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @JsonProperty("properties")
    public Properties_ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties_ properties) {
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