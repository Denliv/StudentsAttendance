package Validator.ClassValidator.StudentRequestValidator;

import Request.StudentRequest.DeleteStudentRequest;
import Validator.ClassValidator.IClassValidator;
import Validator.SimpleValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentRequestValidator implements IClassValidator<DeleteStudentRequest> {
    @Override
    public List<String> validate(DeleteStudentRequest request) {
        var list = new ArrayList<String>();
        if (!IdValidator.validate(request.getId())) list.add("Id should be >= 0");
        return list;
    }
}
