package com.creditcarbon.creditcarbonbackend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Category(String mainCategory, String subCategory, String sector) { }
