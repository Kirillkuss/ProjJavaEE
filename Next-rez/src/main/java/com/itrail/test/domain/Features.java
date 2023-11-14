package com.itrail.test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author barysevich_k
 */

public class Features {
    
    private String type;
    private BigDecimal geometry;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> properties;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Map<String,String>> propertie;
    private String id;
    private String geometry_name;

    public Features() {
    }

    public Features(String type, BigDecimal geometry, Map<String, String> properties, String id, String geometry_name) {
        this.type = type;
        this.geometry = geometry;
        this.properties = properties;
        this.id = id;
        this.geometry_name = geometry_name;
    }
    
    public Features(String type, BigDecimal geometry, List<Map<String, String>> propertie, String id, String geometry_name) {
        this.type = type;
        this.geometry = geometry;
        this.propertie = propertie;
        this.id = id;
        this.geometry_name = geometry_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getGeometry() {
        return geometry;
    }

    public void setGeometry(BigDecimal geometry) {
        this.geometry = geometry;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public List<Map<String, String>> getPropertie() {
        return propertie;
    }

    public void setPropertie(List<Map<String, String>> propertie) {
        this.propertie = propertie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGeometry_name() {
        return geometry_name;
    }

    public void setGeometry_name(String geometry_name) {
        this.geometry_name = geometry_name;
    }

    @Override
    public String toString() {
        return "Features{" + "type=" + type + ", geometry=" + geometry + ", properties=" + properties + ", propertie=" + propertie + ", id=" + id + ", geometry_name=" + geometry_name + '}';
    }
    


    
       
}
