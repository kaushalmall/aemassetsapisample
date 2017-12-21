package com.adobe.people.kmall.json.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cq:allowedTemplates",
        "name",
        "srn:paging"
})
public class Properties_ {

    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("cq:allowedTemplates")
    private List<String> cqAllowedTemplates = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("srn:paging")
    private SrnPaging srnPaging;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cq:allowedTemplates")
    public List<String> getCqAllowedTemplates() {
        return cqAllowedTemplates;
    }

    @JsonProperty("cq:allowedTemplates")
    public void setCqAllowedTemplates(List<String> cqAllowedTemplates) {
        this.cqAllowedTemplates = cqAllowedTemplates;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("srn:paging")
    public SrnPaging getSrnPaging() {
        return srnPaging;
    }

    @JsonProperty("srn:paging")
    public void setSrnPaging(SrnPaging srnPaging) {
        this.srnPaging = srnPaging;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}