/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.purge;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

/**
 * @author dylankolson
 */
@Document(collection = "purgePartitionList")
public class PurgePartitionList {

    @Id
    private String id;

    private String partition;
    private double threshold;
    private int order;
    private Date alertLastSent;
    private boolean ruleThreshold;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getPartition() {
        return partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Nullable
    public Date getAlertLastSent() {
        return alertLastSent;
    }

    public void setAlertLastSent(Date alertLastSent) {
        this.alertLastSent = alertLastSent;
    }

    public boolean isRuleThreshold() {
        return ruleThreshold;
    }

    public void setRuleThreshold(boolean ruleThreshold) {
        this.ruleThreshold = ruleThreshold;
    }
}
