package com.williams.client;

import com.williams.wsdl.Add;
import com.williams.wsdl.AddResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {


    public AddResponse addMethod(int a, int b){
        Add add = new Add();
        add.setIntA(a);
        add.setIntB(b);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");

        AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",add,soapActionCallback);

        return response;
    }
}
