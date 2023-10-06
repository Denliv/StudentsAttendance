package Validator.ClassValidator.LessonRequestValidator;

import Request.LessonRequest.DeleteLessonRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteLessonRequestValidator implements IClassValidator<DeleteLessonRequest> {

    @Override
    public List<String> validate(DeleteLessonRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
