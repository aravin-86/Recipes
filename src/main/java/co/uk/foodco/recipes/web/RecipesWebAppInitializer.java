package co.uk.foodco.recipes.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class RecipesWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(RecipesMvcConfig.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic restDispatcher = container.addServlet(
                "recipes-rest", new DispatcherServlet(dispatcherServlet));
        restDispatcher.setLoadOnStartup(1);
        restDispatcher.setAsyncSupported(true);
        restDispatcher.addMapping("/foodco/*");

    }

}
