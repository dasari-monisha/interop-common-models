package com.yubi.interop.interopcommonmodels.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Disbursement")
@Table(name = "disbursements")
public class Disbursement {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "disbursed_amount")
    private Integer disbursedAmount;

    @Column(name = "disbursement_date")
    private LocalDate disbursementDate;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    @Column(name = "attribute_schema_id")
    private Integer attributeSchemaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "product_disbursement_id")
    private Integer productDisbursementId;

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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getDisbursedAmount() {
        return disbursedAmount;
    }

    public void setDisbursedAmount(Integer disbursedAmount) {
        this.disbursedAmount = disbursedAmount;
    }

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(LocalDate disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
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

    public Integer getProductDisbursementId() {
        return productDisbursementId;
    }

    public void setProductDisbursementId(Integer productDisbursementId) {
        this.productDisbursementId = productDisbursementId;
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