package etf.si.projekat.data_vision;

import java.util.Date;
enum vrsta {Line, Bar};
public class Graf {
	vrsta vrstaGrafa;
	Date intervalOd;
	Date intervalDo;
	int brojPodataka;
	String vrstaSenzora;
	public vrsta getVrstaGrafa() {
		return vrstaGrafa;
	}
	public void setVrstaGrafa(vrsta vrstaGrafa) {
		this.vrstaGrafa = vrstaGrafa;
	}
	public String getOpis() {
		return vrstaSenzora;
	}
	
	public void setOpis(String opis){
		this.vrstaSenzora=opis;
	}
	

}
