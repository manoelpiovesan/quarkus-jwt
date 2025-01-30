# Autenticação JWT com Quarkus

Inspirado em [emersonsiega/quarkus-jwt](https://github.com/emersonsiega/quarkus-jwt)

## Criar chave privada e pública

Uma chave privada é necessária para assinar o token JWT e a chave pública é necessária para verificar a assinatura.


Navegar até o diretório de recursos
```bash
cd src/main/resources
```

Gerar a chave base

```bash
openssl genrsa -out baseKey.pem
```

A partir da chave base, gerar a chave privada

```bash
openssl pkcs8 -topk8 -inform PEM -in baseKey.pem -out privateKey.pem -nocrypt
```

A partir da chave base, gerar a chave pública distribuível

```bash
openssl rsa -in baseKey.pem -pubout -outform PEM -out publicKey.pem
```

Mover a chave publica para o diretório META-INF/resources

```bash
mkdir -p META-INF/resources && mv publicKey.pem META-INF/resources
```

## Configurar o application.properties

```properties
mp.jwt.verify.publickey.location=META-INF/resources/publicKey.pem
mp.jwt.verify.issuer=https://quarkus.io/using-jwt-rbac
quarkus.smallrye-jwt.enabled=true
```

Pronto! Agora você pode acessar a aplicação e obter um token JWT.


