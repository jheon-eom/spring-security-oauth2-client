package dev.secu.SSO.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {
    @Value("${auth.client.id}")
    private String clientId;
    @Value("${auth.client.secret}")
    private String clientSecret;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .oauth2Login(oauth -> oauth.clientRegistrationRepository(
                        new InMemoryClientRegistrationRepository(clientRegistration())))

                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated())

                .build();
    }

    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();
    }
}
