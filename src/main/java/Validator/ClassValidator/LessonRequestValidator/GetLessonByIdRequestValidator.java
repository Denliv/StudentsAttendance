package Validator.ClassValidator.LessonRequestValidator;

import Request.LessonRequest.GetLessonByIdRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByIdRequestValidator implements IClassValidator<GetLessonByIdRequest> {
    @Override
    public List<String> validate(GetLessonByIdRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
