package com.itrail.test.domain;

import java.util.List;

/**
 *
 * @author barysevich_k
 */
public class TotalFeatures {
    
    private Long totalFeatures;
    private String type;
    private List<Features> features;

    public TotalFeatures() {
    }

    public TotalFeatures(Long totalFeatures, String type, List<Features> features) {
        this.totalFeatures = totalFeatures;
        this.type = type;
        this.features = features;
    }

    public Long getTotalFeatures() {
        return totalFeatures;
    }

    public void setTotalFeatures(Long totalFeatures) {
        this.totalFeatures = totalFeatures;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Features> getFeatures() {
        return features;
    }

    public void setFeatures(List<Features> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "TotalFeatures{" + "totalFeatures=" + totalFeatures + ", type=" + type + ", features=" + features + '}';
    }
    
   
}
