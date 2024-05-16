package cloud.anypoint.commons.internal;

import org.mule.runtime.api.component.location.ComponentLocation;
import org.mule.runtime.api.interception.InterceptionEvent;
import org.mule.runtime.api.interception.ProcessorInterceptor;
import org.mule.runtime.api.interception.ProcessorParameterValue;
import org.mule.runtime.api.lifecycle.Initialisable;
import org.mule.runtime.api.lifecycle.InitialisationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WhileProcessorInterceptor implements ProcessorInterceptor, Initialisable {
    private static final Logger LOGGER = LoggerFactory.getLogger(WhileProcessorInterceptor.class);

    @Override
    public void before(ComponentLocation location, Map<String, ProcessorParameterValue> parameters, InterceptionEvent event) {
        ProcessorInterceptor.super.before(location, parameters, event);
        LOGGER.info("intercepted " + event.getContext().getId());
        event.getContext().getId();
    }

    @Override
    public void initialise() throws InitialisationException {
        LOGGER.info("interceptor initializing");
    }
}
