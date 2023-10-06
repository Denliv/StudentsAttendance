package Validator.ClassValidator.StudentGroupRequestValidator;

import Request.StudentGroupRequest.GetStudentGroupByIdRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupByIdRequestValidator implements IClassValidator<GetStudentGroupByIdRequest> {
    @Override
    public List<String> validate(GetStudentGroupByIdRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
