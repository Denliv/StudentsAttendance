package Validator.ClassValidator.StudentRequestValidator;

import Request.StudentRequest.GetStudentsByGroupRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsByGroupRequestValidator implements IClassValidator<GetStudentsByGroupRequest> {
    @Override
    public List<String> validate(GetStudentsByGroupRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
