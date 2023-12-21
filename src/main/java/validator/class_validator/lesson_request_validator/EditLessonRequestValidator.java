package validator.class_validator.lesson_request_validator;

import request.lesson_request.EditLessonRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;

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
        idValidator.isPositive(request.getId(), list, "Id")
                .isPositive(request.getSubjectId(), list, "SubjectId")
                .isPositive(request.getNumber(), list, "Number")
                .isPositive(request.getTeacherId(), list, "TeacherId")
                .isPositive(request.getGroupId(), list, "GroupId");
        dateValidator.isCorrectDate(request.getDate(), list, "Date");
        return list;
    }
}
