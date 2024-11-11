package br.com.discover.academia.hybris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configuração de autenticação em memória
        auth.inMemoryAuthentication()
                .withUser("user")       // Usuário
                .password(passwordEncoder().encode("password")) // Senha (encodada)
                .roles("USER")          // Papel do usuário
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("adminpassword"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuração de autorização
        http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN") // Apenas ADMIN acessa /admin
                .antMatchers("/user/**").hasRole("USER")   // Apenas USER acessa /user
                .antMatchers("/").permitAll()              // Qualquer um acessa a raiz
                .and()
                .formLogin()  // Habilita login via formulário
                .permitAll()
                .and()
                .logout()     // Habilita logout
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}