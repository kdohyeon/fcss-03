package fast.campus.fcss03.config;

import fast.campus.fcss03.user.InMemoryUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails danny = User.withUsername("danny.kim")
                .password("12345")
                .build();
        UserDetails steve = User.withUsername("steve.kim")
                .password("23456")
                .build();
        UserDetails harris = User.withUsername("harris.kim")
                .password("34567")
                .build();
        List<UserDetails> users = List.of(danny, steve, harris);
        return new InMemoryUserDetailsService(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
