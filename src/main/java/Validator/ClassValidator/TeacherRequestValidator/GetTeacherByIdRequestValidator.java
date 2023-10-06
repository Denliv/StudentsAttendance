package Validator.ClassValidator.TeacherRequestValidator;

import Request.TeacherRequest.GetTeacherByIdRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetTeacherByIdRequestValidator implements IClassValidator<GetTeacherByIdRequest> {
    @Override
    public List<String> validate(GetTeacherByIdRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
