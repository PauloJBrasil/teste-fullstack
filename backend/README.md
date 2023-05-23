# Projeto Spring Boot com Banco de Dados H2

Este é um projeto Spring Boot que utiliza o banco de dados H2. Siga as etapas abaixo para configurar e executar o projeto em sua máquina local.

## Pré-requisitos

Antes de começar, verifique se você possui os seguintes itens instalados:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/#java20) (versão 20)
- [Maven](https://maven.apache.org/) (versão 3.6.0 ou posterior)

## Primeiros Passos

1. Clone este repositório para sua máquina local:

   ```bash
   git clone https://github.com/PauloJBrasil/teste-fullstack.git
   ```

2. Navegue até o diretório `backend`:

   ```bash
   cd backend
   ```

3. Inicie o servidor de desenvolvimento:

   ```bash
   mvn spring-boot:run
   ```

4. Acesse o servidor em [http://localhost:8080](http://localhost:8080).

```
teste-fullstack
├─ backend
│  ├─ .mvn
│  │  └─ wrapper
│  │     ├─ maven-wrapper.jar
│  │     └─ maven-wrapper.properties
│  ├─ backend.iml
│  ├─ mvnw
│  ├─ mvnw.cmd
│  ├─ pom.xml
│  ├─ README.md
│  ├─ src
│  │  ├─ main
│  │  │  ├─ java
│  │  │  │  └─ br
│  │  │  │     └─ com
│  │  │  │        └─ paulo
│  │  │  │           └─ teixeira
│  │  │  │              └─ unimed
│  │  │  │                 ├─ config
│  │  │  │                 │  ├─ JWTAuthFilter.java
│  │  │  │                 │  ├─ PasswordConfig.java
│  │  │  │                 │  ├─ SecurityConfig.java
│  │  │  │                 │  ├─ UserAuthenticationEntryPoint.java
│  │  │  │                 │  ├─ UserAuthenticationProvider.java
│  │  │  │                 │  ├─ UsernamePasswordAuthFilter.java
│  │  │  │                 │  └─ WebConfig.java
│  │  │  │                 ├─ controller
│  │  │  │                 │  ├─ BeneficiarioController.java
│  │  │  │                 │  ├─ PlanoController.java
│  │  │  │                 │  └─ UsuarioController.java
│  │  │  │                 ├─ dto
│  │  │  │                 │  ├─ BeneficiarioDto.java
│  │  │  │                 │  ├─ CredentialsDto.java
│  │  │  │                 │  ├─ ErrorDto.java
│  │  │  │                 │  ├─ UserDto.java
│  │  │  │                 │  └─ UsuarioDto.java
│  │  │  │                 ├─ mapper
│  │  │  │                 │  ├─ BeneficiarioMapper.java
│  │  │  │                 │  ├─ PlanoMapper.java
│  │  │  │                 │  └─ UsuarioMapper.java
│  │  │  │                 ├─ model
│  │  │  │                 │  ├─ Beneficiario.java
│  │  │  │                 │  ├─ Plano.java
│  │  │  │                 │  └─ Usuario.java
│  │  │  │                 ├─ service
│  │  │  │                 │  ├─ BeneficiarioService.java
│  │  │  │                 │  ├─ PlanoService.java
│  │  │  │                 │  └─ UsuarioService.java
│  │  │  │                 ├─ ServletInitializer.java
│  │  │  │                 └─ UnimedApplication.java
│  │  │  └─ resources
│  │  │     ├─ application.properties
│  │  │     ├─ data.sql
│  │  │     └─ schema.sql
│  │  └─ test
│  │     └─ java
│  │        └─ br
│  │           └─ com
│  │              └─ paulo
│  │                 └─ teixeira
│  │                    └─ unimed
│  │                       └─ UnimedApplicationTests.java
├─ diagrama.png
├─ frontend
│  ├─ .browserslistrc
│  ├─ .editorconfig
│  ├─ angular.json
│  ├─ karma.conf.js
│  ├─ package-lock.json
│  ├─ package.json
│  ├─ README.md
│  ├─ src
│  │  ├─ app
│  │  │  ├─ app-routing.module.ts
│  │  │  ├─ app.component.html
│  │  │  ├─ app.component.scss
│  │  │  ├─ app.component.spec.ts
│  │  │  ├─ app.component.ts
│  │  │  ├─ app.module.ts
│  │  │  ├─ beneficiario
│  │  │  │  ├─ beneficiario.component.html
│  │  │  │  ├─ beneficiario.component.scss
│  │  │  │  ├─ beneficiario.component.spec.ts
│  │  │  │  └─ beneficiario.component.ts
│  │  │  ├─ core
│  │  │  │  ├─ core.module.ts
│  │  │  │  └─ models
│  │  │  │     ├─ beneficiario.model.ts
│  │  │  │     ├─ plano.model.ts
│  │  │  │     └─ usuario.model.ts
│  │  │  ├─ home
│  │  │  │  ├─ home.component.html
│  │  │  │  ├─ home.component.scss
│  │  │  │  ├─ home.component.spec.ts
│  │  │  │  └─ home.component.ts
│  │  │  ├─ plano
│  │  │  │  ├─ listar.component.html
│  │  │  │  ├─ listar.component.scss
│  │  │  │  ├─ listar.component.spec.ts
│  │  │  │  └─ listar.component.ts
│  │  │  └─ usuario
│  │  │     ├─ login
│  │  │     │  ├─ login.component.html
│  │  │     │  ├─ login.component.scss
│  │  │     │  ├─ login.component.spec.ts
│  │  │     │  └─ login.component.ts
│  │  │     ├─ signup
│  │  │     │  ├─ signup.component.html
│  │  │     │  ├─ signup.component.scss
│  │  │     │  ├─ signup.component.spec.ts
│  │  │     │  └─ signup.component.ts
│  │  │     ├─ usuario-routing.module.ts
│  │  │     └─ usuario.module.ts
│  │  ├─ assets
│  │  │  ├─ banner_imposto de renda.png
│  │  │  ├─ banner_ona.png
│  │  │  ├─ Dia das mães_Banner site.png
│  │  │  ├─ regulariza_unimed.png
│  │  │  └─ UNIMED_URGENTE.png
│  │  ├─ environments
│  │  │  ├─ environment.prod.ts
│  │  │  └─ environment.ts
│  │  ├─ favicon.ico
│  │  ├─ index.html
│  │  ├─ main.ts
│  │  ├─ polyfills.ts
│  │  ├─ services
│  │  │  ├─ api-services.service.spec.ts
│  │  │  ├─ api-services.service.ts
│  │  │  ├─ auth.guard.ts
│  │  │  ├─ auth.service.spec.ts
│  │  │  └─ auth.service.ts
│  │  ├─ styles.scss
│  │  └─ test.ts
│  ├─ tsconfig.app.json
│  ├─ tsconfig.json
│  └─ tsconfig.spec.json
├─ README.md
└─ Teste full-stack collection.json

```
