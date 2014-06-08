package etf.si.projekat.data_vision;

import java.sql.Time;

public class Potrosnja {
	Time intervalOd;
	Time intervalDo;
	String tipSenzora;
	Double snagaUredjaja;
	public Time getIntervalOd() {
		return intervalOd;
	}
	public void setIntervalOd(Time intervalOd) {
		this.intervalOd = intervalOd;
	}
	public Time getIntervalDo() {
		return intervalDo;
	}
	public void setIntervalDo(Time intervalDo) {
		this.intervalDo = intervalDo;
	}
	public String getTipSenzora() {
		return tipSenzora;
	}
	public void setTipSenzora(String tipSenzora) {
		this.tipSenzora = tipSenzora;
	}
	public Double getSnagaUredjaja() {
		return snagaUredjaja;
	}
	public void setSnagaUredjaja(Double snagaUredjaja) {
		this.snagaUredjaja = snagaUredjaja;
	}
	
	public void racunajPotrosnju(){}

}
