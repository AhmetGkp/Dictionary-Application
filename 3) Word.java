
public class Kelime {
	
	private String norvecceKelime;
	private String ingilizceKelime;
	private String turkceKelime;
	private int durum;
	
	// 1 durumu = ogrenmedin
	// 2 durumu = ogrendin
	
	public Kelime() {
		
	}
	public Kelime(String norvecceKelime, String ingilizceKelime, String turkceKelime, int durum) {
		this.norvecceKelime = norvecceKelime;
		this.ingilizceKelime = ingilizceKelime;
		this.turkceKelime = turkceKelime;
		this.durum = durum;
	}

	
	public String getNorvecceKelime() {
		return norvecceKelime;
	}
	public void setNorvecceKelime(String norvecceKelime) {
		this.norvecceKelime = norvecceKelime;
	}

	
	public String getIngilizceKelime() {
		return ingilizceKelime;
	}
	public void setIngilizceKelime(String ingilizceKelime) {
		this.ingilizceKelime = ingilizceKelime;
	}


	public String getTurkceKelime() {
		return turkceKelime;
	}
	public void setTurkceKelime(String turkceKelime) {
		this.turkceKelime = turkceKelime;
	}
	
	
	public int getDurum() {
		return durum;
	}
	public void setDurum(int durum) {
		this.durum = durum;
	}

}
