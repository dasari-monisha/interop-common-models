package com.yubi.interop.interopcommonmodels.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity(name = "Customer")
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_type_id")
    private BorrowerType borrowerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_schema_id")
    private AttributeSchema attributeSchema;

    @Lob
    @Column(name = "product_customer_id")
    private String productCustomerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrower_category_id")
    private BorrowerCategory borrowerCategory;

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

    public BorrowerType getBorrowerType() {
        return borrowerType;
    }

    public void setBorrowerType(BorrowerType borrowerType) {
        this.borrowerType = borrowerType;
    }

    public AttributeSchema getAttributeSchema() {
        return attributeSchema;
    }

    public void setAttributeSchema(AttributeSchema attributeSchema) {
        this.attributeSchema = attributeSchema;
    }

    public String getProductCustomerId() {
        return productCustomerId;
    }

    public void setProductCustomerId(String productCustomerId) {
        this.productCustomerId = productCustomerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BorrowerCategory getBorrowerCategory() {
        return borrowerCategory;
    }

    public void setBorrowerCategory(BorrowerCategory borrowerCategory) {
        this.borrowerCategory = borrowerCategory;
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