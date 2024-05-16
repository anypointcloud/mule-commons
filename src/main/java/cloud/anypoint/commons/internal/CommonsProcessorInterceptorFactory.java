package cloud.anypoint.commons.internal;

import org.mule.runtime.api.component.location.ComponentLocation;
import org.mule.runtime.api.interception.ProcessorInterceptor;
import org.mule.runtime.api.interception.ProcessorInterceptorFactory;

public class CommonsProcessorInterceptorFactory implements ProcessorInterceptorFactory {
    @Override
    public ProcessorInterceptor get() {
        return new WhileProcessorInterceptor();
    }

    @Override
    public boolean intercept(ComponentLocation location) {
        return CommonsOperations.WHILE.equals(
                location.getComponentIdentifier().getIdentifier().getName());
    }
}
