package com.paavieira.quickstarts.architecture.framework;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

		final int globalErrorCount = result.getGlobalErrorCount();
		final List<String> globalErrors = result.getGlobalErrors().stream()
			.map(ge -> ge.getDefaultMessage()).collect(toList());

		final int fieldErrorCount = result.getFieldErrorCount();
		final Map<String, List<String>> fieldErrors = result.getFieldErrors().stream()
			.collect(groupingBy(FieldError::getField, mapping(FieldError::getDefaultMessage, toList())));

		return new Error(BAD_REQUEST.value(), globalErrorCount, globalErrors, fieldErrorCount, fieldErrors);

    }

    static class Error {

		private final int status;

		private final int globalErrorCount;
        private final List<String> globalErrors;

		private final int fieldErrorCount;
		private final Map<String, List<String>> fieldErrors;

        private Error(
			final int status,
			final int globalErrorCount,
			final List<String> globalErrors,
			final int fieldErrorCount,
			final Map<String, List<String>> fieldErrors
		) {
			this.status = status;
			this.globalErrorCount = globalErrorCount;
			this.globalErrors = globalErrors;
			this.fieldErrorCount = fieldErrorCount;
            this.fieldErrors = fieldErrors;
        }

        public int getStatus() {
            return status;
        }

        public int getGlobalErrorCount() {
            return globalErrorCount;
		}

		public List<String> getGlobalErrors() {
            return globalErrors;
		}

		public int getFieldErrorCount() {
            return fieldErrorCount;
		}

        public Map<String, List<String>> getFieldErrors() {
            return fieldErrors;
        }

	}

}