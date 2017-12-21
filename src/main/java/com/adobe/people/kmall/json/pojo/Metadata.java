package com.adobe.people.kmall.json.pojo;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "mvText",
        "xmp:ModifyDate",
        "xmp:MetadataDate",
        "xmp:CreatorTool",
        "xmp:CreateDate",
        "dc:modified",
        "dc:format",
        "dropdown"
})
public class Metadata {

    @JsonProperty("mvText")
    private List<String> mvText = null;
    @JsonProperty("xmp:ModifyDate")
    private String xmpModifyDate;
    @JsonProperty("xmp:MetadataDate")
    private String xmpMetadataDate;
    @JsonProperty("xmp:CreatorTool")
    private String xmpCreatorTool;
    @JsonProperty("xmp:CreateDate")
    private String xmpCreateDate;
    @JsonProperty("dc:modified")
    private String dcModified;
    @JsonProperty("dc:format")
    private String dcFormat;
    @JsonProperty("dropdown")
    private List<String> dropdown = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("mvText")
    public List<String> getMvText() {
        return mvText;
    }

    @JsonProperty("mvText")
    public void setMvText(List<String> mvText) {
        this.mvText = mvText;
    }

    @JsonProperty("xmp:ModifyDate")
    public String getXmpModifyDate() {
        return xmpModifyDate;
    }

    @JsonProperty("xmp:ModifyDate")
    public void setXmpModifyDate(String xmpModifyDate) {
        this.xmpModifyDate = xmpModifyDate;
    }

    @JsonProperty("xmp:MetadataDate")
    public String getXmpMetadataDate() {
        return xmpMetadataDate;
    }

    @JsonProperty("xmp:MetadataDate")
    public void setXmpMetadataDate(String xmpMetadataDate) {
        this.xmpMetadataDate = xmpMetadataDate;
    }

    @JsonProperty("xmp:CreatorTool")
    public String getXmpCreatorTool() {
        return xmpCreatorTool;
    }

    @JsonProperty("xmp:CreatorTool")
    public void setXmpCreatorTool(String xmpCreatorTool) {
        this.xmpCreatorTool = xmpCreatorTool;
    }

    @JsonProperty("xmp:CreateDate")
    public String getXmpCreateDate() {
        return xmpCreateDate;
    }

    @JsonProperty("xmp:CreateDate")
    public void setXmpCreateDate(String xmpCreateDate) {
        this.xmpCreateDate = xmpCreateDate;
    }

    @JsonProperty("dc:modified")
    public String getDcModified() {
        return dcModified;
    }

    @JsonProperty("dc:modified")
    public void setDcModified(String dcModified) {
        this.dcModified = dcModified;
    }

    @JsonProperty("dc:format")
    public String getDcFormat() {
        return dcFormat;
    }

    @JsonProperty("dc:format")
    public void setDcFormat(String dcFormat) {
        this.dcFormat = dcFormat;
    }

    @JsonProperty("dropdown")
    public List<String> getDropdown() {
        return dropdown;
    }

    @JsonProperty("dropdown")
    public void setDropdown(List<String> dropdown) {
        this.dropdown = dropdown;
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