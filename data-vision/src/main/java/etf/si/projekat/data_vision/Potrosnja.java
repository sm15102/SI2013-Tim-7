package etf.si.projekat.data_vision;

import java.util.Date;

public class Potrosnja {
	Date intervalOd;
	Date intervalDo;
	String tipSenzora;
	double snagaUredjaja;
	
	public Date getIntervalOd() {
		return intervalOd;
	}
	public void setIntervalOd(Date intervalOd) {
		this.intervalOd = intervalOd;
	}
	public Date getIntervalDo() {
		return intervalDo;
	}
	public void setIntervalDo(Date intervalDo) {
		this.intervalDo = intervalDo;
	}
	public String getTipSenzora() {
		return tipSenzora;
	}
	public void setTipSenzora(String tipSenzora) {
		this.tipSenzora = tipSenzora;
	}
	public double getSnagaUredjaja() {
		return snagaUredjaja;
	}
	public void setSnagaUredjaja(double snagaUredjaja) {
		this.snagaUredjaja = snagaUredjaja;
	}
	public double RacunajPotrosnju(){
		int days=(int)( (intervalDo.getTime() - intervalOd.getTime()) / (1000 * 60 * 60 * 24));
		return days*24*this.getSnagaUredjaja();
	}

}
