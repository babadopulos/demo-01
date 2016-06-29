# demo-01
Testes de integração/unidade de aplicativos Java usando Docker com Maven e NetBeans

Criar uma maquina virtual dentro do virtualbox para rodar o docker engine
-------------------------------------------------------------------------
<pre>
$ docker-machine create --driver virtualbox demo
</pre>

recuperar as informações de configuração do ambiente
----------------------------------------------------
<pre>
$ docker-machine env demo
</pre>

recuperar o ip do docker engine
-------------------------------
<pre>
$ docker-machine env demo
</pre>

rodar o redis pela primeira vez dentro do docker, irá fazer o download do container necessário automaticamente.
---------------------------------------------------------------------------------------------------------------
<pre>
$ docker run -p 6379:6379 --name redis -d redis
</pre>

iniciar o redis
---------------
<pre>
$ docker start redis
</pre>

parar o redis
-------------
<pre>
$ docker start redis
</pre>

Integração com NetBeans
-----------------------
Para realizar os testes de integração de dentro do NetBeans no OS X, é necessario exportar algumas variávies com as informações de conexão e o certificado digital, e reiniciar o NetBeans.
<pre>
$ eval $(docker-machine env demo)
$ launchctl setenv DOCKER_CERT_PATH "$DOCKER_CERT_PATH"
$ launchctl setenv DOCKER_HOST "$DOCKER_HOST"
$ launchctl setenv DOCKER_IP $(docker-machine ip demo)
</pre>

[nbactions.xml][1] contém as informações necessárias para configurar o NetBeans para rodar testes de integração via menu de contexto.

Clique com o botão direito sobre o arquivo a ser testado (*IT.java) -> Run Maven -> Test with Docker

[1]: https://github.com/babadopulos/demo-01/blob/master/nbactions.xml

Maven
-----
para executar os testes de integração via maven, sem subir o docker (testar com banco local). [não esqueça de trocar o IP do redis na aplicação]
<pre>
mvn clean install -Ddocker.skip
</pre>
