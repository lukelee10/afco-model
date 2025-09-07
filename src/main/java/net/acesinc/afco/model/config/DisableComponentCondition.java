package net.acesinc.afco.model.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Allows a component to be disabled conditionally using a property in the
 * application configuration. The property should be named what ever the class
 * name is of the component you're attaching this condition to. For example, if
 * you attached this to the GlobalExceptionHandler, the property name should be
 * "GlobalExceptionHandler.disabled" Setting that property to true to cause the
 * GlobalExceptionHandler to be disabled in the application and not be loaded.
 */
public class DisableComponentCondition implements Condition {

    private static final Logger log = LoggerFactory.getLogger(DisableComponentCondition.class);

    /**
     * This condition should not match if the Annotated Component is disabled in
     * configuration
     *
     * @param context The context
     * @param metadata The Metadata for the attached annotation
     * @return Returns false if the Annotated component is disabled in
     * configuration, True otherwise
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // Get the class name of the class the @ControllerAdvice is attached to using reflection
        String className = metadata.getAnnotations().stream()
                .map(a -> a.getSource().toString())
                .distinct()
                .findAny()
                .get();

        if (className != null) {
            String simpleClassName = className.substring(className.lastIndexOf('.') + 1);

            // Build the property key based on the class name
            String propertyKey = simpleClassName + ".disabled";

            // Check if the property is set in the environment
            Boolean disabled = Boolean.valueOf(context.getEnvironment().getProperty(propertyKey));

            if (disabled) {
                log.debug("Disabling [ " + simpleClassName + " ] because [ " + propertyKey + " ] is set to true");
            }
            return !disabled;
        } else {
            // couldn't determine the name, so leave it enabled
            return true;
        }
    }
}
