package com.yubi.interop.interopcommonmodels.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity(name = "AssetVerification")
@Table(name = "asset_verifications")
public class AssetVerification {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_schema_id")
    private AttributeSchema attributeSchema;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public AttributeSchema getAttributeSchema() {
        return attributeSchema;
    }

    public void setAttributeSchema(AttributeSchema attributeSchema) {
        this.attributeSchema = attributeSchema;
    }


    @PrePersist
    protected void onCreate() {
        createdAt = Instant.from(LocalDateTime.now());
        updatedAt = Instant.from(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.from(LocalDateTime.now());
    }
/*
    TODO [JPA Buddy] create field to map the 'attributes' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "attributes", columnDefinition = "json")
    private Object attributes;
*/
}