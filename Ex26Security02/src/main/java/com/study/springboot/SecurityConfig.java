package com.study.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity  //웹보안 활성화를 위한 Annotation
public class SecurityConfig {
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        //기본적으로 csrf(사이트간 요청 위조)가 활성화 되어 있다.
        //csrf 보안을 비활성화 한다.
        //.csrf( (auth) -> auth.disable() )

        //csrf 보안을 활성화 한다.
        //csrf 보안을 쿠키방식으로 지정한다.
        //CsrfTokenRepository 인터페이스는
        // HttpSessionCsrfTokenRepository,CookieCsrfTokenRepository
        //2개가 있다.
        //기본적으로 스프링 시큐리티는 HttpSessionCsrfTokenRepository로 CSRF 토큰을 HttpSession에 저장한다.
        //하지만 커스텀 CsrfTokenRepository를 설정하고 싶을 때도 있을 것이다.
        //예를 들어 자바스크립트 기반 어플리케이션을 지원하려면 쿠키에 CsrfToken을 저장해야 한다.
        .csrf((auth)->auth.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))

        //HTTP요청에 대한 보안설정을 시작한다.
        .authorizeHttpRequests( (auth) -> auth
            //루트 밑의 모든 경로에 대한 모든 요청을 허가한다.
            .requestMatchers( new AntPathRequestMatcher("/**") ).permitAll()
            .requestMatchers("/admin").hasRole("ADMIN")
            .requestMatchers("/my/**").hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated() //그외 어떤 요청에도 인증을 한다.
        )

        //로그인 인증에 대한 설정을 시작
        .formLogin((formLogin) -> formLogin
            //로그인 페이지를 /loginForm URI로 하겠다.
            .loginPage("/loginForm")
            //로그인 액션 URI
            .loginProcessingUrl("/loginAction")
            //로그인 성공시 넘어가 URI를 지정한다.
            .defaultSuccessUrl("/")
            //인증성공 후 별도의 처리가 필요한 경우 커스텀 핸들러를 생성/등록한다.
            .successHandler(((request, response, authentication) -> {
              System.out.println("로그인 성공했습니다.");
              response.sendRedirect("/");
            }))
            //실패시 에러페이지
            .failureUrl("/loginForm?error")
            //로그인 페이지를 모든 사용자에게 허용한다.
            .permitAll())
        //로그아웃 처리
        .logout((auth) -> auth
            .logoutRequestMatcher(new AntPathRequestMatcher("/logoutAction"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true) //세션 객체을 해제(내부 저장 데이터도 소멸)
            .deleteCookies("JSESSIONID") //reponse 헤더에 Set Cookie에 ""을 넣어준다.
        )

    ;
    return http.build();
  }
}