package Validator.ClassValidator.LessonRequestValidator;

import Request.LessonRequest.GetLessonsByTeacherRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.DateValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonsByTeacherRequestValidator implements IClassValidator<GetLessonsByTeacherRequest> {
    @Override
    public List<String> validate(GetLessonsByTeacherRequest request) {
        var list = new ArrayList<String>();
        if (!DateValidator.validate(request.getStartDate()))
            list.add("StartDate should be in dd/mm/yyyy format with correct date");
        if (!DateValidator.validate(request.getEndDate()))
            list.add("EndDate should be in dd/mm/yyyy format with correct date");
        if (!IdValidator.validate(request.getTeacherId())) list.add("TeacherId should be >= 0");
        return list;
    }
}
