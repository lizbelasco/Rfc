/**
 * 
 */
package com.soa.business;

import org.springframework.stereotype.Component;

/**
 *  Capa de negocio de concatenación de Strings.
 */
@Component
public class RfcBusiness {

    public String rfc(String s1) {
        return String.format(s1);
//        StringBuilder sb = new StringBuilder();
//        sb.append(s1);
//        sb.append(s2);
//        StringBuffer sbf = new StringBuffer();
//        sbf.append(s1);
//        sbf.append(s2);
//        return s1 + s2;
    }
}
