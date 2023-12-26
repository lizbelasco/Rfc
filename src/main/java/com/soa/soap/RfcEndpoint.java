/**
 * 
 */
package com.soa.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.Gson;
import com.soa.LizbethResponse;
import com.soa.LizbethRequest;
import com.soa.business.RfcBusiness;

/**
 * Clase que publica un servicio web tipo SOAP. Capa Boundary
 */
@Endpoint
public class RfcEndpoint {
    /** Objeto inyectado de la capa de negocio. */
    @Autowired
    private RfcBusiness business;

    /** Targetnamespace. */
    private static final String NAMESPACE_URI = "http://soa.com";

    /**
     * Operación SOAP expuesta en http.
     * @param request Objeto con datos de entrada. (Capa de Modelo).
     * @return objeto con datos de salida (Capa de modelo)
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LizbethRequest")
    @ResponsePayload
    public LizbethResponse rfcOperation(
            @RequestPayload LizbethRequest request) {
        LizbethResponse out = new LizbethResponse();
        
        String rfc = business.rfc(request.getApellidoPaterno().substring(0,2) + 
                request.getApellidoMaterno().substring(0,1) + 
                request.getNombre().substring(0,1) + 
                request.getFechaNacimiento().substring(8,10) +
                request.getFechaNacimiento().substring(3,5) + 
                request.getFechaNacimiento().substring(0,2));
        
        out.setRfc(rfc);
        
        Gson gson = new Gson();
        
        return out;
    }
}