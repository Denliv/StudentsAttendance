package validator.class_validator.lesson_request_validator;

import request.lesson_request.GetLessonsByGroupRequest;
import validator.class_validator.IClassValidator;
import validator.simple_validator.DateValidator;
import validator.simple_validator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonsByGroupRequestValidator implements IClassValidator<GetLessonsByGroupRequest> {
    private final IdValidator idValidator;
    private final DateValidator dateValidator;

    public GetLessonsByGroupRequestValidator(IdValidator idValidator, DateValidator dateValidator) {
        this.idValidator = idValidator;
        this.dateValidator = dateValidator;
    }

    @Override
    public List<String> validate(GetLessonsByGroupRequest request) {
        var list = new ArrayList<String>();
        dateValidator.isCorrectDate(request.getStartDate(), list, "StartDate")
                .isCorrectDate(request.getEndDate(), list, "EndDate");
        idValidator.isPositive(request.getGroupId(), list, "GroupId");
        return list;
    }
}
