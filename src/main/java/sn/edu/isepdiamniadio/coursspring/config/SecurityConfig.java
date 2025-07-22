package sn.edu.isepdiamniadio.coursspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET,"/api/v1/ecole").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/ecole/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/home/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/home/nom/**/age/**").hasRole("ADMIN")



                        .anyRequest().authenticated()
                )
                .logout(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())

                .formLogin(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("passer")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("adminpassword")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails, admin);
    }
}
