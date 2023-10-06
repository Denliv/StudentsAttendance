package Validator.ClassValidator.StudentGroupRequestValidator;

import Request.StudentGroupRequest.DeleteStudentGroupRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentGroupRequestValidator implements IClassValidator<DeleteStudentGroupRequest> {
    @Override
    public List<String> validate(DeleteStudentGroupRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
