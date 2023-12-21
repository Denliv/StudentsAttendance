package validator.class_validator.lesson_request_validator;

import request.lesson_request.GetLessonByIdRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByIdRequestValidator implements IClassValidator<GetLessonByIdRequest> {
    private final IdValidator idValidator;

    public GetLessonByIdRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetLessonByIdRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getId(), list, "Id");
        return list;
    }
}
