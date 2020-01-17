package south62.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import south62.com.validation.BuildYearNotAfterCurrent;

@Entity
//@Table(name = "ESTATES")
@Table(name = "estates")
public class Estate implements Serializable {
	private static final long serialVersionUID = -6966934116557219193L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTATE_ID", unique=true, nullable=false)
	protected Long id;
	
	@Column(name="ESTATE_TYPE")
	@NotNull
	protected String type;
	
	@Column(name="BUILT_YEAR")
	@NotNull
	@BuildYearNotAfterCurrent
	protected Integer year;
	
	@Column(name="ESTATE_SQUARE")
	@NotNull
	protected BigDecimal square;
	
	@Embedded
	@NotNull
	protected Address address;
	
	@Column(name="REMARKS")
	protected String remarks;
	
	public Estate( ) {};

	public Estate(@NotNull String type, @NotNull @BuildYearNotAfterCurrent Integer year, @NotNull BigDecimal square, @NotNull Address address,
			String remarks) {
		super();
		this.type = type;
		this.year = year;
		this.square = square;
		this.address = address;
		this.remarks = remarks;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getSquare() {
		return square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
