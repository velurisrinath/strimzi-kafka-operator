/*
 * Copyright Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model.listener;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

public enum LoadBalancerAddressType {
    IP,
    HOSTNAME;

    @JsonCreator
    public static LoadBalancerAddressType forValue(String value) {
        switch (value.toLowerCase(Locale.ENGLISH)) {
            case "ip":
                return IP;
            case "hostname":
                return HOSTNAME;
            default:
                return null;
        }
    }

    @JsonValue
    public String toValue() {
        switch (this) {
            case IP:
                return "IP";
            case HOSTNAME:
                return "Hostname";
            default:
                return null;
        }
    }
}
