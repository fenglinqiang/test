package com.jk.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable {

	private static final long serialVersionUID = -6670640310551713010L;
	
	    private Integer taid;

	    private String taname;

	    private Integer taage;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date tabir;

	    //修改时间
  		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
  	    private String showDate;
  	    

  	    
  	    public String getShowDate() {
  			return tabir!=null?sim.format(tabir):"";
  		}
  		
  		public void setShowDate(String showDate) {
  			this.showDate = showDate;
  		}
		public Integer getTaid() {
			return taid;
		}

		public String getTaname() {
			return taname;
		}

		public Integer getTaage() {
			return taage;
		}

		public Date getTabir() {
			return tabir;
		}

		public void setTaid(Integer taid) {
			this.taid = taid;
		}

		public void setTaname(String taname) {
			this.taname = taname;
		}

		public void setTaage(Integer taage) {
			this.taage = taage;
		}

		public void setTabir(Date tabir) {
			this.tabir = tabir;
		}

}
