package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clan database table.
 * 
 */
@Entity
@NamedQuery(name="Clan.findAll", query="SELECT c FROM Clan c")
public class Clan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idclan;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="clan")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Trening
	@OneToMany(mappedBy="clan")
	private List<Trening> trenings;

	public Clan() {
	}

	public int getIdclan() {
		return this.idclan;
	}

	public void setIdclan(int idclan) {
		this.idclan = idclan;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setClan(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setClan(null);

		return komentar;
	}

	public List<Trening> getTrenings() {
		return this.trenings;
	}

	public void setTrenings(List<Trening> trenings) {
		this.trenings = trenings;
	}

	public Trening addTrening(Trening trening) {
		getTrenings().add(trening);
		trening.setClan(this);

		return trening;
	}

	public Trening removeTrening(Trening trening) {
		getTrenings().remove(trening);
		trening.setClan(null);

		return trening;
	}

}