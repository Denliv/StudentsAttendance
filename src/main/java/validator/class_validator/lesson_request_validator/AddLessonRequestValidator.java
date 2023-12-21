package validator.class_validator.lesson_request_validator;

import request.lesson_request.AddLessonRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;
import validator.simple_validator.ListValidator;

import java.util.ArrayList;
import java.util.List;

public class AddLessonRequestValidator implements IClassValidator<AddLessonRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;
    private final ListValidator listValidator;

    public AddLessonRequestValidator(IdValidator idValidator, DateValidator dateValidator, ListValidator listValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
        this.listValidator = listValidator;
    }

    @Override
    public List<String> validate(AddLessonRequest request) {
        var list = new ArrayList<String>();
        idValidator.isPositive(request.getSubjectId(), list, "SubjectId")
                .isPositive(request.getNumber(), list, "Number")
                .isPositive(request.getTeacherId(), list, "TeacherId")
                .isPositive(request.getGroupId(), list, "GroupId");
        listValidator.isNotNullAndNotContainsNull(request.getAttendanceList(), list, "AttendanceList");
        dateValidator.isCorrectDate(request.getDate(), list, "Date");
        return list;
    }
}
