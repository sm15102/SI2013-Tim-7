package etf.si.projekat.data_vision;

import java.sql.Time;
import java.util.Date;

public class Senzor {
	Date datumMjerenja;
	Time vrijemeMjerenja;
	Double izmjerenaVrijednost;
	String tipSenzora;
	
	public Date getDatumMjerenja() {
		return datumMjerenja;
	}
	public void setDatumMjerenja(Date datumMjerenja) {
		this.datumMjerenja = datumMjerenja;
	}
	public Time getVrijemeMjerenja() {
		return vrijemeMjerenja;
	}
	public void setVrijemeMjerenja(Time vrijemeMjerenja) {
		this.vrijemeMjerenja = vrijemeMjerenja;
	}
	public Double getIzmjerenaVrijednost() {
		return izmjerenaVrijednost;
	}
	public void setIzmjerenaVrijednost(Double izmjerenaVrijednost) {
		this.izmjerenaVrijednost = izmjerenaVrijednost;
	}
	public String getTipSenzora() {
		return tipSenzora;
	}
	public void setTipSenzora(String tipSenzora) {
		this.tipSenzora = tipSenzora;
	}
	

}
