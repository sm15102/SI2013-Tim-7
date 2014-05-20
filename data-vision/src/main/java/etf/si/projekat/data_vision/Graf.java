package etf.si.projekat.data_vision;


import java.util.Date;

public class Graf {
	String vrstaGrafa;
	
	
	public String getVrstaGrafa() {
		return vrstaGrafa;
	}
	public void setVrstaGrafa(String vrstaGrafa) {
		this.vrstaGrafa = vrstaGrafa;
	}
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
	public int getBrojPodataka() {
		return brojPodataka;
	}
	public void setBrojPodataka(int brojPodataka) {
		this.brojPodataka = brojPodataka;
	}
	public String getTipSenzora() {
		return tipSenzora;
	}
	public void setTipSenzora(String tipSenzora) {
		this.tipSenzora = tipSenzora;
	}
	Date intervalOd;
	Date intervalDo;
	int brojPodataka;
	String tipSenzora;
	
	

}
