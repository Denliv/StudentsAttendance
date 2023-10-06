package Validator.ClassValidator.LessonRequestValidator;

import Request.LessonRequest.GetLessonsByGroupRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.DateValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonsByGroupRequestValidator implements IClassValidator<GetLessonsByGroupRequest> {
    @Override
    public List<String> validate(GetLessonsByGroupRequest request) {
        var list = new ArrayList<String>();
        if (!DateValidator.validate(request.getStartDate()))
            list.add("StartDate should be in dd/mm/yyyy format with correct date");
        if (!DateValidator.validate(request.getEndDate()))
            list.add("EndDate should be in dd/mm/yyyy format with correct date");
        if (!IdValidator.validate(request.getGroupId())) list.add("GroupId should be >= 0");
        return list;
    }
}
