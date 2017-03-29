package edu.eci.cosw.cheapestPrice;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.repositories.CuentaRepository;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian David Devia Serna on 2/5/17.
 */
@SpringBootApplication
@EnableJpaRepositories("edu.eci.cosw.cheapestPrice.repositories")
@EntityScan("edu.eci.cosw.cheapestPrice.entities")
public class CheapestPriceApplication {



    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        CuentaRepository cr;


        @Override
        protected void configure(AuthenticationManagerBuilder builder) throws Exception {
            //builder.inMemoryAuthentication().withUser("admin@cheapestprice.com").password("password").roles("USER");
            builder.authenticationProvider(new AuthenticationProvider(){

                @Override
                public Authentication authenticate(Authentication auth) throws AuthenticationException {
                    System.out.println(auth.getDetails()+" user  "+auth.getName()+" pas "+auth.getCredentials().toString()+"  otros "+ auth.getAuthorities());

                        Cuenta cuenta = cr.Login(auth.getName(),auth.getCredentials().toString());
                        System.out.println("CUENTA: "+cuenta);
                    if (cuenta != null) {
                        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                        authorities.add(new SimpleGrantedAuthority(cuenta.getRol()));
                        return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials().toString(), authorities);

                    }
                    return null;
                }

                @Override
                public boolean supports(Class<?> authentication) {
                    return authentication.equals(UsernamePasswordAuthenticationToken.class);
                }
            });
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/app/**","/logout","/login","/vistaPrincipal", "/usuarios/**","/tiendas/**", "/assets/**").permitAll()
                    .anyRequest().authenticated().and()
                    .logout().logoutSuccessUrl("/")
                    .and().csrf().disable();
                    //.csrfTokenRepository(csrfTokenRepository()).and()
                    //.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class).formLogin()
                    //.loginPage("/app/index.html");
        }

        private Filter csrfHeaderFilter() {
            return new OncePerRequestFilter() {
                @Override
                protected void doFilterInternal(HttpServletRequest request,
                                                HttpServletResponse response, FilterChain filterChain)
                        throws ServletException, IOException {
                    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                            .getName());
                    if (csrf != null) {
                        Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                        String token = csrf.getToken();
                        if (cookie == null || token != null
                                && !token.equals(cookie.getValue())) {
                            cookie = new Cookie("XSRF-TOKEN", token);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                        }
                    }
                    filterChain.doFilter(request, response);
                }
            };
        }

        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }
    }
    public static void main(String[] args) {  SpringApplication.run(CheapestPriceApplication.class, args);}

}
