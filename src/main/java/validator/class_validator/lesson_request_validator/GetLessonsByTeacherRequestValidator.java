package validator.class_validator.lesson_request_validator;

import request.lesson_request.GetLessonsByTeacherRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonsByTeacherRequestValidator implements IClassValidator<GetLessonsByTeacherRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;

    public GetLessonsByTeacherRequestValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public List<String> validate(GetLessonsByTeacherRequest request) {
        var list = new ArrayList<String>();
        dateValidator.isCorrectDate(request.getStartDate(), list, "StartDate")
                .isCorrectDate(request.getEndDate(), list, "EndDate");
        idValidator.isPositive(request.getTeacherId(), list, "TeacherId");
        return list;
    }
}
