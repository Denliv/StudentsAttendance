package Validator.ClassValidator.TeacherRequestValidator;

import Request.TeacherRequest.DeleteTeacherRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteTeacherRequestValidator implements IClassValidator<DeleteTeacherRequest> {
    @Override
    public List<String> validate(DeleteTeacherRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
