package io.logicalerror.admin_auth.identity;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "blue.auth.dev-identity")
public record DevIdentityProperties(

        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        String subject
) {
}
