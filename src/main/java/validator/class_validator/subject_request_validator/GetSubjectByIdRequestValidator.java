package validator.class_validator.subject_request_validator;

import request.subject_request.GetSubjectByIdRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetSubjectByIdRequestValidator implements IClassValidator<GetSubjectByIdRequest> {
    private final IdValidator idValidator;

    public GetSubjectByIdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetSubjectByIdRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
