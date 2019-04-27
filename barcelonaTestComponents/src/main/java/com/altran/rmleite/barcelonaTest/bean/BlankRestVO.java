package com.altran.rmleite.barcelonaTest.bean;

import org.springframework.stereotype.Component;

@Component("blankRestVO")
public class BlankRestVO {
	
		private String str;		
		private String nmeUser;

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}	
		
		public String getNmeUser() {
			return nmeUser;
		}

		public void setNmeUser(String nmeUser) {
			this.nmeUser = nmeUser;
		}
		
}