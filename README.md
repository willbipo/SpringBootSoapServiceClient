# Configuración del Proyecto

Este proyecto muestra cómo consumir un servicio SOAP en Spring Boot.

## Endpoints:

- `localhost:8080/restar`
- `localhost:8080/multiplicar`
- `localhost:8080/dividir`
- `localhost:8080/sumar`

## Request:

```json
{
    "numero1": 20,
    "numero2": 5
}
```


## Response:
```json
{
    "response": 100
}
```

## Dependencias:

```xml
<dependencies>
    <dependency>
        <groupId>org.glassfish.jaxb</groupId>
        <artifactId>jaxb-runtime</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web-services</artifactId>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <excludes>
                    <exclude>
                        <groupId>org.projectlombok</groupId>
                        <artifactId>lombok</artifactId>
                    </exclude>
                </excludes>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.jvnet.jaxb2.maven2</groupId>
            <artifactId>maven-jaxb2-plugin</artifactId>
            <version>0.14.0</version>
            <executions>
                <execution>
                    <goals>
                        <goal>generate</goal>
                    </goals>
                </execution>
            </executions>
            <!-- Para esquema desde URL -->
            <configuration>
                <schemaLanguage>WSDL</schemaLanguage>
                <generateDirectory>${project.basedir}/src/main/java</generateDirectory>
                <generatePackage>com.williams.wsdl</generatePackage>
                <schemas>
                    <schema>
                        <url>http://www.dneonline.com/calculator.asmx?WSDL</url>
                    </schema>
                </schemas>
            </configuration>

            <!-- Para esquema desde archivo -->
            <!--<configuration>
                <schemaLanguage>WSDL</schemaLanguage>
                <schemaDirectory>${project.basedir}/src/main/java/resources/wsdl</schemaDirectory>
                <schemas>
                    <schemaFiles>CalculatorApi.wsdl</schemaFiles>
                    <packageName>com.williams.wsdl</packageName>
                    <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
                </schemas>
            </configuration>-->

        </plugin>
    </plugins>
</build>
```
