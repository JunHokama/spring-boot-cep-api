# SPRING BOOT CEP API

This project demonstrates how to consume an external API in a Spring Boot application to retrieve information based on a Brazilian ZIP code (CEP).

# Explaining CEP to a Non-Brazilian Audience

In Brazil, CEP (Código de Endereçamento Postal) is the equivalent of a ZIP code. It is composed of eight digits and is used to identify specific geographic regions for the purpose of sorting and delivering mail. Each CEP corresponds to a precise area, ranging from large cities to small towns.

# Accessing the CEP Web Service

To access the web service, provide a valid CEP (ZIP code) in an 8-digit format, for example: "01001000". Following the CEP, specify the desired return type, which can be either "json" or "xml".

# Example of a CEP search:

http://localhost:8080/cep-inquiry/01001000

## CEP Validation

When querying an invalid CEP format, such as "950100100" (9 digits), "95010A10" (alphanumeric), or "95010 10" (contains spaces), the response code will be 400 (Bad Request). Before accessing the web service, validate the format of the CEP and ensure it consists of 8 digits.

# Return Formats

Below is an example of accessing the web service and the JSON return format:

### JSON

URL: `viacep.com.br/ws/01001000/json/`

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
