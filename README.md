#Swagger 
usually  we need to provide documentation for the apis that we developed so other developers and client can understand better what each api does.swagger is a good tool to document springboot apis.
###Steps
1. maven configuration
```
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${springfox-swagger.version}</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${springfox-swagger.version}</version>
        </dependency>

```
2. we need to set up configuration for swagger
```
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .build().pathMapping("/")
                .apiInfo(metaData());
    }
    private ApiInfo metaData(){

        Contact contact = new Contact("pooya-fils", "https://github.com/pooyafils","" +
                "mygithub");

        return new ApiInfo(
                "swagger features",
                "    example of swaager features with spring-boot",
                "1.0",
                "Terms of Service",
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
```
``metaData()`` method has a role to define a general information about api doument

3. in the controller, we need to have ``@Api`` to have a short description for the class that apis have been developed.
by ``    @ApiOperation(value = "info...")`` we can explain what each api does.
4. we can also have ``    @ApiModelProperty(value = "info about  attribute",required = true)`` in our model class to explain with more details what each  attribute does or meaning.
5. last step you need to run the application and enter to ``http://localhost:8081/swagger-ui.html`` to see all the documentation your provide by swagger.
![Farmers Market Finder Demo](photo/swagger.png)
