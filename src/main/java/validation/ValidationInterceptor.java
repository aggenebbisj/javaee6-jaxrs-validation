
package validation;

import java.util.HashSet;
import java.util.Set;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

@Validatable
@Interceptor
public class ValidationInterceptor {

    @AroundInvoke
    public Object validate(InvocationContext ctx) throws Exception {
        final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        final Set<ConstraintViolation<Object>> violations = validator.validate(ctx.getParameters()[0]);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
        return ctx.proceed();
    }
    
}
