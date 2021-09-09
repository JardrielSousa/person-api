package com.br.digitalinnovationone.personapi.utils;

import com.br.digitalinnovationone.personapi.entities.Phone;
import com.br.digitalinnovationone.personapi.enums.PhoneType;

public class PhoneUtils {
	 private static final String PHONE_NUMBER = "1199999-9999";
	    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
	    private static final long PHONE_ID = 1L;

	    public static Phone createFakeDTO() {
	        return Phone.builder()
	                .number(PHONE_NUMBER)
	                .type(PHONE_TYPE)
	                .build();
	    }

	    public static Phone createFakeEntity() {
	        return Phone.builder()
	                .id(PHONE_ID)
	                .number(PHONE_NUMBER)
	                .type(PHONE_TYPE)
	                .build();
	    }
}
