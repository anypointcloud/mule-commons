package cloud.anypoint.commons.internal;

import static org.mule.runtime.api.meta.ExpressionSupport.REQUIRED;
import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.api.artifact.Registry;
import org.mule.runtime.api.event.Event;
import org.mule.runtime.api.meta.model.operation.OperationModel;
import org.mule.runtime.core.api.el.ExpressionManager;
import org.mule.runtime.core.api.event.CoreEvent;
import org.mule.runtime.core.internal.message.InternalEvent;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.runtime.operation.ExecutionContext;
import org.mule.runtime.extension.api.runtime.operation.Result;
import org.mule.runtime.extension.api.runtime.parameter.Literal;
import org.mule.runtime.extension.api.runtime.parameter.ParameterResolver;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.mule.runtime.extension.api.runtime.route.Chain;
import org.mule.runtime.module.extension.api.runtime.privileged.EventedResult;
import org.mule.runtime.module.extension.internal.runtime.DefaultExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import javax.inject.Inject;


public class CommonsOperations {
    public static final String WHILE = "while";


    private static final Logger LOGGER = LoggerFactory.getLogger(CommonsOperations.class);

//    @Inject
//    private ExpressionManager expressionManager;
//    @Inject
//    ApplicationContext appContext;


    @Inject
    Registry registry;

//    @Inject
//    private ExecutionContext<OperationModel> executionContext;
    /*
     * TODO: ideas
     *  need to get a hold of the variables or the whole CoreEvent, which is forbidden by the SDK
     *  1. possibly use a ProcessorInterceptorFactory (seems OP) (but possibly the best way)
     *  2. Tracers?  (this requires pulling in dependencies and risks classloader barriers)
     *  2a. ProfilingServiceWrapper
     *  X4. Notifications
     *  5. Subclass CoreEvent and put an automatic transformer in the registry
     */
    @Alias(WHILE)
    public void whileScope(Chain route,
//                           Event event,
//                           @Expression(REQUIRED) Literal<String> conditionExpression,
                           CompletionCallback<Object, Object> callback) {
        // I would like to find a way to use non-blocking reactive callbacks to do the
        // iteration here, rather than hold a thread doing a simple java while.
        // need to look at mule core components for inspiration
//        DefaultExecutionContext c = (DefaultExecutionContext) executionContext;
//        CoreEvent event = c.getEvent();
//        if (null == event) {
//            callback.error(new IllegalArgumentException("event is null"));
//        } else if (! (event instanceof CoreEvent)) {
//            callback.error(new IllegalArgumentException("event is not CoreEvent, it is " + event.getClass().getName()));
//        } else {
//            CoreEvent coreEvent = (CoreEvent) event;
////        LOGGER.info("event {}", ((EventedResult) inputResult).getEvent());
////        expressionManager.
////        route.process(result -> {});
//        }
//        for (Object o: registry.lookupAllByType(Object.class)) {
//            for (Class c: o.getClass().getInterfaces()) {
//                LOGGER.info("\nClass {}   {}", o.getClass().getName(), c.getName());
//            }
//        }
        route.process(callback::success,
                (t, r) -> callback.error(t));
    }
}
