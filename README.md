# Encurtador de URL

Pagina para encurtar urls

### Prerequisitos

```
JDK 8
Docker
Eclipse
```

### Instalando

Baixe o projeto e o importe no <b>Eclipse<b> como <b>Existing Maven Projects</b>

Com o projeto importado:

```
Click com o botão direito e "Run As > Maven Clean"
```

apos finalizar

```
Click com o botão direito e "Run As > Maven Install"
```
apos finalizar sera criado uma imagem docker chamada 'encurtador-url' o maven install execute em um terminal

```
$ docker run -p 80:8080 encurtador-url
```

Acesse a url localhost:80 no seu navegador

## Tecnologias utilizadas

* [Bootstrap](https://getbootstrap.com/)
* [FontAwesome](https://fontawesome.com/)
* [ngClipBoard](https://github.com/nico-val/ngClipboard)
* [Maven](https://maven.apache.org/)
* [Spring](https://spring.io/projects/spring-boot)
* [Docker](https://www.docker.com/)
* [spotifyDockerMavenPlugin](https://github.com/spotify/docker-maven-plugin)

## Autor

* **Rafael Garcia Sant'Anna** [MyGitHub](https://github.com/rgs0712)


