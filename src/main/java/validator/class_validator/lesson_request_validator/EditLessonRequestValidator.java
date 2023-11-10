package validator.class_validator.lesson_request_validator;

import request.lesson_request.EditLessonRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.ListValidator;

import java.util.ArrayList;
import java.util.List;

public class EditLessonRequestValidator implements IClassValidator<EditLessonRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;

    public EditLessonRequestValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public List<String> validate(EditLessonRequest request) {
        var list = new ArrayList<String>();
        if (!idValidator.validate(request.getId())) list.add("Id should be >= 0");
        if (!idValidator.validate(request.getSubjectId())) list.add("SubjectId should be >= 0");
        if (!dateValidator.validate(request.getDate()))
            list.add("Date should be in dd/mm/yyyy format with correct date");
        if (!idValidator.validate(request.getNumber())) list.add("Lesson number should be >= 0");
        if (!idValidator.validate(request.getTeacherId())) list.add("TeacherId should be >= 0");
        if (!idValidator.validate(request.getGroupId())) list.add("GroupId should be >= 0");
        return list;
    }
}
