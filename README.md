# Spring Security - Demo

O presente trabalho, fez parte de um projeto apresentado ao Curso de Especialização MBA em Engenharia de Software da Universidade Tecnológica Federal do Paraná - UTFPR - Campus Cornélio Procópio - como requisito parcial para aprovação na disciplina Ambiente de Ensino e Aprendizagem a Distância, em que consiste na elaboração de um sistema de empréstimos/devolução de livros de uma biblioteca desenvolvido de modo colaborativo.

## Testar a Aplicação

1 - Ao iniciar a aplicação e acessar http://localhost:8080/, você verá a página pública.
<br /> <br />
2 - Ao acessar http://localhost:8080/user, o Spring Security solicitará autenticação. Use o usuário `user` e a senha `password`.
<br /> <br />
3 - Ao acessar http://localhost:8080/admin, o Spring Security solicitará autenticação. Use o usuário `admin` e a senha `adminpassword`.

## Explicação do Código
- **configure(AuthenticationManagerBuilder auth):** Configura autenticação em memória com dois usuários (user e admin).
- **configure(HttpSecurity http):** Define as permissões para diferentes rotas. Somente administradores podem acessar /admin, apenas usuários podem acessar /user, e a rota raiz / é pública.
- **BCryptPasswordEncoder:** Garante que as senhas sejam armazenadas de forma segura.

Este exemplo demonstra uma configuração básica de autenticação e autorização. Em projetos reais, é recomendável usar bancos de dados para armazenar credenciais e tokens JWT para autenticação em APIs.
