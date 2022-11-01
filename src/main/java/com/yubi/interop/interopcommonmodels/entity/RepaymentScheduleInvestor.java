package com.yubi.interop.interopcommonmodels.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "RepaymentScheduleInvestor")
@Table(name = "repayment_schedule_investors")
public class RepaymentScheduleInvestor {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "repayment_date")
    private LocalDate repaymentDate;

    @Column(name = "principal_amount")
    private Float principalAmount;

    @Column(name = "interest_amount")
    private Float interestAmount;

    @Column(name = "product_id")
    private Integer productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repayment_schedule_id")
    private RepaymentSchedule repaymentSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_schema_id")
    private AttributeSchema attributeSchema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_id")
    private Investor investor;

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

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(LocalDate repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Float getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Float principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Float getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Float interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public RepaymentSchedule getRepaymentSchedule() {
        return repaymentSchedule;
    }

    public void setRepaymentSchedule(RepaymentSchedule repaymentSchedule) {
        this.repaymentSchedule = repaymentSchedule;
    }

    public AttributeSchema getAttributeSchema() {
        return attributeSchema;
    }

    public void setAttributeSchema(AttributeSchema attributeSchema) {
        this.attributeSchema = attributeSchema;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
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