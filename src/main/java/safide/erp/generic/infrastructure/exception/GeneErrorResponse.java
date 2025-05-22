package safide.erp.generic.infrastructure.exception;

import lombok.Getter;
import org.springframework.dao.DataAccessException;
@Getter
public class GeneErrorResponse extends RuntimeException  {

    private static final long serialVersionUID = 1L;
    private final String errorCode;
    private final String errorMessage;

    public GeneErrorResponse(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public GeneErrorResponse(String errorCode, String errorMessage, DataAccessException ex) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}