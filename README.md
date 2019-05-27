# Bank and Branches

Hosted at Heroku: https://protected-castle-32347.herokuapp.com/swagger-ui.html


# Instructions

This is a maven app.

```maven clean install```

# Database Used

 [Indian_Banks Database!](https://github.com/snarayanank2/indian_banks)
 
 
# Heroku Installation Notes

1. [Deploying SpringBoot app to heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)
2. Exporting sql data

``` heroku pg:psql --app protected-castle-32347 <  ../indian_banks/indian_banks.sql 
```

*protected-castle-32347* is the heroku app name
 
 ## todo
 1. Add proper logging
 2. Add tests