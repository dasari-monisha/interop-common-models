package com.yubi.interop.interopcommonmodels.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity(name = "Asset")
@Table(name = "assets")
public class Asset {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_type_id")
    private AssetType assetType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disbursement_id")
    private Disbursement disbursement;

    @Column(name = "attribute_schema_id")
    private Integer attributeSchemaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "product_asset_id")
    private Integer productAssetId;

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

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Disbursement getDisbursement() {
        return disbursement;
    }

    public void setDisbursement(Disbursement disbursement) {
        this.disbursement = disbursement;
    }

    public Integer getAttributeSchemaId() {
        return attributeSchemaId;
    }

    public void setAttributeSchemaId(Integer attributeSchemaId) {
        this.attributeSchemaId = attributeSchemaId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductAssetId() {
        return productAssetId;
    }

    public void setProductAssetId(Integer productAssetId) {
        this.productAssetId = productAssetId;
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