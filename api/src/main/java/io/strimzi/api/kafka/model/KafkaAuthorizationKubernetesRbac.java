/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.strimzi.crdgenerator.annotations.Description;
import io.strimzi.crdgenerator.annotations.Example;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Configures the broker authorization
 */
@Buildable(
        editableEnabled = false,
        generateBuilderPackage = false,
        builderPackage = "io.fabric8.kubernetes.api.builder"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"type", "superUsers"})
@EqualsAndHashCode
public class KafkaAuthorizationKubernetesRbac extends KafkaAuthorization {
    private static final long serialVersionUID = 1L;

    public static final String TYPE_KUBERNETES_RBAC = "kubernetes-rbac";

    private List<String> superUsers;

    @Description("Must be `" + TYPE_KUBERNETES_RBAC + "`")
    @Override
    public String getType() {
        return TYPE_KUBERNETES_RBAC;
    }

    @Description("List of super users. Should contain list of user principals which should get unlimited access rights.")
    @Example("- CN=my-user\n" +
             "- system:serviceaccount:mynamespace:kafka-admin")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<String> getSuperUsers() {
        return superUsers;
    }

    public void setSuperUsers(List<String> superUsers) {
        this.superUsers = superUsers;
    }
}
