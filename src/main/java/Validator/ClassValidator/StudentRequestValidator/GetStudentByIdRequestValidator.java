package Validator.ClassValidator.StudentRequestValidator;

import Request.StudentRequest.GetStudentByIdRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdRequestValidator implements IClassValidator<GetStudentByIdRequest> {
    @Override
    public List<String> validate(GetStudentByIdRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
