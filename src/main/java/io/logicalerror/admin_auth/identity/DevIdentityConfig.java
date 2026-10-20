package io.logicalerror.admin_auth.identity;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Profile({"dev", "test"})
@EnableConfigurationProperties(DevIdentityProperties.class)
public class DevIdentityConfig {

    @Bean
    UserDetailsService userDetailsService(
            DevIdentityProperties properties
    ) {
        UserDetails admin = User.builder()
                .username(properties.username())
                .password(passwordEncoder().encode(properties.password()))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
