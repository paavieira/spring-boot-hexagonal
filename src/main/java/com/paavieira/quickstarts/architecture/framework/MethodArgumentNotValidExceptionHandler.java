package com.paavieira.quickstarts.architecture.framework;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Error methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		final BindingResult result = ex.getBindingResult();
		final int errorCount = result.getErrorCount();
        final List<String> globalErrors = result.getGlobalErrors().stream().map(ge -> ge.getDefaultMessage()).collect(Collectors.toList());
        final List<String> fieldErrors = result.getFieldErrors().stream().map(fe -> fe.getDefaultMessage()).collect(Collectors.toList());
        return new Error(BAD_REQUEST.value(), errorCount, globalErrors, fieldErrors);
    }

    static class Error {

		private final int status;
		private final int errorCount;
        private final List<String> globalErrors;
        private final List<String> fieldErrors;

        Error(final int status, final int errorCount, final List<String> globalErrors, final List<String> fieldErrors) {
			this.status = status;
			this.errorCount = errorCount;
			this.globalErrors = globalErrors;
            this.fieldErrors = fieldErrors;
        }

        public int getStatus() {
            return status;
        }

        public int getErrorCount() {
            return errorCount;
		}

		public List<String> getGlobalErrors() {
            return globalErrors;
		}

        public List<String> getFieldErrors() {
            return fieldErrors;
        }

	}

}