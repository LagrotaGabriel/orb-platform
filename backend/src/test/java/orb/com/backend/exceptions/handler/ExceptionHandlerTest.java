package orb.com.backend.exceptions.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import orb.com.backend.exceptions.models.DuplicateResourceException;
import orb.com.backend.exceptions.models.EntityNotFoundException;
import orb.com.backend.exceptions.models.StandardError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExceptionHandlerTest {


    private ExceptionHandler exceptionHandler;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private WebRequest webRequest;

    @Mock
    private ConstraintViolation<Object> constraintViolation;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        exceptionHandler = new ExceptionHandler();
    }

    @Test
    void shouldTestDuplicateResourceException() {

        String expectedMessage = "Mock message";
        String expectedPath = "/api/v1/orb/cup";
        when(httpServletRequest.getRequestURI()).thenReturn(expectedPath);

        DuplicateResourceException exception = new DuplicateResourceException(expectedMessage);

        ResponseEntity<StandardError> response =
                exceptionHandler.duplicateResourceExceptionHandler(
                        httpServletRequest,
                        exception
                );

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        StandardError error = response.getBody();
        assert error != null;
        assertEquals(expectedMessage, error.getError());
        assertEquals(409, error.getStatus());
        assertEquals(expectedPath, error.getPath());
    }

    @Test
    void shouldTestEntityNotFoundException() {

        String expectedMessage = "Mock message";
        String expectedPath = "/api/v1/orb/cup/fe721a04-d0b6-4bdd-acd5-97ce6e54ead9";
        when(httpServletRequest.getRequestURI()).thenReturn(expectedPath);

        EntityNotFoundException exception = new EntityNotFoundException(expectedMessage);

        ResponseEntity<StandardError> response =
                exceptionHandler.entityNotFoundExceptionHandler(
                        httpServletRequest,
                        exception
                );

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        StandardError error = response.getBody();
        assert error != null;
        assertEquals(expectedMessage, error.getError());
        assertEquals(404, error.getStatus());
        assertEquals(expectedPath, error.getPath());
    }

    @Test
    void shouldTestGenericExceptionHandler() {

        String expectedMessage = "Mock message";
        String expectedPath = "/api/v1/orb/cup/fe721a04-d0b6-4bdd-acd5-97ce6e54ead9";
        when(httpServletRequest.getRequestURI()).thenReturn(expectedPath);

        RuntimeException exception = new RuntimeException(expectedMessage);

        ResponseEntity<StandardError> response =
                exceptionHandler.genericExceptionHandler(
                        httpServletRequest,
                        exception
                );

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        StandardError error = response.getBody();
        assert error != null;
        assertEquals(expectedMessage, error.getError());
        assertEquals(500, error.getStatus());
        assertEquals(expectedPath, error.getPath());
    }

    @Test
    void testHandleValidationExceptions() {

        BindingResult bindingResult = mock(BindingResult.class);
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        WebRequest request = mock(WebRequest.class);

        FieldError fieldError = new FieldError("objectName", "field", "Field cannot be empty");
        when(bindingResult.getFieldErrors()).thenReturn(Collections.singletonList(fieldError));
        when(exception.getBindingResult()).thenReturn(bindingResult);

        ResponseEntity<Object> response = exceptionHandler.handleValidationExceptions(exception, request);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertInstanceOf(Map.class, response.getBody());
        assertEquals("Field cannot be empty", ((Map<?, ?>) response.getBody()).get("field"));
    }

    @Test
    void testHandleConstraintViolationException() {

        String fieldName = "testField";
        String errorMessage = "Invalid value";

        Path mockPath = mock(Path.class);
        when(mockPath.toString()).thenReturn(fieldName);
        when(constraintViolation.getPropertyPath()).thenReturn(mockPath);
        when(constraintViolation.getMessage()).thenReturn(errorMessage);

        ConstraintViolationException exception = new ConstraintViolationException(
                new HashSet<>(Collections.singletonList(constraintViolation))
        );

        ResponseEntity<Object> response = exceptionHandler.handleConstraintViolationException(exception, webRequest);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        @SuppressWarnings("unchecked")
        Map<String, String> errors = (Map<String, String>) response.getBody();
        assert errors != null;
        assertEquals(1, errors.size());
        assertEquals(errorMessage, errors.get(fieldName));
    }
}
