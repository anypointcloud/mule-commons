package cloud.anypoint.commons.internal;

import static org.mule.runtime.api.meta.ExpressionSupport.REQUIRED;
import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.core.api.el.ExpressionManager;
import org.mule.runtime.extension.api.annotation.Expression;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.runtime.parameter.Literal;
import org.mule.runtime.extension.api.runtime.parameter.ParameterResolver;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.mule.runtime.extension.api.runtime.route.Chain;


public class CommonsOperations {

    /*
     * TODO: still determining whether Literal<String> or ParameterResolver<Boolean> is the
     *  right move here for the condition parameter
     */
    public void whileScope(Chain route,
                           @Expression(REQUIRED) Literal<String> conditionExpression,
                           ExpressionManager expressionManager,
                           CompletionCallback<Object, Object> callback) {
        // I would like to find a way to use non-blocking reactive callbacks to do the
        // iteration here, rather than hold a thread doing a simple java while.
        // need to look at mule core components for inspiration
    }
}
