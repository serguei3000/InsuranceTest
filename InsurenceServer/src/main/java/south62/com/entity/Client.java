package south62.com.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "CLIENTS")
@Table(name = "clients")
public class Client implements Serializable{
	private static final long serialVersionUID = -6966934116557219192L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID", unique=true, nullable=false)
	protected Long id;
	
	@Column(name="FIRST_NAME")
	@NotNull
	@Size(min=2, max=100)
	protected String firstName;
		
	@Column(name="SECOND_NAME")
	@NotNull
	@Size(min=2, max=100)
	protected String secondName;
	
	@Column(name="LAST_NAME")
	@NotNull
	@Size(min=2, max=100)
	protected String lastName;
	
	@Column(name = "BIRTH_DATE", nullable = false)
	@NotNull
	@Past
	protected LocalDate birthDate;
	
	@Column(name="PASSPORT_SERIA", length = 4, nullable = false)
	@NotNull
	@Size(min=4, max=4)
	@Pattern(regexp = "^[0-9]{4}$")
	protected String passSeria;
	
	@Column(name="PASSPORT_NUMBER", length = 6, nullable = false)
	@NotNull
	@Size(min=6, max=6)
	@Pattern(regexp = "^[0-9]{6}$")
	protected String passNumber;
	
    public Client() {};
	
	public Client(@NotNull @Size(min = 2, max = 50) String firstName,
			@NotNull @Size(min = 2, max = 50) String secondName, @NotNull @Size(min = 2, max = 50) String lastName,
			@NotNull LocalDate birthDate, @NotNull @Size(min = 4, max = 4) @Pattern(regexp = "^[0-9]{4}$") String passSeria,
			@NotNull @Size(min = 6, max = 6) @Pattern(regexp = "^[0-9]{6}$") String passNumber) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.passSeria = passSeria;
		this.passNumber = passNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassSeria() {
		return passSeria;
	}

	public void setPassSeria(String passSeria) {
		this.passSeria = passSeria;
	}

	public String getPassNumber() {
		return passNumber;
	}

	public void setPassNumber(String passNumber) {
		this.passNumber = passNumber;
	}

	public Long getId() {
		return id;
	}
}
