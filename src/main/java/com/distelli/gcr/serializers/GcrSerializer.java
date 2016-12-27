/*
  $Id: $
  @file GcrSerializer.java
  @brief Contains the GcrSerializer.java class

  @author Rahul Singh [rsingh]
  Copyright (c) 2013, Distelli Inc., All Rights Reserved.
*/
package com.distelli.gcr.serializers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GcrSerializer
{
    private static final Logger log = LoggerFactory.getLogger(GcrSerializer.class);
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public GcrSerializer()
    {

    }

    protected static <T> T convertValue(JsonNode node, Class<T> clazz)
    {
        try {
            return OBJECT_MAPPER.convertValue(node, clazz);
        } catch(IllegalArgumentException iae) {
            log.error("Invalid node: "+node+" is not of type: "+clazz+": "+iae.getMessage());
        }
        return null;
    }
}
