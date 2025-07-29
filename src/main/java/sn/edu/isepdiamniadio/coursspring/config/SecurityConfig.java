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
//pour savoir que cette classe est une configuration
@Configuration
public class SecurityConfig {
    //bean nous permet de créer des objets qui sont utilisés par le systeme de securité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET,"/api/v1/ecole").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/v1/ecole/**").permitAll()

                        //seulement ce sont les admins qui peuvent acceder aux pages de ces urls
                        .requestMatchers(HttpMethod.GET,"/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/home/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/home/nom/**/age/**").hasRole("ADMIN")


                        .requestMatchers(HttpMethod.GET,"/ecoles/adresse").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/ecoles/specification").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/professeurs/memeAdresse").hasRole("ADMIN")
                        //toute autre url sera l'objet d'une authentification
                        .anyRequest().authenticated()
                )
                .logout(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())

                .formLogin(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
// le user
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("passer")
                .roles("USER")
                .build();
//mon admin
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("adminpassword")
                .roles("ADMIN")
                .build();
        //professeur
        UserDetails professeur = User.withDefaultPasswordEncoder()
                .username("professeur")
                .password("professeur")
                .roles("PROFESSEUR")
                .build();

        return new InMemoryUserDetailsManager(userDetails, admin,professeur);
    }
}
