package com.williams.controller;

import com.williams.client.SoapClient;
import com.williams.entity.Request;
import com.williams.wsdl.AddResponse;
import com.williams.wsdl.DivideResponse;
import com.williams.wsdl.MultiplyResponse;
import com.williams.wsdl.SubtractResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private SoapClient soapClient;

    @PostMapping("/sumar")
    public ResponseEntity<?> add(@RequestBody Request request){
        AddResponse addResponse = soapClient.addMethod(request.getNumero1(), request.getNumero2());
        Map<String,Integer> response = new HashMap<>();
        response.put("response",addResponse.getAddResult());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/restar")
    public ResponseEntity<?> substract(@RequestBody Request request){
        SubtractResponse subtractResponse = soapClient.substractMethod(request.getNumero1(), request.getNumero2());
        Map<String,Integer> response = new HashMap<>();
        response.put("response",subtractResponse.getSubtractResult());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/dividir")
    public ResponseEntity<?> divide(@RequestBody Request request){
        DivideResponse divideResponse = soapClient.divideMethod(request.getNumero1(), request.getNumero2());
        Map<String,Integer> response = new HashMap<>();
        response.put("response",divideResponse.getDivideResult());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<?> multiply(@RequestBody Request request){
        MultiplyResponse multiplyResponse = soapClient.multiplyMethod(request.getNumero1(), request.getNumero2());
        Map<String,Integer> response = new HashMap<>();
        response.put("response",multiplyResponse.getMultiplyResult());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
