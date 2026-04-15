### Create shared key

```bash
openssl rand -base64 64
```

### Modified code
```java
@Configuration
public class JwtConfig {

    private String secret = "64 bit secret key";

    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new OctetSequenceKey.Builder(secret.getBytes())
                .algorithm(JWSAlgorithm.HS256)
                .build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKey spec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(spec).build();
    }
}
```

### Signup

<img src="./Images/1 SignUp.png">

### Login

<img src="./Images/2 LogIn.png">

### Authenticate Using JWT

<img src="./Images/3 Authenticate Using JWT.png">
