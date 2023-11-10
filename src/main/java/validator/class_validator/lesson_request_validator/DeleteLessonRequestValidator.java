package validator.class_validator.lesson_request_validator;

import request.lesson_request.DeleteLessonRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.ListValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteLessonRequestValidator implements IClassValidator<DeleteLessonRequest> {
    private final IdValidator idValidator;
    public DeleteLessonRequestValidator(IdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteLessonRequest request) {
        var list = new ArrayList<String>();
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
