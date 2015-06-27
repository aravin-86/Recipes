
#Recipes Web Application 
-------------------------

####Prerequisites:
 1. JRE 1.7
 2. Maven 3
 
##Instructions to run in Terminal
---------------------------------
(For Ex: COMMAND PROMPT)

1. Move into your project folder.
2. Run Maven command given below.

   `mvn clean jetty:run`

By default, system is configured with 12 recipes. If you want to change the total recipes in system to test multiple scenarios. 
Please use the following command below.

  `mvn clean jetty:run -DtotalRecipes=(your-total-recipes-to-be-configured-in-system)`
  
  Ex:
  `mvn clean jetty:run -DtotalRecipes=0`

##Instructions to run in IDE
----------------------------
1. Setup the project into your preferred IDE.
2. Run maven commands as instructed above.

##Features Implemented
----------------------
1. recipe_list.feature

##Features to be Implemented
----------------------------
1. recipe.feature
2. filter_recipes.feature
3. star.feature

Hope you made it through with these instructions.

###Technologies/Frameworks/Libraries Used
---------------------------------------
1. Java
2. Spring MVC
3. Angular JS
4. Angular UI Boostrap
5. Bootstrap CSS
6. Mockito & JUnit
7. HTML

--- END ----
   

 

