package com.NotificationSystem.webApi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.CloseableThreadContext;

import java.io.DataInput;
import java.io.IOException;

public class InstanceDeserializer extends JsonDeserializer<SendInfo> {
    public Boolean hasEmail(String str)
    {
        if(str.contains("email"))
        {
            return true;
        }
        return false;
    }
    public Boolean hasPhone(String str)
    {
        if(str.contains("phoneNum"))
        {
            return true;
        }
        return false;
    }
    @Override
    public SendInfo deserialize(JsonParser jp,  DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends SendInfo> instanceClass = null;
        if(hasEmail(root.toString())){
            instanceClass = Email.class;
        }
        else if(hasPhone(root.toString()))
        {
            instanceClass = SMS.class;
        }

        if (instanceClass == null){
            return null;
        }
        return mapper.convertValue( root, instanceClass );
    }
}