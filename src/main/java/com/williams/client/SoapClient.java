package com.williams.client;

import com.williams.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {


    public AddResponse addMethod(int a, int b){
        Add request = new Add();
        request.setIntA(a);
        request.setIntB(b);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");

        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,soapActionCallback);

        return response;
    }

    public SubtractResponse substractMethod(int a, int b){
        Subtract request = new Subtract();
        request.setIntA(a);
        request.setIntB(b);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Subtract");

        SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,soapActionCallback);

        return response;
    }

    public DivideResponse divideMethod(int a, int b){
        Divide request = new Divide();
        request.setIntA(a);
        request.setIntB(b);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Divide");

        DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,soapActionCallback);

        return response;
    }

    public MultiplyResponse multiplyMethod(int a, int b){
        Multiply request = new Multiply();
        request.setIntA(a);
        request.setIntB(b);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Multiply");

        MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",request,soapActionCallback);

        return response;
    }
}
