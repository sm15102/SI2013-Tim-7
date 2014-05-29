package etf.si.projekat.data_vision;


import java.util.Date;
import java.util.List;

public class Graf {
	String vrstaGrafa;
	Date intervalOd;
	Date intervalDo;
	int brojPodataka;
	List<String> tipSenzora;

	public Graf()
	{}
	
	public Graf(String vrsta, Date od, Date doo, int broj, List<String> tip)
	{
		vrstaGrafa=vrsta;
		intervalOd=od;
		intervalDo=doo;
		brojPodataka=broj;
		tipSenzora=tip;
		
	}

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

	public List<String> getTipSenzora() {
		return tipSenzora;
	}

	public void setTipSenzora(List<String> tipSenzora) {
		this.tipSenzora = tipSenzora;
	}

}
