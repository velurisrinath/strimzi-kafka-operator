/*
 * Copyright Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model.listener;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.strimzi.crdgenerator.annotations.Description;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

/**
 * Configures External node port listeners
 */

@JsonPropertyOrder({"brokerCertChainAndKey", "addressType"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Buildable(
    editableEnabled = false,
    generateBuilderPackage = false,
    builderPackage = "io.fabric8.kubernetes.api.builder"
)
@EqualsAndHashCode(callSuper = true)
public class LoadBalancerListenerConfiguration extends KafkaListenerExternalConfiguration {
    private static final long serialVersionUID = 1L;

    private LoadBalancerAddressType preferredAddressType;

    @Description("Defines which address type should be used as the load balancer address. " +
            "Available types are: `IP` and `Hostname`. " +
            "By default, the addresses will be used in the following order (the first one found will be used):\n" +
            "* `Hostname`\n" +
            "* `IP`\n" +
            "\n" +
            "This field can be used to select the address type which will be used as the preferred type and checked first. " +
            "In case no address will be found for this address type, the other types will be used in the default order.")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public LoadBalancerAddressType getPreferredAddressType() {
        return preferredAddressType;
    }

    public void setPreferredAddressType(LoadBalancerAddressType preferredAddressType) {
        this.preferredAddressType = preferredAddressType;
    }
}
