# Generative AI - Use Case #1

This project is part of a initiative called "Generative AI". This initiative consists in validating performance metrics regarding usage of ChatGPT or not when resolving daily coding problems. This project is created on the use case number 1, **without** using ChatGPT. The technologies used are Java 17 and Spring Boot 3.1.3.

The Use Case #1 requires the software engineer to create an application that performs calls to the public API ([countries](https://restcountries.com/v3.1)), collecting data and presenting to the user the data. This data presented will be according to the results from the call to the public API and also after applying filtering rules and pagination functionality.

## Running the application

### Prerequisites

In order to run the application, it is necessary to first have:

- JAVA 17 (suggested: [download Amazon Corretto 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html))
  
Follow the guide on the link provided to install on your machine accordingly (for macOS, Windows or Linux).

### Compiling and running

After installing JAVA 17 on your machine, you can call the maven wrapper present in the root folder, with the command to compile and run the application.

Since this is a Spring Boot application, the application could run directly from maven, by running

On macOs/Linux:
```shell
$ ./mvnw clean spring-boot:run
```

On Windows:
```shell
$ mvnw clean spring-boot:run
```

This command will start the application on [localhost:8080](http://localhost:8080). Accessing this link you should be able to see the message 

`"SERVICE IS UP"`

## Using the application

This application main function is to request data from the ([Countries API](https://restcountries.com/v3.1)) and return basic information about the countries with possibility provide a few parameters.

To get the full list of this countries, it is possible to access [localhost:8080/countries](http://localhost:8080/countries)

The parameters available are the following:

- `name`
- `population`
- `sort`
- `limit`

Let's dive into the usage of each of them with some examples

### Filter: `name`

The `name` filter provides you the possibility to query the list of countries name, the common property from the ([Countries API](https://restcountries.com/v3.1)).
The name provided as parameters will be used to filter any country that contains queried name as part of the country name.

Examples:

- [localhost:8080/countries?name=st](http://localhost:8080/countries?name=st) - return country like "Estonia" and other that contain "st" in the name
- [localhost:8080/countries?name=Sp](http://localhost:8080/countries?name=Sp) - return countries like "Spain"  and any other that contain "Sp" in tge name.
- [localhost:8080/countries?name=St](http://localhost:8080/countries?name=St) - return the same result as "st" since the letters matching is case insensitive.

### Filter: population

The `population` filter accepts a number. The filter will get all countries with population less than the number provided. This number is expressed in order of millions. e.g. providing `10` means 10 millions as population.

Examples:

- [localhost:8080/countries?population=10](http://localhost:8080/countries?population=10) - return all countries with population less than 10 million.
- [localhost:8080/countries?population=0](http://localhost:8080/countries?population=0) - return no countries.
- [localhost:8080/countries?population=-10](http://localhost:8080/countries?population=-10) - return all countries, any negative number provided will ignore the filter.

### Ordering: `sort`

The `sort` parameter could give you the possibility to order the countries by name in an `ascend` or `descend` order.

Examples:

- [localhost:8080/countries?sort=ascend](http://localhost:8080/countries?sort=ascend) - return all countries in ascending order by country name.
- [localhost:8080/countries?sort=descend](http://localhost:8080/countries?sort=descend) - return all countries in descending order by country name.

### Filter: `limit`

The `limit` filter gives you the possibility to provide the number of results that you will get.

Examples:

- [localhost:8080/countries?limit=10](http://localhost:8080/countries?limit=10) - return the first ten country from the list
- [localhost:8080/countries?limit=-1](http://localhost:8080/countries?limit=-1) - returns all countries. Any negative number will be ignored
- [localhost:8080/countries?limit=0](http://localhost:8080/countries?limit=0) - return no country.

### Using all the filters

It is possible to use all the filters together, or just a couple of them, depending on your necessity. Therefore, if you would like to know the first ten countries that have population less than 10 million, in ascending order, the usage would be:

[localhost:8080/countries?limit=10&population=10&sort=ascend](http://localhost:8080/countries?limit=10&population=10&sort=ascend)
