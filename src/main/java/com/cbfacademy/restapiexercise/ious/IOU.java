package com.cbfacademy.restapiexercise;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ious")
public class IOU {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String borrower;
  private String lender;
  private BigDecimal amount;
  private Instant dateTime;

  public IOU() {
    this(null, null, BigDecimal.ZERO, Instant.now());
  }
  
  public IOU(String borrower, String lender, BigDecimal amount, Instant dateTime) {
    this.borrower = borrower;
    this.lender = lender;
    this.amount = amount;
    this.dateTime = dateTime;
  }

  // Define a default UUID
  private static final UUID DEFAULT_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

  // Getters and setters
  public UUID getId() {
    return this.id != null ? id : DEFAULT_UUID;
  }
  
  public String getBorrower() {
    return this.borrower;
  }

  public void setBorrower(String borrower) {
    this.borrower = borrower;
  }

  public String getLender() {
    return this.lender;
  }

  public void setLender(String lender) {
    this.lender = lender;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Instant getDateTime() {
    return this.dateTime;
  }

  public void setDateTime(Instant dateTime) {
    this.dateTime = dateTime;
  }
}
