# Validation-Extended

## Descrição

O **Validation-Extended** é um projeto desenvolvido para agregar validações adicionais não presentes nas validações padrão do Hibernate. Este projeto oferece um conjunto de anotações e validadores personalizados que podem ser facilmente integrados em qualquer aplicação Java que utilize Hibernate Validator.

## Funcionalidades

- Validações adicionais para campos de texto, números, datas e outros tipos.
- Anotações personalizadas para simplificar o uso das novas validações.
- Facilidade de integração com projetos existentes que já utilizam Hibernate Validator.

## Instalação

Para adicionar o **Validation-Extended** ao seu projeto, siga os passos abaixo:

### Maven

Adicione a dependência ao seu arquivo `pom.xml`:

```xml
<dependency>
    <groupId>br.dev.joaoguilherme</groupId>
    <artifactId>validation-extended</artifactId>
    <version>1.5.2-SNAPSHOT</version>
</dependency>
```

## Uso

Após adicionar a dependência ao seu projeto, você pode começar a utilizar as novas validações. Exemplo:

```java
import com.seuprojeto.validation.extended.annotations.NovaValidacao;

public class SeuModelo {

    @Validacao
    private String meuCampo;

    // getters e setters
}
```

## Validações Disponíveis

- **@Boleto**: Validação para número de boleto.
- **@CEP**: Validação para número do código postal (CEP).
- **@CNH**: Validação para número da Carteira Nacional de Habilitação (CNH).
- **@CNJ**: Validação para número do Conselho Nacional de Justiça (CNJ).
- **@Coordenada**: Validação para coordenadas geográficas.
  - **Coordenada em Graus Decimais**: Validação para coordenadas geográficas no formato graus decimais. Exemplo: -23.551944, -46.633333.
  - **Coordenada em Graus, Minutos e Segundos**: Validação para coordenadas geográficas no formato graus, minutos e segundos. Exemplo: 23° 33' 7.0" S, 46° 38' 0.0" W.
  - **Coordenada MGRS**: Validação para coordenadas geográficas no formato MGRS (Military Grid Reference System). Exemplo: 23KQD9234567890.
- **@Cor**: Validação para cor em diversos formatos.
  - **RGB**: Validação para cor no formato RGB. Exemplo: rgb(255, 0, 0).
  - **HEX**: Validação para cor no formato hexadecimal. Exemplo: #FF0000.
  - **HSL**: Validação para cor no formato HSL. Exemplo: hsl(0, 100%, 50%).
  - **HSV**: Validação para cor no formato HSV. Exemplo: hsv(0, 100%, 100%).
  - **CMYK**: Validação para cor no formato CMYK. Exemplo: cmyk(0%, 100%, 100%, 0%).
  - **RGBA**: Validação para cor no formato RGBA. Exemplo: rgba(255, 0, 0, 1).
  - **HSLA**: Validação para cor no formato HSLA. Exemplo: hsla(0, 100%, 50%, 1).
  - **HSVA**: Validação para cor no formato HSVA. Exemplo: hsva(0, 100%, 100%, 1).
  - **CMYKA**: Validação para cor no formato CMYKA. Exemplo: cmyka(0%, 100%, 100%, 0%).
- **@CPF_CNPJ**: Validação para número de CPF ou CNPJ.
- **@Idade**: Validação para idade.
- **@IP**: Validação para endereço IP.
- **@Latitude**: Validação para latitude.
- **@Longitude**: Validação para longitude.
- **@Nome**: Validação para nome.
- **@RG**: Validação para número do Registro Geral (RG).
- **@Telefone**: Validação para número de telefone.
- **@URL**: Validação para URL.

Mais validações serão adicionadas em futuras versões.

## Contribuição

Contribuições são bem-vindas! Se você encontrar um bug ou tiver uma sugestão de melhoria, por favor, abra uma issue ou envie um pull request.

---

Feito com ❤️ por [JaaumG](https://github.com/jaaumg)