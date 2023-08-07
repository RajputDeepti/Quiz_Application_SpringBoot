package com.Spring.Quiz_Application.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Bean
    @Autowired
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->configurer
                        .requestMatchers("/","/home","/register","/registration","/reset-password",
                                "/forgot-password",
                                "/verify","/verificationSuccess","/verificationError","/verification?verification=true").permitAll()
                        .requestMatchers("/host/**").hasRole("HOST")
                        .requestMatchers("/candidate/**").hasRole("CANDIDATE")
                        .anyRequest().authenticated())
                        .formLogin(form->form.loginPage("/signin")
                                .loginProcessingUrl("/do-login")
//                                .failureUrl("/authenticationFailed")
                                .defaultSuccessUrl("/").permitAll())
                .logout(logout->logout.permitAll())
                .exceptionHandling(e->e.accessDeniedHandler(accessDeniedHandler()));// Set the custom AccessDeniedHandler
        return http.build();
    }
<<<<<<< HEAD

    private AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            // Handle the access denied scenario here
            response.sendRedirect("/access-denied");
        };// Set the custom access denied page URL


    }

        }
=======
}
>>>>>>> 006a8b5436a64585d5489f7cd2b61227fd2e6bde
