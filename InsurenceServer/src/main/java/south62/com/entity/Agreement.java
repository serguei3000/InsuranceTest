package south62.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import south62.com.validation.AgreementDatesCorrectRange;
import south62.com.validation.DateAfterCurrent;

@Entity
//@Table(name = "AGREEMENTS")
@Table(name = "agreements")
@AgreementDatesCorrectRange
public class Agreement implements Serializable {
	private static final long serialVersionUID = -6966934116557219190L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AGREEMENT_ID", unique=true, nullable=false)
	protected Long id;
	
	@Column(name="AGREEMENT_NUM", unique=true, nullable=false)
	@NotNull
	@Size(min=6, max=6)
	protected String number;
	
	@Column(name = "AGREEMENT_DATE", nullable = false)
	protected LocalDate agreementDate;
	
	@DateAfterCurrent
	@Column(name = "BEG_DATE", nullable = false)
	protected LocalDate begDate;
	
	@Column(name = "END_DATE", nullable = false)
	protected LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "ESTATE_ID", nullable = false)
	protected Estate estate;
	
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID", nullable=false)
	protected Client client;
	
	@Column(name="AMOUNT")
	@NotNull
	protected BigDecimal amount;
	
	@Column(name="BONUS")
	protected BigDecimal bonus;	 
	
	
	public Agreement() {};

	@AgreementDatesCorrectRange
	public Agreement(@NotNull String number, LocalDate agreementDate, @DateAfterCurrent LocalDate begDate, LocalDate endDate, Estate estate, Client client,
			             @NotNull BigDecimal amount) {
		super();
		this.number = number;
		this.agreementDate = agreementDate;
		this.begDate = begDate;
		this.endDate = endDate;
		this.estate = estate;
		this.client = client;
		this.amount = amount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	public LocalDate getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(LocalDate agreementDate) {
		this.agreementDate = agreementDate;
	}

	public LocalDate getBegDate() {
		return begDate;
	}

	public void setBegDate(LocalDate begDate) {
		this.begDate = begDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Estate getEstate() {
		return estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	public Long getId() {
		return id;
	}
	
}
