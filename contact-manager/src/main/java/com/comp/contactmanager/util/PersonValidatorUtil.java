package com.comp.contactmanager.util;

import com.google.i18n.phonenumbers.PhoneNumberUtil;

import java.util.List;


public final class PersonValidatorUtil {

    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    private static final String REGION_DIALING_FROM = "HU";

    public static boolean isValidPhoneFormat(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }

        return phoneNumberUtil.isPossibleNumber(phoneNumber, REGION_DIALING_FROM);
    }

    public static boolean isInCompanies(String company, List<String> companies) {
        return companies.contains(company);
    }

}
