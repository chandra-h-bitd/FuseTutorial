package org.cx;

import java.util.Map;

import javax.xml.soap.SOAPException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.service.model.MessageInfo;

import com.input.ProfileRequest;
import com.input.ProfileResponse;

public class ActivityBean implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ProfileRequest ProfileRequest = new ProfileRequest();
        ProfileRequest.setProfileId(1288);
        exchange.getIn().setBody(ProfileRequest);
    }

    public void processOutput(Exchange exchange) throws SOAPException {
        MessageContentsList message = (MessageContentsList) exchange.getIn().getBody();
        ProfileResponse object  = (ProfileResponse)message.get(0);
        System.out.println(object.getProfileDetails());


    }

}