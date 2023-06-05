package com.data.entity;


import java.util.Date;

public class Audit {
    // data that was changed before and after
    private int auditId;
    private String operationName;
    private String initialValue;
    private String changedValue;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;

    //for creation of entry
    public Audit(int auditId, String operationName, String initialValue, String changedValue,
                 Date createdDate, String createdBy, Date modifiedDate, String modifiedBy) {
        this.auditId = auditId;
        this.operationName = operationName;
        this.initialValue = initialValue;
        this.changedValue = changedValue;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    //only for updates
    public Audit(int auditId, String operationName, String initialValue, String changedValue, Date modifiedDate, String modifiedBy) {
        this.auditId = auditId;
        this.operationName = operationName;
        this.initialValue = initialValue;
        this.changedValue = changedValue;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }

    public String getChangedValue() {
        return changedValue;
    }

    public void setChangedValue(String changedValue) {
        this.changedValue = changedValue;
    }
}
